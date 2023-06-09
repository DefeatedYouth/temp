package com.sgcc.bd.overallview.modules.huanjing.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjFengji;
import com.sgcc.bd.overallview.modules.huanjing.query.HjFengjiQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.huanjing.service.HjFengjiService;

/**
 * @desc 风机监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjFengji")
@Slf4j
@ApiModel(value="HjFengji对象", description="风机监视表")
@Api(tags = "huanjing-风机监视表")
public class HjFengjiController {

    @Autowired
    private HjFengjiService hjFengjiService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjFengji> saveOrUpdate(@Valid @RequestBody HjFengji hjFengji){
        try {
            hjFengjiService.saveOrUpdate(hjFengji);
            return  ResultUtil.data(hjFengji);
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
    public Result<Page<HjFengji>> list(PageVo pageVo, HjFengjiQuery query) {
        QueryWrapper<HjFengji> queryWrapper = new QueryWrapper<HjFengji>() ;
        queryWrapper.lambda().eq(HjFengji::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjFengji::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjFengji::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjFengji::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjFengji::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getFengjiState()!=null,HjFengji::getFengjiState,query.getFengjiState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjFengji::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjFengji::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjFengjiService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjFengjiService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjFengji> getById(BaseReqVO request) {
        try {
            HjFengji hjFengji = hjFengjiService.getById(request.getId());
            return  ResultUtil.data(hjFengji);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


}

