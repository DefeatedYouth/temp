package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.common.enums.EnumDeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbFeed;
import cn.exrick.xboot.modules.shebei.query.SbFeedQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbFeedService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器状态评价数据数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbFeed")
@Slf4j
@ApiModel(value="SbFeed对象", description="断路器状态评价数据数据表")
@Api(tags = "shebei-断路器状态评价数据数据表")
public class SbFeedController {

    @Autowired
    private SbFeedService sbFeedService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbFeed> saveOrUpdate(@Valid @RequestBody SbFeed sbFeed){
        try {
            sbFeedService.saveOrUpdate(sbFeed);
            return  ResultUtil.data(sbFeed);
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
    public Result<Page<SbFeed>> list(PageVo pageVo,SbFeedQuery query) {
        QueryWrapper<SbFeed> queryWrapper = new QueryWrapper<SbFeed>() ;
        queryWrapper.lambda().eq(SbFeed::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbFeed::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(query.getDeviceType()!=null,SbFeed::getDeviceType, EnumDeviceType.valueOf(query.getDeviceType()));
        queryWrapper.lambda().like(query.getEvaluationConclusion()!=null,SbFeed::getEvaluationConclusion,query.getEvaluationConclusion());
        queryWrapper.lambda().like(query.getCommissioningType()!=null,SbFeed::getCommissioningType,query.getCommissioningType());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbFeed::getCommissioningDate,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,SbFeed::getCommissioningDate,query.getEndTime());//结束时间
        queryWrapper.lambda().gt(query.getEvaluationStartTime()!= null ,SbFeed::getEvaluationDate,query.getEvaluationStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEvaluationEndTime() != null,SbFeed::getEvaluationDate,query.getEvaluationEndTime());//结束时间

        //TODO 条件待填写
        Page page = sbFeedService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbFeedService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbFeed> getById(BaseReqVO request) {
        try {
            SbFeed sbFeed = sbFeedService.getById(request.getId());
            return  ResultUtil.data(sbFeed);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

