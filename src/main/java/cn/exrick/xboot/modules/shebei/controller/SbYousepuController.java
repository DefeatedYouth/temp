package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbYousepu;
import cn.exrick.xboot.modules.shebei.query.SbYousepuQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbYousepuService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 设备油色谱表 controller
 * @author chenfeixiang
 * @since 2021-06-21
 */
@RestController
@RequestMapping("/shebei/sbYousepu")
@Slf4j
@ApiModel(value="SbYousepu对象", description="设备油色谱表")
@Api(tags = "shebei-设备油色谱表")
public class SbYousepuController {

    @Autowired
    private SbYousepuService sbYousepuService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbYousepu> saveOrUpdate(@Valid @RequestBody SbYousepu sbYousepu){
        try {
            sbYousepuService.saveOrUpdate(sbYousepu);
            return  ResultUtil.data(sbYousepu);
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
    public Result<Page<SbYousepu>> list(PageVo pageVo,SbYousepuQuery query) {
        QueryWrapper<SbYousepu> queryWrapper = new QueryWrapper<SbYousepu>() ;
        //TODO 条件待填写
        Page page = sbYousepuService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbYousepuService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbYousepu> getById(BaseReqVO request) {
        try {
            SbYousepu sbYousepu = sbYousepuService.getById(request.getId());
            return  ResultUtil.data(sbYousepu);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

