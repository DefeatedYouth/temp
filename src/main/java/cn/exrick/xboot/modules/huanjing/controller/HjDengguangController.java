package cn.exrick.xboot.modules.huanjing.controller;

import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumSwitchState;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjDengguang;
import cn.exrick.xboot.modules.huanjing.query.HjDengguangQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjDengguangService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 灯光监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjDengguang")
@Slf4j
@ApiModel(value="HjDengguang对象", description="灯光监视表")
@Api(tags = "huanjing-灯光监视表")
public class HjDengguangController {

    @Autowired
    private HjDengguangService hjDengguangService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjDengguang> saveOrUpdate(@Valid @RequestBody HjDengguang hjDengguang){
        try {
            hjDengguangService.saveOrUpdate(hjDengguang);
            return  ResultUtil.data(hjDengguang);
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
    public Result<Page<HjDengguang>> list(PageVo pageVo,HjDengguangQuery query) {
        QueryWrapper<HjDengguang> queryWrapper = new QueryWrapper<HjDengguang>() ;
        //TODO 条件待填写
        Page page = hjDengguangService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjDengguangService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjDengguang> getById(BaseReqVO request) {
        try {
            HjDengguang hjDengguang = hjDengguangService.getById(request.getId());
            return  ResultUtil.data(hjDengguang);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "灯光设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjDengguangService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

