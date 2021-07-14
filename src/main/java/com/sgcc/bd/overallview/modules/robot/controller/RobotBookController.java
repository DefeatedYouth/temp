package com.sgcc.bd.overallview.modules.robot.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotBook;
import com.sgcc.bd.overallview.modules.robot.query.RobotBookQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.robot.service.RobotBookService;

/**
 * @desc 机器人台账表 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotBook")
@Slf4j
@ApiModel(value="RobotBook对象", description="机器人台账表")
@Api(tags = "robot-机器人台账表")
public class RobotBookController {

    @Autowired
    private RobotBookService robotBookService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotBook> saveOrUpdate(@Valid @RequestBody RobotBook robotBook){
        try {
            robotBookService.saveOrUpdate(robotBook);
            return  ResultUtil.data(robotBook);
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
    public Result<Page<RobotBook>> list(PageVo pageVo, RobotBookQuery query) {
        QueryWrapper<RobotBook> queryWrapper = new QueryWrapper<RobotBook>() ;
        queryWrapper.lambda().eq(RobotBook::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,RobotBook::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getManufacturer()!=null,RobotBook::getManufacturer,query.getManufacturer());
        queryWrapper.lambda().eq(query.getDeviceState()!=null,RobotBook::getDeviceState,query.getDeviceState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotBook::getRunDate,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotBook::getRunDate,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = robotBookService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotBookService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotBook> getById(BaseReqVO request) {
        try {
            RobotBook robotBook = robotBookService.getById(request.getId());
            return  ResultUtil.data(robotBook);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

