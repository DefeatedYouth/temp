package cn.exrick.xboot.modules.base.controller;

import cn.exrick.xboot.modules.base.dto.BaseSiteDTO;
import cn.exrick.xboot.modules.base.entity.BasePlace;
import cn.exrick.xboot.modules.base.query.BasePlaceQuery;
import cn.exrick.xboot.modules.base.service.BasePlaceService;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BaseSite;
import cn.exrick.xboot.modules.base.query.BaseSiteQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BaseSiteService;

import java.util.ArrayList;
import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 站点表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/base/baseSite")
@Slf4j
@ApiModel(value="BaseSite对象", description="站点表")
@Api(tags = "base-站点表")
public class BaseSiteController {

    @Autowired
    private BaseSiteService baseSiteService;

    @Autowired
    private BasePlaceService basePlaceService;
    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseSite> saveOrUpdate(@Valid @RequestBody BaseSite baseSite){
        try {
            baseSiteService.saveOrUpdate(baseSite);
            return  ResultUtil.data(baseSite);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
    /**
     * @desc 分页列表查询
     * @param query 分页查询对象
     * @return 分页结果集
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<Page<BaseSite>> list(PageVo pageVo,BaseSiteQuery query) {
        QueryWrapper<BaseSite> queryWrapper = new QueryWrapper<BaseSite>() ;


        //TODO 条件待填写
        Page page = baseSiteService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

  /*  @ApiOperation("首页一次选择页面")
    @GetMapping("/getList")
    public Result<List<BaseSiteDTO>> getList(BaseSiteQuery query) {
        List<BaseSiteDTO> baseSiteDTOList = new ArrayList<>();
        //第一层 level 传入1 返回所有的
        //第二层 parentId 传入上级id  level 传入2 返回所有二级
        //第三层 level 传入3 parentId 传入上级id
        if (query.getLevel()==1&&query.getLevel()==2){
            List<BasePlace> basePlaces = basePlaceService.getBaseMapper().selectList(new QueryWrapper<BasePlace>().lambda()
                    .eq(query.getLevel()!=null,BasePlace::getLevel, query.getLevel())
                    .eq(query.getFirstId()!=null,BasePlace::getParentId,query.getFirstId())
            );
            basePlaces.forEach(basePlace ->{
                BaseSiteDTO baseSiteDTO = new BaseSiteDTO();
                baseSiteDTO.setId(basePlace.getId());
                baseSiteDTO.setName(basePlace.getName());
                baseSiteDTOList.add(baseSiteDTO);
            });
            return ResultUtil.data(baseSiteDTOList);
        }else {
            List<BaseSite> baseSites = baseSiteService.getBaseMapper().selectList(new QueryWrapper<BaseSite>().lambda()
                            .eq(query.getSecendId()!=null,BaseSite::getPlaceId, query.getSecendId())
                            .eq(query.getVoltageLevel()!=null,BaseSite::getVoltageLevel, query.getVoltageLevel())
                    //  .eq(query.getParentId()!=null,BasePlace::getParentId,query.getParentId())
            );
            baseSites.forEach(baseSite -> {
                BaseSiteDTO baseSiteDTO = new BaseSiteDTO();
                baseSiteDTO.setId(baseSite.getId());
                baseSiteDTO.setName(baseSite.getSiteName());
                baseSiteDTOList.add(baseSiteDTO);
            });
            return ResultUtil.data(baseSiteDTOList);
        }
    }*/

    @ApiOperation("首页一次选择页面")
    @GetMapping("/getList")
    public Result<List<BaseSiteDTO>> getList(BaseSiteQuery query) {
        List<BaseSiteDTO> baseSiteDTOList = new ArrayList<>();
        List<BaseSite> baseSites = baseSiteService.getBaseMapper().selectList(new QueryWrapper<BaseSite>().lambda()
                .eq(query.getParentId() != null, BaseSite::getParentId, query.getParentId())
                .eq(query.getFirstId() != null, BaseSite::getPlaceId, query.getPlaceId())
                .eq(query.getSecendId() != null, BaseSite::getDepartmentId, query.getSecendId())
                .eq(query.getThreeId() != null, BaseSite::getVoltageLevel, query.getThreeId())
        );
        baseSites.forEach(baseSite -> {
            BaseSiteDTO baseSiteDTO = new BaseSiteDTO();
            baseSiteDTO.setId(baseSite.getId());
            baseSiteDTO.setName(baseSite.getSiteName());
            baseSiteDTOList.add(baseSiteDTO);
        });

        return ResultUtil.data(baseSiteDTOList);
    }

    @ApiOperation("所有电压等级")
    @GetMapping("/getVoltageLevel")
    public Result<List<BaseSite>> list() {
        QueryWrapper<BaseSite> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.lambda().groupBy(BaseSite::getVoltageLevel);
        queryWrapper.lambda().select(BaseSite::getVoltageLevel);
        List<BaseSite> list = baseSiteService.list(queryWrapper);
        return ResultUtil.data(list);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseSiteService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseSite> getById(BaseReqVO request) {
        try {
            BaseSite baseSite = baseSiteService.getById(request.getId());
            return  ResultUtil.data(baseSite);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

