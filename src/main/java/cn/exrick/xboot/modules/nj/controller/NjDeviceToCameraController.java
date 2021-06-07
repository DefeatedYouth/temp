package cn.exrick.xboot.modules.nj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.nj.entity.NjDeviceToCamera;
import cn.exrick.xboot.modules.nj.query.NjDeviceToCameraQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.nj.service.NjDeviceToCameraService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 设备与摄像机的关联表 controller
 * @author chenfeixiang
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/nj/njDeviceToCamera")
@Slf4j
@ApiModel(value="NjDeviceToCamera对象", description="设备与摄像机的关联表")
@Api(tags = "nj-设备与摄像机的关联表")
public class NjDeviceToCameraController {

    @Autowired
    private NjDeviceToCameraService njDeviceToCameraService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<NjDeviceToCamera> saveOrUpdate(@Valid @RequestBody NjDeviceToCamera njDeviceToCamera){
        try {
            njDeviceToCameraService.saveOrUpdate(njDeviceToCamera);
            return  ResultUtil.data(njDeviceToCamera);
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
    public Result<Page<NjDeviceToCamera>> list(PageVo pageVo,NjDeviceToCameraQuery query) {
        QueryWrapper<NjDeviceToCamera> queryWrapper = new QueryWrapper<NjDeviceToCamera>() ;
        //TODO 条件待填写
        Page page = njDeviceToCameraService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             njDeviceToCameraService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<NjDeviceToCamera> getById(BaseReqVO request) {
        try {
            NjDeviceToCamera njDeviceToCamera = njDeviceToCameraService.getById(request.getId());
            return  ResultUtil.data(njDeviceToCamera);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

