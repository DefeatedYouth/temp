package com.sgcc.bd.overallview.modules.overview.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.robot.entity.RobotAlarm;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspMessage;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspRecords;
import com.sgcc.bd.overallview.modules.robot.entity.RobotRealdata;
import com.sgcc.bd.overallview.modules.robot.query.RobotAlarmQuery;
import com.sgcc.bd.overallview.modules.robot.query.RobotInspMessageQuery;
import com.sgcc.bd.overallview.modules.robot.query.RobotInspRecordsQuery;
import com.sgcc.bd.overallview.modules.robot.service.RobotAlarmService;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspMessageService;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspRecordsService;
import com.sgcc.bd.overallview.modules.robot.service.RobotRealdataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @desc 机器人机器人首页 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot")
@Slf4j
@ApiModel(value="robot", description="机器人首页")
@Api(tags = "机器人首页")
public class RobotController {

    @Autowired
    private RobotAlarmService robotAlarmService;

    @Autowired
    private RobotRealdataService robotRealdataService;
    @Autowired
    private RobotInspMessageService robotInspMessageService;
    @Autowired
    private RobotInspRecordsService robotInspRecordsService;


    @ApiOperation("获取机器人实时数据")
    @GetMapping("/getRobotDetail")
    public Result<RobotRealdata> getRobotDetail(BaseReqVO request) {
        try {
            RobotRealdata robotRealdata = robotRealdataService.getById(request.getId());
            return  ResultUtil.data(robotRealdata);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("巡视任务表单")
    @GetMapping("/tourTaskForm")
    public Result<Page<RobotInspMessage>> tourTaskForm(PageVo pageVo, RobotInspMessageQuery query) {
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

    @ApiOperation("巡视监视")
    @GetMapping("/patrolSurveillance")
    public Result<Page<RobotInspRecords>> patrolSurveillance(PageVo pageVo, RobotInspRecordsQuery query) {
        QueryWrapper<RobotInspRecords> queryWrapper = new QueryWrapper<RobotInspRecords>() ;

        queryWrapper.lambda().eq(RobotInspRecords::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getRobotName()!=null,RobotInspRecords::getRobotName,query.getRobotName());
        queryWrapper.lambda().like(query.getInspName()!=null,RobotInspRecords::getInspName,query.getInspName());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotInspRecords::getInspTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotInspRecords::getInspTime,query.getEndTime());//结束时间

        //TODO 条件待填写
        Page page = robotInspRecordsService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }
}

