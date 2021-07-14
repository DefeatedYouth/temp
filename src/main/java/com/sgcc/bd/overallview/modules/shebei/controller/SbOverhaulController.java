package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbOverhaul;
import com.sgcc.bd.overallview.modules.shebei.query.SbOverhaulQuery;
import com.sgcc.bd.overallview.modules.shebei.service.SbOverhaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 断路器履历检修信息表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbOverhaul")
@Slf4j
@ApiModel(value="SbOverhaul对象", description="断路器履历检修信息表")
@Api(tags = "shebei-断路器履历检修信息表")
public class SbOverhaulController {

    @Autowired
    private SbOverhaulService sbOverhaulService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbOverhaul> saveOrUpdate(@Valid @RequestBody SbOverhaul sbOverhaul){
        try {
            sbOverhaulService.saveOrUpdate(sbOverhaul);
            return  ResultUtil.data(sbOverhaul);
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
    public Result<Page<SbOverhaul>> list(PageVo pageVo, SbOverhaulQuery query) {

        QueryWrapper<SbOverhaul> queryWrapper = new QueryWrapper<SbOverhaul>() ;
        queryWrapper.lambda().eq(SbOverhaul::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getWorkTicketNumber()!=null,SbOverhaul::getWorkTicketNumber,query.getWorkTicketNumber());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbOverhaul::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getWorkingTeam()!=null,SbOverhaul::getWorkingTeam,query.getWorkingTeam());
        queryWrapper.lambda().like(query.getWorkContent()!=null,SbOverhaul::getWorkContent,query.getWorkContent());
        queryWrapper.lambda().like(query.getWorkCharge()!=null,SbOverhaul::getWorkCharge,query.getWorkCharge());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbOverhaul::getWorkDate,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,SbOverhaul::getWorkDate,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = sbOverhaulService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbOverhaulService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbOverhaul> getById(BaseReqVO request) {
        try {
            SbOverhaul sbOverhaul = sbOverhaulService.getById(request.getId());
            return  ResultUtil.data(sbOverhaul);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

