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
import com.sgcc.bd.overallview.modules.huanjing.entity.HjDengguang;
import com.sgcc.bd.overallview.modules.huanjing.query.HjDengguangQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.huanjing.service.HjDengguangService;

/**
 * @desc 灯光监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjDengguang")
@Slf4j
@ApiModel(value="HjDengguang对象", description="灯光监视表")
@Api(tags = "huanjing-灯光监视表")
public class HjDengguangController {

    @Autowired
    private HjDengguangService hjDengguangService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjDengguang> saveOrUpdate(@Valid @RequestBody HjDengguang hjDengguang){
        try {
            hjDengguangService.saveOrUpdate(hjDengguang);
            return  ResultUtil.data(hjDengguang);
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
    public Result<Page<HjDengguang>> list(PageVo pageVo, HjDengguangQuery query) {
        QueryWrapper<HjDengguang> queryWrapper = new QueryWrapper<HjDengguang>() ;
        queryWrapper.lambda().eq(HjDengguang::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjDengguang::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjDengguang::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjDengguang::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjDengguang::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getSwitchState()!=null,HjDengguang::getSwitchState,query.getSwitchState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjDengguang::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjDengguang::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjDengguangService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjDengguangService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjDengguang> getById(BaseReqVO request) {
        try {
            HjDengguang hjDengguang = hjDengguangService.getById(request.getId());
            return  ResultUtil.data(hjDengguang);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


}

