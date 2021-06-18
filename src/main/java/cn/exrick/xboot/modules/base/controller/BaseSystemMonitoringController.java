package cn.exrick.xboot.modules.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BaseSystemMonitoring;
import cn.exrick.xboot.modules.base.query.BaseSystemMonitoringQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BaseSystemMonitoringService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 交直流系统监视表 controller
 * @author chenfeixiang
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/base/baseSystemMonitoring")
@Slf4j
@ApiModel(value="BaseSystemMonitoring对象", description="交直流系统监视表")
@Api(tags = "base-交直流系统监视表")
public class BaseSystemMonitoringController {

    @Autowired
    private BaseSystemMonitoringService baseSystemMonitoringService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseSystemMonitoring> saveOrUpdate(@Valid @RequestBody BaseSystemMonitoring baseSystemMonitoring){
        try {
            baseSystemMonitoringService.saveOrUpdate(baseSystemMonitoring);
            return  ResultUtil.data(baseSystemMonitoring);
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
    public Result<Page<BaseSystemMonitoring>> list(PageVo pageVo,BaseSystemMonitoringQuery query) {
        QueryWrapper<BaseSystemMonitoring> queryWrapper = new QueryWrapper<BaseSystemMonitoring>() ;
        //TODO 条件待填写
        Page page = baseSystemMonitoringService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseSystemMonitoringService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseSystemMonitoring> getById(BaseReqVO request) {
        try {
            BaseSystemMonitoring baseSystemMonitoring = baseSystemMonitoringService.getById(request.getId());
            return  ResultUtil.data(baseSystemMonitoring);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

