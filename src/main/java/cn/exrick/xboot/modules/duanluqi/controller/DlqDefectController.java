package cn.exrick.xboot.modules.duanluqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.duanluqi.entity.DlqDefect;
import cn.exrick.xboot.modules.duanluqi.query.DlqDefectQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.duanluqi.service.DlqDefectService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器缺陷信息表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/duanluqi/dlqDefect")
@Slf4j
@ApiModel(value="DlqDefect对象", description="断路器缺陷信息表")
@Api(tags = "duanluqi-断路器缺陷信息表")
public class DlqDefectController {

    @Autowired
    private DlqDefectService dlqDefectService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<DlqDefect> saveOrUpdate(@Valid @RequestBody DlqDefect dlqDefect){
        try {
            dlqDefectService.saveOrUpdate(dlqDefect);
            return  ResultUtil.data(dlqDefect);
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
    public Result<Page<DlqDefect>> list(PageVo pageVo,DlqDefectQuery query) {
        QueryWrapper<DlqDefect> queryWrapper = new QueryWrapper<DlqDefect>() ;
        //TODO 条件待填写
        Page page = dlqDefectService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             dlqDefectService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<DlqDefect> getById(BaseReqVO request) {
        try {
            DlqDefect dlqDefect = dlqDefectService.getById(request.getId());
            return  ResultUtil.data(dlqDefect);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

