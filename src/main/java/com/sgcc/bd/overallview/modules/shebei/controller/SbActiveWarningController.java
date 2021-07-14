package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbActiveWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.shebei.query.SbActiveWarningQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.shebei.service.SbActiveWarningService;

/**
 * @desc 设备主动预警表 controller
 * @author chenfeixiang
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/shebei/sbActiveWarning")
@Slf4j
@ApiModel(value="SbActiveWarning对象", description="设备主动预警表")
@Api(tags = "shebei-设备主动预警表")
public class SbActiveWarningController {

    @Autowired
    private SbActiveWarningService sbActiveWarningService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbActiveWarning> saveOrUpdate(@Valid @RequestBody SbActiveWarning sbActiveWarning){
        try {
            sbActiveWarningService.saveOrUpdate(sbActiveWarning);
            return  ResultUtil.data(sbActiveWarning);
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
    public Result<Page<SbActiveWarning>> list(PageVo pageVo, SbActiveWarningQuery query) {
        QueryWrapper<SbActiveWarning> queryWrapper = new QueryWrapper<SbActiveWarning>() ;
        //TODO 条件待填写
        Page page = sbActiveWarningService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbActiveWarningService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbActiveWarning> getById(BaseReqVO request) {
        try {
            SbActiveWarning sbActiveWarning = sbActiveWarningService.getById(request.getId());
            return  ResultUtil.data(sbActiveWarning);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

