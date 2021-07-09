package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.modules.shebei.entity.SbSparePartsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbToolMonitoring;
import cn.exrick.xboot.modules.shebei.query.SbToolMonitoringQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbToolMonitoringService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 工器具监视表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/shebei/sbToolMonitoring")
@Slf4j
@ApiModel(value="SbToolMonitoring对象", description="工器具监视表")
@Api(tags = "shebei-工器具监视表")
public class SbToolMonitoringController {

    @Autowired
    private SbToolMonitoringService sbToolMonitoringService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbToolMonitoring> saveOrUpdate(@Valid @RequestBody SbToolMonitoring sbToolMonitoring){
        try {
            sbToolMonitoringService.saveOrUpdate(sbToolMonitoring);
            return  ResultUtil.data(sbToolMonitoring);
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
    public Result<Page<SbToolMonitoring>> list(PageVo pageVo,SbToolMonitoringQuery query) {
        QueryWrapper<SbToolMonitoring> queryWrapper = new QueryWrapper<SbToolMonitoring>() ;
        //TODO 条件待填写
        queryWrapper.lambda().eq(query.getSiteId()!=null, SbToolMonitoring::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbToolMonitoring::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getSpecificationModel()!=null,SbToolMonitoring::getSpecificationModel,query.getSpecificationModel());
        queryWrapper.lambda().eq(query.getIsOverdue()!=null,SbToolMonitoring::getIsOverdue,query.getIsOverdue());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbToolMonitoring::getLastTestDate,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,SbToolMonitoring::getLastTestDate,query.getEndTime());//结束时间

        Page page = sbToolMonitoringService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbToolMonitoringService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbToolMonitoring> getById(BaseReqVO request) {
        try {
            SbToolMonitoring sbToolMonitoring = sbToolMonitoringService.getById(request.getId());
            return  ResultUtil.data(sbToolMonitoring);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

