package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbRealdata;
import cn.exrick.xboot.modules.shebei.query.SbRealdataQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbRealdataService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器实时状态数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbRealdata")
@Slf4j
@ApiModel(value="SbRealdata对象", description="断路器实时状态数据表")
@Api(tags = "shebei-断路器实时状态数据表")
public class SbRealdataController {

    @Autowired
    private SbRealdataService sbRealdataService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbRealdata> saveOrUpdate(@Valid @RequestBody SbRealdata sbRealdata){
        try {
            sbRealdataService.saveOrUpdate(sbRealdata);
            return  ResultUtil.data(sbRealdata);
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
    public Result<Page<SbRealdata>> list(PageVo pageVo,SbRealdataQuery query) {
        QueryWrapper<SbRealdata> queryWrapper = new QueryWrapper<SbRealdata>() ;
        //TODO 条件待填写
        Page page = sbRealdataService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbRealdataService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbRealdata> getById(BaseReqVO request) {
        try {
            SbRealdata sbRealdata = sbRealdataService.getById(request.getId());
            return  ResultUtil.data(sbRealdata);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

