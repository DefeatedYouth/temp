package com.sgcc.bd.overallview.modules.huanjing.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShuiweiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuiwei;
import com.sgcc.bd.overallview.modules.huanjing.query.HjShuiweiQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 水位传感器监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjShuiwei")
@Slf4j
@ApiModel(value="HjShuiwei对象", description="水位传感器监视表")
@Api(tags = "huanjing-水位传感器监视表")
public class HjShuiweiController {

    @Autowired
    private HjShuiweiService hjShuiweiService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjShuiwei> saveOrUpdate(@Valid @RequestBody HjShuiwei hjShuiwei){
        try {
            hjShuiweiService.saveOrUpdate(hjShuiwei);
            return  ResultUtil.data(hjShuiwei);
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
    public Result<Page<HjShuiwei>> list(PageVo pageVo, HjShuiweiQuery query) {
        QueryWrapper<HjShuiwei> queryWrapper = new QueryWrapper<HjShuiwei>() ;
        queryWrapper.lambda().eq(HjShuiwei::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjShuiwei::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjShuiwei::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjShuiwei::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjShuiwei::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getShuiweiValue()!=null,HjShuiwei::getShuiweiValue,query.getShuiweiValue());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjShuiwei::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjShuiwei::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjShuiweiService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjShuiweiService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjShuiwei> getById(BaseReqVO request) {
        try {
            HjShuiwei hjShuiwei = hjShuiweiService.getById(request.getId());
            return  ResultUtil.data(hjShuiwei);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "水位设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjShuiweiService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

