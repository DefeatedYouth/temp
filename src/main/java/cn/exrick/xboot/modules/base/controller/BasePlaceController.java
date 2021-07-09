package cn.exrick.xboot.modules.base.controller;

import cn.exrick.xboot.common.enums.EnumOrganizationLevel;
import cn.exrick.xboot.common.vo.MunicipalCompanyVO;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BasePlace;
import cn.exrick.xboot.modules.base.query.BasePlaceQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BasePlaceService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc  controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/base/basePlace")
@Slf4j
@ApiModel(value="BasePlace对象", description="区域地点表")
@Api(tags = "base-区域地点表")
public class BasePlaceController {

    @Autowired
    private BasePlaceService basePlaceService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BasePlace> saveOrUpdate(@Valid @RequestBody BasePlace basePlace){
        try {
            basePlaceService.saveOrUpdate(basePlace);
            return  ResultUtil.data(basePlace);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
    /**
     * @desc 分页列表查询
     * @param query 分页查询对象
     * @return 分页结果集
     */
/*    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<Page<BasePlace>> list(PageVo pageVo,BasePlaceQuery query) {
        QueryWrapper<BasePlace> queryWrapper = new QueryWrapper<BasePlace>() ;
        //TODO 条件待填写

        Page page = basePlaceService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }*/

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<List<BasePlace>> list(BasePlaceQuery query) {
        //第一层级 level 传1  后面的不传
        //第二层级 传parentId 跟level =2
        //第三层级 传parentId 跟level =3
        QueryWrapper<BasePlace> queryWrapper = new QueryWrapper<BasePlace>() ;
        queryWrapper.lambda().eq(BasePlace::getLevel, query.getLevel());
        queryWrapper.lambda().eq(query.getParentId()!=null,BasePlace::getParentId, query.getParentId());
        List<BasePlace> basePlaces = basePlaceService.getBaseMapper().selectList(queryWrapper);
        return ResultUtil.data(basePlaces);
    }




    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             basePlaceService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BasePlace> getById(BaseReqVO request) {
        try {
            BasePlace basePlace = basePlaceService.getById(request.getId());
            return  ResultUtil.data(basePlace);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation(value = "查询所有的地市公司列表",notes = "level 查询层级 1 地市公司 2 工区 3 班组 ，parentId 父级id 没有就不传 ,电压等级voltageLevel 没有就不传")
    @GetMapping("/getMunicipalCompany")
    public Result<List<BasePlace>> getMunicipalCompany(MunicipalCompanyVO municipalCompanyVO) {
        try {
            List<BasePlace> municipalCompany = basePlaceService.getMunicipalCompany(municipalCompanyVO);
            return  ResultUtil.data(municipalCompany);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

