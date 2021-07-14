package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbFault;
import com.sgcc.bd.overallview.modules.shebei.query.SbFaultQuery;
import com.sgcc.bd.overallview.modules.shebei.service.SbFaultService;
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
 * @desc 设备履历故障记录表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbFault")
@Slf4j
@ApiModel(value="SbFault对象", description="设备履历故障记录表")
@Api(tags = "shebei-设备履历故障记录表")
public class SbFaultController {

    @Autowired
    private SbFaultService sbFaultService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbFault> saveOrUpdate(@Valid @RequestBody SbFault sbFault){
        try {
            sbFaultService.saveOrUpdate(sbFault);
            return  ResultUtil.data(sbFault);
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
    public Result<Page<SbFault>> list(PageVo pageVo, SbFaultQuery query) {
        QueryWrapper<SbFault> queryWrapper = new QueryWrapper<SbFault>() ;
        queryWrapper.lambda().eq(SbFault::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbFault::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getType()!=null,SbFault::getType,query.getType());
        queryWrapper.lambda().like(query.getFaultNature()!=null,SbFault::getFaultNature,query.getFaultNature());
        queryWrapper.lambda().like(query.getFaultCurrent()!=null, SbFault::getFaultCurrent,query.getFaultCurrent());
        queryWrapper.lambda().like(query.getFaultPhase()!=null,SbFault::getFaultPhase,query.getFaultPhase());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbFault::getBreakdownTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,SbFault::getBreakdownTime,query.getEndTime());//结束时间

        //TODO 条件待填写
        Page page = sbFaultService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbFaultService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbFault> getById(BaseReqVO request) {
        try {
            SbFault sbFault = sbFaultService.getById(request.getId());
            return  ResultUtil.data(sbFault);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

