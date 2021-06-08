package cn.exrick.xboot.modules.duanluqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.duanluqi.entity.DlqFault;
import cn.exrick.xboot.modules.duanluqi.query.DlqFaultQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.duanluqi.service.DlqFaultService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 设备履历故障记录表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/duanluqi/dlqFault")
@Slf4j
@ApiModel(value="DlqFault对象", description="设备履历故障记录表")
@Api(tags = "duanluqi-设备履历故障记录表")
public class DlqFaultController {

    @Autowired
    private DlqFaultService dlqFaultService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<DlqFault> saveOrUpdate(@Valid @RequestBody DlqFault dlqFault){
        try {
            dlqFaultService.saveOrUpdate(dlqFault);
            return  ResultUtil.data(dlqFault);
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
    public Result<Page<DlqFault>> list(PageVo pageVo,DlqFaultQuery query) {
        QueryWrapper<DlqFault> queryWrapper = new QueryWrapper<DlqFault>() ;
        //TODO 条件待填写
        Page page = dlqFaultService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             dlqFaultService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<DlqFault> getById(BaseReqVO request) {
        try {
            DlqFault dlqFault = dlqFaultService.getById(request.getId());
            return  ResultUtil.data(dlqFault);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

