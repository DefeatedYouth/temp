package cn.exrick.xboot.modules.huanjing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.huanjing.entity.HjChushiji;
import cn.exrick.xboot.modules.huanjing.query.HjChushijiQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.huanjing.service.HjChushijiService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 除湿机监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/huanjing/hjChushiji")
@Slf4j
@ApiModel(value="HjChushiji对象", description="除湿机监视表")
@Api(tags = "huanjing-除湿机监视表")
public class HjChushijiController {

    @Autowired
    private HjChushijiService hjChushijiService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<HjChushiji> saveOrUpdate(@Valid @RequestBody HjChushiji hjChushiji){
        try {
            hjChushijiService.saveOrUpdate(hjChushiji);
            return  ResultUtil.data(hjChushiji);
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
    public Result<Page<HjChushiji>> list(PageVo pageVo,HjChushijiQuery query) {
        QueryWrapper<HjChushiji> queryWrapper = new QueryWrapper<HjChushiji>() ;
        //TODO 条件待填写
        Page page = hjChushijiService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             hjChushijiService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<HjChushiji> getById(BaseReqVO request) {
        try {
            HjChushiji hjChushiji = hjChushijiService.getById(request.getId());
            return  ResultUtil.data(hjChushiji);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

