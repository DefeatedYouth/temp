package cn.exrick.xboot.modules.huanjing.controller;

import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumSwitchState;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import cn.exrick.xboot.modules.huanjing.entity.HjDengguang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjKongtiao;
import cn.exrick.xboot.modules.huanjing.query.HjKongtiaoQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjKongtiaoService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 空调监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjKongtiao")
@Slf4j
@ApiModel(value="HjKongtiao对象", description="空调监视表")
@Api(tags = "huanjing-空调监视表")
public class HjKongtiaoController {

    @Autowired
    private HjKongtiaoService hjKongtiaoService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjKongtiao> saveOrUpdate(@Valid @RequestBody HjKongtiao hjKongtiao){
        try {
            hjKongtiaoService.saveOrUpdate(hjKongtiao);
            return  ResultUtil.data(hjKongtiao);
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
    public Result<Page<HjKongtiao>> list(PageVo pageVo,HjKongtiaoQuery query) {
        QueryWrapper<HjKongtiao> queryWrapper = new QueryWrapper<HjKongtiao>() ;
        queryWrapper.lambda().eq(HjKongtiao::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getParentName()!=null,HjKongtiao::getParentName,query.getParentName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,HjKongtiao::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getNoteName()!=null,HjKongtiao::getNoteName,query.getNoteName());
        queryWrapper.lambda().like(query.getNoteType()!=null,HjKongtiao::getNoteType,query.getNoteType());
        queryWrapper.lambda().eq(query.getSwitchState()!=null,HjKongtiao::getSwitchState,query.getSwitchState());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,HjKongtiao::getHappenTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,HjKongtiao::getHappenTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = hjKongtiaoService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjKongtiaoService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjKongtiao> getById(BaseReqVO request) {
        try {
            HjKongtiao hjKongtiao = hjKongtiaoService.getById(request.getId());
            return  ResultUtil.data(hjKongtiao);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "空调设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjKongtiaoService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

