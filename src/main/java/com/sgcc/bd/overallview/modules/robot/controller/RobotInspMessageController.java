package com.sgcc.bd.overallview.modules.robot.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspMessage;
import com.sgcc.bd.overallview.modules.robot.query.RobotInspMessageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspMessageService;

/**
 * @desc 机器人巡视报文表 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotInspMessage")
@Slf4j
@ApiModel(value="RobotInspMessage对象", description="机器人巡视报文表")
@Api(tags = "robot-机器人巡视报文表")
public class RobotInspMessageController {

    @Autowired
    private RobotInspMessageService robotInspMessageService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotInspMessage> saveOrUpdate(@Valid @RequestBody RobotInspMessage robotInspMessage){
        try {
            robotInspMessageService.saveOrUpdate(robotInspMessage);
            return  ResultUtil.data(robotInspMessage);
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
    public Result<Page<RobotInspMessage>> list(PageVo pageVo, RobotInspMessageQuery query) {
        QueryWrapper<RobotInspMessage> queryWrapper = new QueryWrapper<RobotInspMessage>() ;

        queryWrapper.lambda().eq(RobotInspMessage::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getInspName()!=null,RobotInspMessage::getInspName,query.getInspName());
        queryWrapper.lambda().like(query.getRobotName()!=null,RobotInspMessage::getRobotName,query.getRobotName());
        queryWrapper.lambda().like(query.getInspPoints()!=null,RobotInspMessage::getInspPoints,query.getInspPoints());
        queryWrapper.lambda().like(query.getInspType()!=null,RobotInspMessage::getInspType,query.getInspType());
        queryWrapper.lambda().like(query.getInspResult()!=null,RobotInspMessage::getInspResult,query.getInspResult());
        queryWrapper.lambda().eq(query.getAlarmLevel()!=null,RobotInspMessage::getAlarmLevel,query.getAlarmLevel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotInspMessage::getInspTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotInspMessage::getInspTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = robotInspMessageService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotInspMessageService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotInspMessage> getById(BaseReqVO request) {
        try {
            RobotInspMessage robotInspMessage = robotInspMessageService.getById(request.getId());
            return  ResultUtil.data(robotInspMessage);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

