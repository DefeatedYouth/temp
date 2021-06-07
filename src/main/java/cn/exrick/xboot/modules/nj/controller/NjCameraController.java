package cn.exrick.xboot.modules.nj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.nj.entity.NjCamera;
import cn.exrick.xboot.modules.nj.query.NjCameraQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.nj.service.NjCameraService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc  摄像机表 controller
 * @author chenfeixiang
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/nj/njCamera")
@Slf4j
@ApiModel(value="NjCamera对象", description=" 摄像机表")
@Api(tags = "nj- 摄像机表")
public class NjCameraController {

    @Autowired
    private NjCameraService njCameraService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<NjCamera> saveOrUpdate(@Valid @RequestBody NjCamera njCamera){
        try {
            njCameraService.saveOrUpdate(njCamera);
            return  ResultUtil.data(njCamera);
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
    public Result<Page<NjCamera>> list(PageVo pageVo,NjCameraQuery query) {
        QueryWrapper<NjCamera> queryWrapper = new QueryWrapper<NjCamera>() ;
        //TODO 条件待填写
        Page page = njCameraService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             njCameraService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<NjCamera> getById(BaseReqVO request) {
        try {
            NjCamera njCamera = njCameraService.getById(request.getId());
            return  ResultUtil.data(njCamera);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

