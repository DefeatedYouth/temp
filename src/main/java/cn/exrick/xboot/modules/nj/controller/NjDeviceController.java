package cn.exrick.xboot.modules.nj.controller;

import cn.exrick.xboot.modules.nj.entity.NjDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.nj.query.NjDeviceQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.nj.service.NjDeviceService;

import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 主设备表 controller
 * @author chenfeixiang
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/nj/njDevice")
@Slf4j
@ApiModel(value="NjDevice对象", description="主设备表")
@Api(tags = "nj-主设备表")
public class NjDeviceController {

    @Autowired
    private NjDeviceService njDeviceService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<NjDevice> saveOrUpdate(@Valid @RequestBody NjDevice njDevice){
        try {
            njDeviceService.saveOrUpdate(njDevice);
            return  ResultUtil.data(njDevice);
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
    public Result<Page<NjDevice>> list(PageVo pageVo,NjDeviceQuery query) {
        QueryWrapper<NjDevice> queryWrapper = new QueryWrapper<NjDevice>() ;
        //TODO 条件待填写
        Page page = njDeviceService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             njDeviceService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<NjDevice> getById(BaseReqVO request) {
        try {
            NjDevice njDevice = njDeviceService.getById(request.getId());
            return  ResultUtil.data(njDevice);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

