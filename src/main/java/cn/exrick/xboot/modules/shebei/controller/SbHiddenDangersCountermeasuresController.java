package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbHiddenDangersCountermeasures;
import cn.exrick.xboot.modules.shebei.query.SbHiddenDangersCountermeasuresQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbHiddenDangersCountermeasuresService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 隐患反措专项排查表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/shebei/sbHiddenDangersCountermeasures")
@Slf4j
@ApiModel(value="SbHiddenDangersCountermeasures对象", description="隐患反措专项排查表")
@Api(tags = "shebei-隐患反措专项排查表")
public class SbHiddenDangersCountermeasuresController {

    @Autowired
    private SbHiddenDangersCountermeasuresService sbHiddenDangersCountermeasuresService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbHiddenDangersCountermeasures> saveOrUpdate(@Valid @RequestBody SbHiddenDangersCountermeasures sbHiddenDangersCountermeasures){
        try {
            sbHiddenDangersCountermeasuresService.saveOrUpdate(sbHiddenDangersCountermeasures);
            return  ResultUtil.data(sbHiddenDangersCountermeasures);
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
    public Result<Page<SbHiddenDangersCountermeasures>> list(PageVo pageVo,SbHiddenDangersCountermeasuresQuery query) {
        QueryWrapper<SbHiddenDangersCountermeasures> queryWrapper = new QueryWrapper<SbHiddenDangersCountermeasures>() ;
        //TODO 条件待填写
        Page page = sbHiddenDangersCountermeasuresService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbHiddenDangersCountermeasuresService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbHiddenDangersCountermeasures> getById(BaseReqVO request) {
        try {
            SbHiddenDangersCountermeasures sbHiddenDangersCountermeasures = sbHiddenDangersCountermeasuresService.getById(request.getId());
            return  ResultUtil.data(sbHiddenDangersCountermeasures);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

