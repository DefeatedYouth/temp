package cn.exrick.xboot.modules.huanjing.controller;

import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumSwitchState;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import cn.exrick.xboot.modules.huanjing.entity.HjChushiji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjShuibang;
import cn.exrick.xboot.modules.huanjing.query.HjShuibangQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjShuibangService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
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
    public Result<Page<HjShuibang>> list(PageVo pageVo,HjShuibangQuery query) {
        QueryWrapper<HjShuibang> queryWrapper = new QueryWrapper<HjShuibang>() ;
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

    @ApiOperation(value = "水泵设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = hjShuibangService.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer openNum = hjShuibangService.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getSwitchState, EnumSwitchState.Open.getValue()));
            hjEquipmentNumDTO.setOpenNum(openNum);
            Integer downNum = hjShuibangService.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getSwitchState, EnumSwitchState.Shut.getValue()));
            hjEquipmentNumDTO.setDownNum(downNum);
            Integer processed = hjShuibangService.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getLinkState, EnumLinkState.Processed.getValue()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            return  ResultUtil.data(hjEquipmentNumDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

