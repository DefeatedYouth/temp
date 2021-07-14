package com.sgcc.bd.overallview.modules.huanjing.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShuishengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuisheng;
import com.sgcc.bd.overallview.modules.huanjing.query.HjShuishengQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 水浸传感器监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjShuisheng")
@Slf4j
@ApiModel(value="HjShuisheng对象", description="水浸传感器监视表")
@Api(tags = "huanjing-水浸传感器监视表")
public class HjShuishengController {

    @Autowired
    private HjShuishengService hjShuishengService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjShuisheng> saveOrUpdate(@Valid @RequestBody HjShuisheng hjShuisheng){
        try {
            hjShuishengService.saveOrUpdate(hjShuisheng);
            return  ResultUtil.data(hjShuisheng);
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
    public Result<Page<HjShuisheng>> list(PageVo pageVo, HjShuishengQuery query) {
        QueryWrapper<HjShuisheng> queryWrapper = new QueryWrapper<HjShuisheng>() ;
        queryWrapper.lambda().eq(HjShuisheng::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjShuisheng::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjShuisheng::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjShuisheng::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjShuisheng::getNoteType,query.getNoteType());
       // queryWrapper.lambda().eq(query.getShuiweiValue()!=null,HjShuisheng::getShuiweiValue,query.getShuiweiValue());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjShuisheng::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjShuisheng::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjShuishengService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjShuishengService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjShuisheng> getById(BaseReqVO request) {
        try {
            HjShuisheng hjShuisheng = hjShuishengService.getById(request.getId());
            return  ResultUtil.data(hjShuisheng);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "水位设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjShuishengService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

