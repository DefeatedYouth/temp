package cn.exrick.xboot.modules.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BaseMeteorologicalWarning;
import cn.exrick.xboot.modules.base.query.BaseMeteorologicalWarningQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BaseMeteorologicalWarningService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 气象预警 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/base/baseMeteorologicalWarning")
@Slf4j
@ApiModel(value="BaseMeteorologicalWarning对象", description="气象预警")
@Api(tags = "base-气象预警")
public class BaseMeteorologicalWarningController {

    @Autowired
    private BaseMeteorologicalWarningService baseMeteorologicalWarningService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseMeteorologicalWarning> saveOrUpdate(@Valid @RequestBody BaseMeteorologicalWarning baseMeteorologicalWarning){
        try {
            baseMeteorologicalWarningService.saveOrUpdate(baseMeteorologicalWarning);
            return  ResultUtil.data(baseMeteorologicalWarning);
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
    public Result<Page<BaseMeteorologicalWarning>> list(PageVo pageVo,BaseMeteorologicalWarningQuery query) {
        QueryWrapper<BaseMeteorologicalWarning> queryWrapper = new QueryWrapper<BaseMeteorologicalWarning>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null,BaseMeteorologicalWarning::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getCity()!=null,BaseMeteorologicalWarning::getCity,query.getCity());
        queryWrapper.lambda().eq(query.getType()!=null,BaseMeteorologicalWarning::getType,query.getType());
        queryWrapper.lambda().eq(query.getLevel()!=null,BaseMeteorologicalWarning::getLevel,query.getLevel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseMeteorologicalWarning::getStartingTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseMeteorologicalWarning::getStartingTime,query.getEndTime());//结束时间
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseMeteorologicalWarning::getForecastStartTime,query.getPreStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseMeteorologicalWarning::getForecastStartTime,query.getPreEndTime());//结束时间
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseMeteorologicalWarning::getForecastEndTime,query.getPreEndStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseMeteorologicalWarning::getForecastEndTime,query.getPreEndEndTime());//结束时间
        //TODO 条件待填写
        Page page = baseMeteorologicalWarningService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseMeteorologicalWarningService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseMeteorologicalWarning> getById(BaseReqVO request) {
        try {
            BaseMeteorologicalWarning baseMeteorologicalWarning = baseMeteorologicalWarningService.getById(request.getId());
            return  ResultUtil.data(baseMeteorologicalWarning);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

