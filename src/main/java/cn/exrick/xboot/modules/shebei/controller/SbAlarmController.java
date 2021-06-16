package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.common.enums.EnumAlarmStateType;
import cn.exrick.xboot.common.enums.EnumAlarmType;
import cn.exrick.xboot.modules.shebei.dto.SbAlarmNumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbAlarm;
import cn.exrick.xboot.modules.shebei.query.SbAlarmQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbAlarmService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器告警数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbAlarm")
@Slf4j
@ApiModel(value="SbAlarm对象", description="断路器告警数据表")
@Api(tags = "shebei-断路器告警数据表")
public class SbAlarmController {

    @Autowired
    private SbAlarmService sbAlarmService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbAlarm> saveOrUpdate(@Valid @RequestBody SbAlarm sbAlarm){
        try {
            sbAlarmService.saveOrUpdate(sbAlarm);
            return  ResultUtil.data(sbAlarm);
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
    public Result<Page<SbAlarm>> list(PageVo pageVo,SbAlarmQuery query) {
        QueryWrapper<SbAlarm> queryWrapper = new QueryWrapper<SbAlarm>() ;
        //TODO 条件待填写
        Page page = sbAlarmService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbAlarmService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbAlarm> getById(BaseReqVO request) {
        try {
            SbAlarm sbAlarm = sbAlarmService.getById(request.getId());
            return  ResultUtil.data(sbAlarm);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("查询设备事故告警数量，未处理告警数量")
    @GetMapping("/getAlarmNum")
    public Result<SbAlarmNumDTO> getAlarmNum(BaseReqVO request) {
        try {
            SbAlarmNumDTO sbAlarmNumDTO =new SbAlarmNumDTO();
            Integer accidentAlarmNum = sbAlarmService.getBaseMapper().selectCount(new QueryWrapper<SbAlarm>().lambda().eq(SbAlarm::getAlarmType, request.getType())
                    .eq(SbAlarm::getAlarmType, EnumAlarmType.Accident.getValue())
                    .eq(SbAlarm::getAlarmState, EnumAlarmStateType.Untreated.getValue())
            );

            Integer unhandledNum = sbAlarmService.getBaseMapper().selectCount(new QueryWrapper<SbAlarm>().lambda().eq(SbAlarm::getAlarmType, EnumAlarmType.Accident.getValue())
                    .eq(SbAlarm::getAlarmState, EnumAlarmStateType.Untreated.getValue())
            );
            sbAlarmNumDTO.setAccidentAlarmNum(accidentAlarmNum);
            sbAlarmNumDTO.setUnhandledNum(unhandledNum);
            return  ResultUtil.data(sbAlarmNumDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

