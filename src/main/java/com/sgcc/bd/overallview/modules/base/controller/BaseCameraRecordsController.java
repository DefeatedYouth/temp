package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.base.entity.BaseCameraRecords;
import com.sgcc.bd.overallview.modules.base.query.BaseCameraRecordsQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.base.service.BaseCameraRecordsService;

/**
 * @desc  摄像机录像识别记录表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/base/baseCameraRecords")
@Slf4j
@ApiModel(value="BaseCameraRecords对象", description=" 摄像机录像识别记录表")
@Api(tags = "base- 摄像机录像识别记录表")
public class BaseCameraRecordsController {

    @Autowired
    private BaseCameraRecordsService baseCameraRecordsService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseCameraRecords> saveOrUpdate(@Valid @RequestBody BaseCameraRecords baseCameraRecords){
        try {
            baseCameraRecordsService.saveOrUpdate(baseCameraRecords);
            return  ResultUtil.data(baseCameraRecords);
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
    public Result<Page<BaseCameraRecords>> list(PageVo pageVo, BaseCameraRecordsQuery query) {
        QueryWrapper<BaseCameraRecords> queryWrapper = new QueryWrapper<BaseCameraRecords>() ;
        queryWrapper.lambda().eq(BaseCameraRecords::getSiteId,query.getSiteId());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseCameraRecords::getVideoTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseCameraRecords::getVideoTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = baseCameraRecordsService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseCameraRecordsService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseCameraRecords> getById(BaseReqVO request) {
        try {
            BaseCameraRecords baseCameraRecords = baseCameraRecordsService.getById(request.getId());
            return  ResultUtil.data(baseCameraRecords);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

