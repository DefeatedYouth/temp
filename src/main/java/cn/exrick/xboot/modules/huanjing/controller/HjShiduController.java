package cn.exrick.xboot.modules.huanjing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjShidu;
import cn.exrick.xboot.modules.huanjing.query.HjShiduQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjShiduService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 湿度监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjShidu")
@Slf4j
@ApiModel(value="HjShidu对象", description="湿度监视表")
@Api(tags = "huanjing-湿度监视表")
public class HjShiduController {

    @Autowired
    private HjShiduService hjShiduService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjShidu> saveOrUpdate(@Valid @RequestBody HjShidu hjShidu){
        try {
            hjShiduService.saveOrUpdate(hjShidu);
            return  ResultUtil.data(hjShidu);
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
    public Result<Page<HjShidu>> list(PageVo pageVo,HjShiduQuery query) {
        QueryWrapper<HjShidu> queryWrapper = new QueryWrapper<HjShidu>() ;
        //TODO 条件待填写
        Page page = hjShiduService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjShiduService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjShidu> getById(BaseReqVO request) {
        try {
            HjShidu hjShidu = hjShiduService.getById(request.getId());
            return  ResultUtil.data(hjShidu);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

