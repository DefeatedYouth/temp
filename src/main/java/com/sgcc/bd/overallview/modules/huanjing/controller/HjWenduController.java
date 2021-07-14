package com.sgcc.bd.overallview.modules.huanjing.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjWenduDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.huanjing.service.HjWenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjWendu;
import com.sgcc.bd.overallview.modules.huanjing.query.HjWenduQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 温度监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjWendu")
@Slf4j
@ApiModel(value="HjWendu对象", description="温度监视表")
@Api(tags = "huanjing-温度监视表")
public class HjWenduController {

    @Autowired
    private HjWenduService hjWenduService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjWendu> saveOrUpdate(@Valid @RequestBody HjWendu hjWendu){
        try {
            hjWenduService.saveOrUpdate(hjWendu);
            return  ResultUtil.data(hjWendu);
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
    public Result<Page<HjWendu>> list(PageVo pageVo, HjWenduQuery query) {
        QueryWrapper<HjWendu> queryWrapper = new QueryWrapper<HjWendu>() ;
        queryWrapper.lambda().eq(HjWendu::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjWendu::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjWendu::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjWendu::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjWendu::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getWenduValue()!=null,HjWendu::getWenduValue,query.getWenduValue());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjWendu::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjWendu::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjWenduService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjWenduService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjWendu> getById(BaseReqVO request) {
        try {
            HjWendu hjWendu = hjWenduService.getById(request.getId());
            return  ResultUtil.data(hjWendu);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "温度首页统计",notes = "参数 变电站id")
    @GetMapping("/temperatureCount")
    public Result<HjWenduDTO> temperatureCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = hjWenduService.temperatureCount(request);
            return  ResultUtil.data(hjWenduDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

