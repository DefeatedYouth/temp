package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.common.enums.EnumAlarmType;
import cn.exrick.xboot.common.enums.EnumDangerStatus;
import cn.exrick.xboot.common.enums.EnumDefectStatus;
import cn.exrick.xboot.common.enums.EnumDeviceType;
import cn.exrick.xboot.modules.shebei.dto.SbDefectDTO;
import cn.exrick.xboot.modules.shebei.entity.SbAlarm;
import cn.exrick.xboot.modules.shebei.entity.SbDefect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbDanger;
import cn.exrick.xboot.modules.shebei.query.SbDangerQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbDangerService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器隐患信息表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbDanger")
@Slf4j
@ApiModel(value="SbDanger对象", description="断路器隐患信息表")
@Api(tags = "shebei-断路器隐患信息表")
public class SbDangerController {

    @Autowired
    private SbDangerService sbDangerService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbDanger> saveOrUpdate(@Valid @RequestBody SbDanger sbDanger){
        try {
            sbDangerService.saveOrUpdate(sbDanger);
            return  ResultUtil.data(sbDanger);
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
    public Result<Page<SbDanger>> list(PageVo pageVo,SbDangerQuery query) {
        QueryWrapper<SbDanger> queryWrapper = new QueryWrapper<SbDanger>() ;
        //TODO 条件待填写
        queryWrapper.lambda().eq(SbDanger::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbDanger::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(query.getDeviceType()!=null,SbDanger::getDeviceType,EnumDeviceType.valueOf(query.getDeviceType()));
        queryWrapper.lambda().eq(query.getHiddenDangerLevel()!=null,SbDanger::getHiddenDangerLevel,EnumDangerStatus.valueOf(query.getHiddenDangerLevel()));
        queryWrapper.lambda().eq(query.getHiddenDangerType()!=null,SbDanger::getHiddenDangerType,query.getHiddenDangerType());
        queryWrapper.lambda().eq(query.getCommonHiddenDanger()!=null,SbDanger::getCommonHiddenDanger, query.getCommonHiddenDanger());
        queryWrapper.lambda().eq(query.getHiddenDangerState()!=null,SbDanger::getHiddenDangerState,query.getHiddenDangerState());
        queryWrapper.lambda().gt(query.getStartTime()!= null , SbDanger::getFoundTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbDanger::getFoundTime,query.getEndTime());

        Page page = sbDangerService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbDangerService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbDanger> getById(BaseReqVO request) {
        try {
            SbDanger sbDanger = sbDangerService.getById(request.getId());
            return  ResultUtil.data(sbDanger);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("缺陷数量信息统计")
    @GetMapping("/getCountDangerNum")
    public Result<SbDefectDTO> getCountDefectNum(BaseReqVO request) {
        SbDefectDTO countDefectNum = sbDangerService.getCountDefectNum(request);
        return ResultUtil.data(countDefectNum);
    }
}

