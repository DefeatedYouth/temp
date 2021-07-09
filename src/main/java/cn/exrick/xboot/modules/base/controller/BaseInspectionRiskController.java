package cn.exrick.xboot.modules.base.controller;

import cn.exrick.xboot.modules.base.entity.BaseEquipmentInvestigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BaseInspectionRisk;
import cn.exrick.xboot.modules.base.query.BaseInspectionRiskQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BaseInspectionRiskService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 巡视风险表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/base/baseInspectionRisk")
@Slf4j
@ApiModel(value="BaseInspectionRisk对象", description="巡视风险表")
@Api(tags = "base-巡视风险表")
public class BaseInspectionRiskController {

    @Autowired
    private BaseInspectionRiskService baseInspectionRiskService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseInspectionRisk> saveOrUpdate(@Valid @RequestBody BaseInspectionRisk baseInspectionRisk){
        try {
            baseInspectionRiskService.saveOrUpdate(baseInspectionRisk);
            return  ResultUtil.data(baseInspectionRisk);
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
    public Result<Page<BaseInspectionRisk>> list(PageVo pageVo,BaseInspectionRiskQuery query) {
        QueryWrapper<BaseInspectionRisk> queryWrapper = new QueryWrapper<BaseInspectionRisk>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null, BaseInspectionRisk::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getCity()!=null,BaseInspectionRisk::getCity,query.getCity());
        queryWrapper.lambda().eq(query.getInspectionType()!=null,BaseInspectionRisk::getInspectionType,query.getInspectionType());
        queryWrapper.lambda().eq(query.getPlanState()!=null,BaseInspectionRisk::getPlanState,query.getPlanState());
        queryWrapper.lambda().like(query.getHiddenDangerItems()!=null,BaseInspectionRisk::getHiddenDangerItems,query.getHiddenDangerItems());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseInspectionRisk::getEndTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseInspectionRisk::getEndTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = baseInspectionRiskService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseInspectionRiskService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseInspectionRisk> getById(BaseReqVO request) {
        try {
            BaseInspectionRisk baseInspectionRisk = baseInspectionRiskService.getById(request.getId());
            return  ResultUtil.data(baseInspectionRisk);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

