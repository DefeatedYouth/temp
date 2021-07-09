package cn.exrick.xboot.modules.base.controller;

import cn.exrick.xboot.modules.base.entity.BaseOperationalRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BasePowerProtection;
import cn.exrick.xboot.modules.base.query.BasePowerProtectionQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BasePowerProtectionService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 保电表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/base/basePowerProtection")
@Slf4j
@ApiModel(value="BasePowerProtection对象", description="保电表")
@Api(tags = "base-保电表")
public class BasePowerProtectionController {

    @Autowired
    private BasePowerProtectionService basePowerProtectionService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BasePowerProtection> saveOrUpdate(@Valid @RequestBody BasePowerProtection basePowerProtection){
        try {
            basePowerProtectionService.saveOrUpdate(basePowerProtection);
            return  ResultUtil.data(basePowerProtection);
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
    public Result<Page<BasePowerProtection>> list(PageVo pageVo,BasePowerProtectionQuery query) {
        QueryWrapper<BasePowerProtection> queryWrapper = new QueryWrapper<BasePowerProtection>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null, BasePowerProtection::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeparentName()!=null,BasePowerProtection::getDeparentName,query.getDeparentName());
        queryWrapper.lambda().like(query.getVoltageLevel()!=null,BasePowerProtection::getVoltageLevel,query.getVoltageLevel());
        queryWrapper.lambda().like(query.getPowerProtectionTheme()!=null,BasePowerProtection::getPowerProtectionTheme,query.getPowerProtectionTheme());
        queryWrapper.lambda().eq(query.getPowerGuaranteeTaskLevel()!=null,BasePowerProtection::getPowerGuaranteeTaskLevel,query.getPowerGuaranteeTaskLevel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BasePowerProtection::getStartTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BasePowerProtection::getStartTime,query.getEndTime());//结束时间
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BasePowerProtection::getStartTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BasePowerProtection::getStartTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = basePowerProtectionService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             basePowerProtectionService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BasePowerProtection> getById(BaseReqVO request) {
        try {
            BasePowerProtection basePowerProtection = basePowerProtectionService.getById(request.getId());
            return  ResultUtil.data(basePowerProtection);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

