package cn.exrick.xboot.modules.bianyaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqAlarm;
import cn.exrick.xboot.modules.bianyaqi.query.ByqAlarmQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.bianyaqi.service.ByqAlarmService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 变压器告警信息 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/bianyaqi/byqAlarm")
@Slf4j
@ApiModel(value="ByqAlarm对象", description="变压器告警信息")
@Api(tags = "bianyaqi-变压器告警信息")
public class ByqAlarmController {

    @Autowired
    private ByqAlarmService byqAlarmService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<ByqAlarm> saveOrUpdate(@Valid @RequestBody ByqAlarm byqAlarm){
        try {
            byqAlarmService.saveOrUpdate(byqAlarm);
            return  ResultUtil.data(byqAlarm);
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
    public Result<Page<ByqAlarm>> list(PageVo pageVo,ByqAlarmQuery query) {
        QueryWrapper<ByqAlarm> queryWrapper = new QueryWrapper<ByqAlarm>() ;
        //TODO 条件待填写
        Page page = byqAlarmService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             byqAlarmService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<ByqAlarm> getById(BaseReqVO request) {
        try {
            ByqAlarm byqAlarm = byqAlarmService.getById(request.getId());
            return  ResultUtil.data(byqAlarm);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

