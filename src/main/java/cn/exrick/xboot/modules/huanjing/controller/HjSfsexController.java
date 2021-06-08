package cn.exrick.xboot.modules.huanjing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjSfsex;
import cn.exrick.xboot.modules.huanjing.query.HjSfsexQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjSfsexService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc SF6监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjSfsex")
@Slf4j
@ApiModel(value="HjSfsex对象", description="SF6监视表")
@Api(tags = "huanjing-SF6监视表")
public class HjSfsexController {

    @Autowired
    private HjSfsexService hjSfsexService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjSfsex> saveOrUpdate(@Valid @RequestBody HjSfsex hjSfsex){
        try {
            hjSfsexService.saveOrUpdate(hjSfsex);
            return  ResultUtil.data(hjSfsex);
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
    public Result<Page<HjSfsex>> list(PageVo pageVo,HjSfsexQuery query) {
        QueryWrapper<HjSfsex> queryWrapper = new QueryWrapper<HjSfsex>() ;
        //TODO 条件待填写
        Page page = hjSfsexService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjSfsexService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjSfsex> getById(BaseReqVO request) {
        try {
            HjSfsex hjSfsex = hjSfsexService.getById(request.getId());
            return  ResultUtil.data(hjSfsex);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}
