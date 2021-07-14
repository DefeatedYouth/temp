package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbFuhe;
import com.sgcc.bd.overallview.modules.shebei.query.SbFuheQuery;
import com.sgcc.bd.overallview.modules.shebei.service.SbFuheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import cn.exrick.xboot.common.utils.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 断路器负荷数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbFuhe")
@Slf4j
@ApiModel(value="SbFuhe对象", description="断路器负荷数据表")
@Api(tags = "shebei-断路器负荷数据表")
public class SbFuheController {

    @Autowired
    private SbFuheService sbFuheService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbFuhe> saveOrUpdate(@Valid @RequestBody SbFuhe sbFuhe){
        try {
            sbFuheService.saveOrUpdate(sbFuhe);
            return  ResultUtil.data(sbFuhe);
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
    public Result<Page<SbFuhe>> list(PageVo pageVo, SbFuheQuery query) {
        QueryWrapper<SbFuhe> queryWrapper = new QueryWrapper<SbFuhe>() ;
        //TODO 条件待填写
        //每个设备都有高中低压测 前端的条件查询只是让显示的数据不一样而已
        queryWrapper.lambda().eq(SbFuhe::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbFuhe::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().gt(query.getStartTime()!= null , SbFuhe::getMonitoringTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbFuhe::getMonitoringTime,query.getEndTime());
        Page page = sbFuheService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbFuheService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbFuhe> getById(BaseReqVO request) {
        try {
            SbFuhe sbFuhe = sbFuheService.getById(request.getId());
            return  ResultUtil.data(sbFuhe);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

