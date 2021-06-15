package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbTest;
import cn.exrick.xboot.modules.shebei.query.SbTestQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbTestService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器履历实验信息表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbTest")
@Slf4j
@ApiModel(value="SbTest对象", description="断路器履历实验信息表")
@Api(tags = "shebei-断路器履历实验信息表")
public class SbTestController {

    @Autowired
    private SbTestService sbTestService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbTest> saveOrUpdate(@Valid @RequestBody SbTest sbTest){
        try {
            sbTestService.saveOrUpdate(sbTest);
            return  ResultUtil.data(sbTest);
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
    public Result<Page<SbTest>> list(PageVo pageVo,SbTestQuery query) {
        QueryWrapper<SbTest> queryWrapper = new QueryWrapper<SbTest>() ;
        //TODO 条件待填写
        Page page = sbTestService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbTestService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbTest> getById(BaseReqVO request) {
        try {
            SbTest sbTest = sbTestService.getById(request.getId());
            return  ResultUtil.data(sbTest);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

