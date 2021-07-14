package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.base.entity.BaseCamera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.utils.*;
import com.sgcc.bd.overallview.modules.base.query.BaseCameraQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.base.service.BaseCameraService;

/**
 * @desc  摄像机表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/base/baseCamera")
@Slf4j
@ApiModel(value="BaseCamera对象", description=" 摄像机表")
@Api(tags = "base- 摄像机表")
public class BaseCameraController {

    @Autowired
    private BaseCameraService baseCameraService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseCamera> saveOrUpdate(@Valid @RequestBody BaseCamera baseCamera){
        try {
            baseCameraService.saveOrUpdate(baseCamera);
            return  ResultUtil.data(baseCamera);
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
    public Result<Page<BaseCamera>> list(PageVo pageVo, BaseCameraQuery query) {
        QueryWrapper<BaseCamera> queryWrapper = new QueryWrapper<BaseCamera>() ;
        //TODO 条件待填写
        Page page = baseCameraService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseCameraService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseCamera> getById(BaseReqVO request) {
        try {
            BaseCamera baseCamera = baseCameraService.getById(request.getId());
            return  ResultUtil.data(baseCamera);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

