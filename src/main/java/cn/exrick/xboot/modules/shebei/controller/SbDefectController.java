package cn.exrick.xboot.modules.shebei.controller;

import cn.exrick.xboot.common.enums.EnumDefectStatus;
import cn.exrick.xboot.modules.shebei.dto.SbDefectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbDefect;
import cn.exrick.xboot.modules.shebei.query.SbDefectQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbDefectService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器缺陷信息表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbDefect")
@Slf4j
@ApiModel(value="SbDefect对象", description="断路器缺陷信息表")
@Api(tags = "shebei-断路器缺陷信息表")
public class SbDefectController {

    @Autowired
    private SbDefectService sbDefectService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbDefect> saveOrUpdate(@Valid @RequestBody SbDefect sbDefect){
        try {
            sbDefectService.saveOrUpdate(sbDefect);
            return  ResultUtil.data(sbDefect);
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
    public Result<Page<SbDefect>> list(PageVo pageVo,SbDefectQuery query) {
        QueryWrapper<SbDefect> queryWrapper = new QueryWrapper<SbDefect>() ;
        //TODO 条件待填写
        Page page = sbDefectService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbDefectService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbDefect> getById(BaseReqVO request) {
        try {
            SbDefect sbDefect = sbDefectService.getById(request.getId());
            return  ResultUtil.data(sbDefect);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("缺陷数量信息统计")
    @GetMapping("/getCountDefectNum")
    public Result<SbDefectDTO> getCountDefectNum(BaseReqVO request) {
        try {
            SbDefectDTO sbDefect = new SbDefectDTO();

            Integer common = sbDefectService.getBaseMapper().selectCount(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getDeviceType, request.getType()).eq(SbDefect::getDefectLevel, EnumDefectStatus.common.getValue()));
            Integer severity = sbDefectService.getBaseMapper().selectCount(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getDeviceType, request.getType()).eq(SbDefect::getDefectLevel, EnumDefectStatus.severity.getValue()));
            Integer critical = sbDefectService.getBaseMapper().selectCount(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getDeviceType, request.getType()).eq(SbDefect::getDefectLevel, EnumDefectStatus.critical.getValue()));
            //Integer notdefect = sbDefectService.getBaseMapper().selectCount(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getDeviceType, "变压器").eq(SbDefect::getDefectLevel, EnumDefectStatus.notdefect.getValue()));
            sbDefect.setCommonNum(common);
            sbDefect.setSeverityNum(severity);
            sbDefect.setCriticalNum(critical);
            sbDefect.setNotdefectNum(common+severity+critical);
            return  ResultUtil.data(sbDefect);
            //todo 根据前端传过来的设备类型来查询 具体是什么设备的缺陷信息统计 这里是写死的 变压器，后面根据传过来的type进行修改。
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

}

