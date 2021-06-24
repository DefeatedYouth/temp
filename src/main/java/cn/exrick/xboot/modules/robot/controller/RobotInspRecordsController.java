package cn.exrick.xboot.modules.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.robot.entity.RobotInspRecords;
import cn.exrick.xboot.modules.robot.query.RobotInspRecordsQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.robot.service.RobotInspRecordsService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 机器人巡视记录表 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotInspRecords")
@Slf4j
@ApiModel(value="RobotInspRecords对象", description="机器人巡视记录表")
@Api(tags = "robot-机器人巡视记录表")
public class RobotInspRecordsController {

    @Autowired
    private RobotInspRecordsService robotInspRecordsService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotInspRecords> saveOrUpdate(@Valid @RequestBody RobotInspRecords robotInspRecords){
        try {
            robotInspRecordsService.saveOrUpdate(robotInspRecords);
            return  ResultUtil.data(robotInspRecords);
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
    public Result<Page<RobotInspRecords>> list(PageVo pageVo,RobotInspRecordsQuery query) {
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

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotInspRecordsService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotInspRecords> getById(BaseReqVO request) {
        try {
            RobotInspRecords robotInspRecords = robotInspRecordsService.getById(request.getId());
            return  ResultUtil.data(robotInspRecords);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

