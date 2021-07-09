package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.modules.shebei.entity.SbSecondaryEquipmentMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbSparePartsList;
import cn.exrick.xboot.modules.shebei.query.SbSparePartsListQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbSparePartsListService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 备品备件表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/shebei/sbSparePartsList")
@Slf4j
@ApiModel(value="SbSparePartsList对象", description="备品备件表")
@Api(tags = "shebei-备品备件表")
public class SbSparePartsListController {

    @Autowired
    private SbSparePartsListService sbSparePartsListService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbSparePartsList> saveOrUpdate(@Valid @RequestBody SbSparePartsList sbSparePartsList){
        try {
            sbSparePartsListService.saveOrUpdate(sbSparePartsList);
            return  ResultUtil.data(sbSparePartsList);
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
    public Result<Page<SbSparePartsList>> list(PageVo pageVo,SbSparePartsListQuery query) {
        QueryWrapper<SbSparePartsList> queryWrapper = new QueryWrapper<SbSparePartsList>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null, SbSparePartsList::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getDeviceType()!=null,SbSparePartsList::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().like(query.getVoltageLevel()!=null,SbSparePartsList::getVoltageLevel,query.getVoltageLevel());
        queryWrapper.lambda().like(query.getDeparentName()!=null,SbSparePartsList::getDeparentName,query.getDeparentName());
        queryWrapper.lambda().like(query.getEquipmentCode()!=null,SbSparePartsList::getEquipmentCode,query.getEquipmentCode());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbSparePartsList::getStorageDate,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbSparePartsList::getStorageDate,query.getEndTime());

        //TODO 条件待填写
        Page page = sbSparePartsListService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbSparePartsListService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbSparePartsList> getById(BaseReqVO request) {
        try {
            SbSparePartsList sbSparePartsList = sbSparePartsListService.getById(request.getId());
            return  ResultUtil.data(sbSparePartsList);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

