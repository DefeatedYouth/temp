package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.enums.EnumDefectStatus;
import com.sgcc.bd.overallview.common.enums.EnumDeviceType;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbDefect;
import com.sgcc.bd.overallview.modules.shebei.query.SbDefectQuery;
import com.sgcc.bd.overallview.modules.shebei.service.SbDefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 断路器缺陷信息表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbDefect")
@Slf4j
@ApiModel(value="SbDefect对象", description="断路器缺陷信息表")
@Api(tags = "shebei-断路器缺陷信息表")
public class SbDefectController {

    @Autowired
    private SbDefectService sbDefectService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbDefect> saveOrUpdate(@Valid @RequestBody SbDefect sbDefect){
        try {
            sbDefectService.saveOrUpdate(sbDefect);
            return  ResultUtil.data(sbDefect);
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
    public Result<Page<SbDefect>> list(PageVo pageVo, SbDefectQuery query) {
        QueryWrapper<SbDefect> queryWrapper = new QueryWrapper<SbDefect>() ;
        //TODO 条件待填写
        queryWrapper.lambda().eq(SbDefect::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDefectDevice()!=null,SbDefect::getDefectDevice,query.getDefectDevice());
        queryWrapper.lambda().eq(query.getDeviceType()!=null,SbDefect::getDeviceType, EnumDeviceType.valueOf(query.getDeviceType()));
        queryWrapper.lambda().like(query.getDefectsNature()!=null,SbDefect::getDefectsNature,query.getDefectsNature());
        queryWrapper.lambda().eq(query.getDefectLevel()!=null,SbDefect::getDefectLevel,EnumDefectStatus.valueOf(query.getDefectLevel()));
        queryWrapper.lambda().like(query.getDiscoveryTeam()!=null,SbDefect::getDiscoveryTeam,query.getDiscoveryTeam());
        queryWrapper.lambda().like(query.getSendMan()!=null,SbDefect::getSendMan,query.getSendMan());
        queryWrapper.lambda().gt(query.getStartTime()!= null , SbDefect::getSendDate,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbDefect::getSendDate,query.getEndTime());
        Page page = sbDefectService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbDefectService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbDefect> getById(BaseReqVO request) {
        try {
            SbDefect sbDefect = sbDefectService.getById(request.getId());
            return  ResultUtil.data(sbDefect);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }



}

