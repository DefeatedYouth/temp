package cn.exrick.xboot.modules.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.job.entity.JobTicket;
import cn.exrick.xboot.modules.job.query.JobTicketQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.job.service.JobTicketService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 工作票表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/job/jobTicket")
@Slf4j
@ApiModel(value="JobTicket对象", description="工作票表")
@Api(tags = "job-工作票表")
public class JobTicketController {

    @Autowired
    private JobTicketService jobTicketService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobTicket> saveOrUpdate(@Valid @RequestBody JobTicket jobTicket){
        try {
            jobTicketService.saveOrUpdate(jobTicket);
            return  ResultUtil.data(jobTicket);
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
    public Result<Page<JobTicket>> list(PageVo pageVo,JobTicketQuery query) {
        QueryWrapper<JobTicket> queryWrapper = new QueryWrapper<JobTicket>() ;
        //TODO 条件待填写
        Page page = jobTicketService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobTicketService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobTicket> getById(BaseReqVO request) {
        try {
            JobTicket jobTicket = jobTicketService.getById(request.getId());
            return  ResultUtil.data(jobTicket);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

