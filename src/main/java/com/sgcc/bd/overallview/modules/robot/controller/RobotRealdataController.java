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
import com.sgcc.bd.overallview.modules.robot.entity.RobotRealdata;
import com.sgcc.bd.overallview.modules.robot.query.RobotRealdataQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.robot.service.RobotRealdataService;

/**
 * @desc 机器人实时数据表 controller
 * @author chenfeixiang
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/robot/robotRealdata")
@Slf4j
@ApiModel(value="RobotRealdata对象", description="机器人实时数据表")
@Api(tags = "robot-机器人实时数据表")
public class RobotRealdataController {

    @Autowired
    private RobotRealdataService robotRealdataService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<RobotRealdata> saveOrUpdate(@Valid @RequestBody RobotRealdata robotRealdata){
        try {
            robotRealdataService.saveOrUpdate(robotRealdata);
            return  ResultUtil.data(robotRealdata);
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
    public Result<Page<RobotRealdata>> list(PageVo pageVo, RobotRealdataQuery query) {
        QueryWrapper<RobotRealdata> queryWrapper = new QueryWrapper<RobotRealdata>() ;
        //TODO 条件待填写
        Page page = robotRealdataService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             robotRealdataService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<RobotRealdata> getById(BaseReqVO request) {
        try {
            RobotRealdata robotRealdata = robotRealdataService.getById(request.getId());
            return  ResultUtil.data(robotRealdata);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

