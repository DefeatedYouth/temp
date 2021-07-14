package com.sgcc.bd.overallview.modules.robot.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.utils.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotAlarm;
import com.sgcc.bd.overallview.modules.robot.query.RobotAlarmQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.robot.service.RobotAlarmService;

/**
 * @desc 机器人本体告警表 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotAlarm")
@Slf4j
@ApiModel(value="RobotAlarm对象", description="机器人本体告警表")
@Api(tags = "robot-机器人本体告警表")
public class RobotAlarmController {

    @Autowired
    private RobotAlarmService robotAlarmService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotAlarm> saveOrUpdate(@Valid @RequestBody RobotAlarm robotAlarm){
        try {
            robotAlarmService.saveOrUpdate(robotAlarm);
            return  ResultUtil.data(robotAlarm);
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
    public Result<Page<RobotAlarm>> list(PageVo pageVo, RobotAlarmQuery query) {
        QueryWrapper<RobotAlarm> queryWrapper = new QueryWrapper<RobotAlarm>() ;
        queryWrapper.lambda().eq(RobotAlarm::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getRobotName()!=null,RobotAlarm::getRobotName,query.getRobotName());
        queryWrapper.lambda().eq(query.getAlarmType()!=null,RobotAlarm::getAlarmType,query.getAlarmType());
        queryWrapper.lambda().eq(query.getAlarmState()!=null,RobotAlarm::getAlarmState,query.getAlarmState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotAlarm::getFindTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotAlarm::getFindTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = robotAlarmService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotAlarmService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotAlarm> getById(BaseReqVO request) {
        try {
            RobotAlarm robotAlarm = robotAlarmService.getById(request.getId());
            return  ResultUtil.data(robotAlarm);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

