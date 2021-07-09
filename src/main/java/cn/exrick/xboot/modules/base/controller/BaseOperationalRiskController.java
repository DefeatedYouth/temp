package cn.exrick.xboot.modules.base.controller;

import cn.exrick.xboot.modules.base.entity.BaseMeteorologicalWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.base.entity.BaseOperationalRisk;
import cn.exrick.xboot.modules.base.query.BaseOperationalRiskQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.base.service.BaseOperationalRiskService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 操作风险表 controller
 * @author chenfeixiang
 * @since 2021-07-08
 */
@RestController
@RequestMapping("/base/baseOperationalRisk")
@Slf4j
@ApiModel(value="BaseOperationalRisk对象", description="操作风险表")
@Api(tags = "base-操作风险表")
public class BaseOperationalRiskController {

    @Autowired
    private BaseOperationalRiskService baseOperationalRiskService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseOperationalRisk> saveOrUpdate(@Valid @RequestBody BaseOperationalRisk baseOperationalRisk){
        try {
            baseOperationalRiskService.saveOrUpdate(baseOperationalRisk);
            return  ResultUtil.data(baseOperationalRisk);
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
    public Result<Page<BaseOperationalRisk>> list(PageVo pageVo,BaseOperationalRiskQuery query) {

        QueryWrapper<BaseOperationalRisk> queryWrapper = new QueryWrapper<BaseOperationalRisk>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null, BaseOperationalRisk::getSiteId,query.getSiteId());
        //queryWrapper.lambda()
        queryWrapper.lambda().like(query.getPowerCutScope()!=null,BaseOperationalRisk::getPowerCutScope,query.getPowerCutScope());
        queryWrapper.lambda().like(query.getHiddenDangerItems()!=null,BaseOperationalRisk::getHiddenDangerItems,query.getHiddenDangerItems());
        queryWrapper.lambda().like(query.getNum()!=null,BaseOperationalRisk::getNum,query.getNum());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseOperationalRisk::getStartTimePlan,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseOperationalRisk::getStartTimePlan,query.getEndTime());
        queryWrapper.lambda().gt(query.getStartPlanTime()!= null ,BaseOperationalRisk::getEndTimePlan,query.getStartPlanTime());
        queryWrapper.lambda().lt(query.getEndPlanTime() != null,BaseOperationalRisk::getEndTimePlan,query.getEndPlanTime());
        //TODO 条件待填写
        Page page = baseOperationalRiskService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseOperationalRiskService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseOperationalRisk> getById(BaseReqVO request) {
        try {
            BaseOperationalRisk baseOperationalRisk = baseOperationalRiskService.getById(request.getId());
            return  ResultUtil.data(baseOperationalRisk);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

