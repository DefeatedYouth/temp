package com.sgcc.bd.overallview.modules.robot.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotResume;
import com.sgcc.bd.overallview.modules.robot.query.RobotResumeQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.robot.service.RobotResumeService;

/**
 * @desc 机器人履历 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotResume")
@Slf4j
@ApiModel(value="RobotResume对象", description="机器人履历")
@Api(tags = "robot-机器人履历")
public class RobotResumeController {

    @Autowired
    private RobotResumeService robotResumeService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotResume> saveOrUpdate(@Valid @RequestBody RobotResume robotResume){
        try {
            robotResumeService.saveOrUpdate(robotResume);
            return  ResultUtil.data(robotResume);
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
    public Result<Page<RobotResume>> list(PageVo pageVo, RobotResumeQuery query) {
        QueryWrapper<RobotResume> queryWrapper = new QueryWrapper<RobotResume>() ;
        queryWrapper.lambda().eq(RobotResume::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,RobotResume::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(query.getRequestType()!=null,RobotResume::getRequestType,query.getRequestType());
        queryWrapper.lambda().like(query.getRequestPerson()!=null,RobotResume::getRequestPerson,query.getRequestPerson());
        queryWrapper.lambda().like(query.getRepairOrgname()!=null,RobotResume::getRepairOrgname,query.getRepairOrgname());
        queryWrapper.lambda().like(query.getRepairTime()!=null,RobotResume::getRepairTime,query.getRepairTime());
        queryWrapper.lambda().like(query.getCheckPerson()!=null,RobotResume::getCheckPerson,query.getCheckPerson());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotResume::getRequestTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotResume::getRequestTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = robotResumeService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotResumeService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotResume> getById(BaseReqVO request) {
        try {
            RobotResume robotResume = robotResumeService.getById(request.getId());
            return  ResultUtil.data(robotResume);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

