package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.base.entity.BaseDeviceToCamera;
import com.sgcc.bd.overallview.modules.base.query.BaseDeviceToCameraQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.base.service.BaseDeviceToCameraService;

/**
 * @desc 设备与摄像机的关联表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/base/baseDeviceToCamera")
@Slf4j
@ApiModel(value="BaseDeviceToCamera对象", description="设备与摄像机的关联表")
@Api(tags = "base-设备与摄像机的关联表")
public class BaseDeviceToCameraController {

    @Autowired
    private BaseDeviceToCameraService baseDeviceToCameraService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseDeviceToCamera> saveOrUpdate(@Valid @RequestBody BaseDeviceToCamera baseDeviceToCamera){
        try {
            baseDeviceToCameraService.saveOrUpdate(baseDeviceToCamera);
            return  ResultUtil.data(baseDeviceToCamera);
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
    public Result<Page<BaseDeviceToCamera>> list(PageVo pageVo, BaseDeviceToCameraQuery query) {
        QueryWrapper<BaseDeviceToCamera> queryWrapper = new QueryWrapper<BaseDeviceToCamera>() ;
        //TODO 条件待填写
        Page page = baseDeviceToCameraService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseDeviceToCameraService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseDeviceToCamera> getById(BaseReqVO request) {
        try {
            BaseDeviceToCamera baseDeviceToCamera = baseDeviceToCameraService.getById(request.getId());
            return  ResultUtil.data(baseDeviceToCamera);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

