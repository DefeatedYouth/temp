package cn.exrick.xboot.modules.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.robot.entity.RobotResume;
import cn.exrick.xboot.modules.robot.query.RobotResumeQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.robot.service.RobotResumeService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 机器人履历 controller
 * @author chenfeixiang
 * @since 2021-06-08
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
    public Result<Page<RobotResume>> list(PageVo pageVo,RobotResumeQuery query) {
        QueryWrapper<RobotResume> queryWrapper = new QueryWrapper<RobotResume>() ;
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
