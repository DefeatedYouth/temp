package cn.exrick.xboot.modules.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.robot.entity.RobotAlarm;
import cn.exrick.xboot.modules.robot.query.RobotAlarmQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.robot.service.RobotAlarmService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 机器人本体告警表 controller
 * @author chenfeixiang
 * @since 2021-06-08
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
    public Result<Page<RobotAlarm>> list(PageVo pageVo,RobotAlarmQuery query) {
        QueryWrapper<RobotAlarm> queryWrapper = new QueryWrapper<RobotAlarm>() ;
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
