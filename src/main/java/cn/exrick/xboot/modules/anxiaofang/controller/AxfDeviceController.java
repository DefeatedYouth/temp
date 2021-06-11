package cn.exrick.xboot.modules.anxiaofang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import cn.exrick.xboot.modules.anxiaofang.query.AxfDeviceQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.anxiaofang.service.AxfDeviceService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 安消防设备监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/anxiaofang/axfDevice")
@Slf4j
@ApiModel(value="AxfDevice对象", description="安消防设备监视表")
@Api(tags = "anxiaofang-安消防设备监视表")
public class AxfDeviceController {

    @Autowired
    private AxfDeviceService axfDeviceService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增 提交的成功嘛
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<AxfDevice> saveOrUpdate(@Valid @RequestBody AxfDevice axfDevice){
        try {
            axfDeviceService.saveOrUpdate(axfDevice);
            return  ResultUtil.data(axfDevice);
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
    public Result<Page<AxfDevice>> list(PageVo pageVo,AxfDeviceQuery query) {
        QueryWrapper<AxfDevice> queryWrapper = new QueryWrapper<AxfDevice>() ;
        //TODO 条件待填写
        Page page = axfDeviceService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             axfDeviceService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<AxfDevice> getById(BaseReqVO request) {
        try {
            AxfDevice axfDevice = axfDeviceService.getById(request.getId());
            return  ResultUtil.data(axfDevice);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

