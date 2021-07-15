package com.sgcc.bd.overallview.modules.huanjing.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShuibangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuibang;
import com.sgcc.bd.overallview.modules.huanjing.query.HjShuibangQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 水泵监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjShuibang")
@Slf4j
@ApiModel(value="HjShuibang对象", description="水泵监视表")
@Api(tags = "huanjing-水泵监视表")
public class HjShuibangController {

    @Autowired
    private HjShuibangService hjShuibangService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjShuibang> saveOrUpdate(@Valid @RequestBody HjShuibang hjShuibang){
        try {
            hjShuibangService.saveOrUpdate(hjShuibang);
            return  ResultUtil.data(hjShuibang);
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
    public Result<Page<HjShuibang>> list(PageVo pageVo, HjShuibangQuery query) {
        QueryWrapper<HjShuibang> queryWrapper = new QueryWrapper<HjShuibang>() ;
        queryWrapper.lambda().eq(HjShuibang::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjShuibang::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjShuibang::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjShuibang::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjShuibang::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getSwitchState()!=null,HjShuibang::getSwitchState,query.getSwitchState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjShuibang::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjShuibang::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjShuibangService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjShuibangService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjShuibang> getById(BaseReqVO request) {
        try {
            HjShuibang hjShuibang = hjShuibangService.getById(request.getId());
            return  ResultUtil.data(hjShuibang);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


}

