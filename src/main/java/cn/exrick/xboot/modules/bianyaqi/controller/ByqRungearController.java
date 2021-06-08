package cn.exrick.xboot.modules.bianyaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqRungear;
import cn.exrick.xboot.modules.bianyaqi.query.ByqRungearQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.bianyaqi.service.ByqRungearService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 变压器运行档位表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/bianyaqi/byqRungear")
@Slf4j
@ApiModel(value="ByqRungear对象", description="变压器运行档位表")
@Api(tags = "bianyaqi-变压器运行档位表")
public class ByqRungearController {

    @Autowired
    private ByqRungearService byqRungearService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<ByqRungear> saveOrUpdate(@Valid @RequestBody ByqRungear byqRungear){
        try {
            byqRungearService.saveOrUpdate(byqRungear);
            return  ResultUtil.data(byqRungear);
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
    public Result<Page<ByqRungear>> list(PageVo pageVo,ByqRungearQuery query) {
        QueryWrapper<ByqRungear> queryWrapper = new QueryWrapper<ByqRungear>() ;
        //TODO 条件待填写
        Page page = byqRungearService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             byqRungearService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<ByqRungear> getById(BaseReqVO request) {
        try {
            ByqRungear byqRungear = byqRungearService.getById(request.getId());
            return  ResultUtil.data(byqRungear);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

