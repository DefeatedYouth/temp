package cn.exrick.xboot.modules.duanluqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.duanluqi.entity.DlqOverhaul;
import cn.exrick.xboot.modules.duanluqi.query.DlqOverhaulQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.duanluqi.service.DlqOverhaulService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器履历检修信息表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/duanluqi/dlqOverhaul")
@Slf4j
@ApiModel(value="DlqOverhaul对象", description="断路器履历检修信息表")
@Api(tags = "duanluqi-断路器履历检修信息表")
public class DlqOverhaulController {

    @Autowired
    private DlqOverhaulService dlqOverhaulService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<DlqOverhaul> saveOrUpdate(@Valid @RequestBody DlqOverhaul dlqOverhaul){
        try {
            dlqOverhaulService.saveOrUpdate(dlqOverhaul);
            return  ResultUtil.data(dlqOverhaul);
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
    public Result<Page<DlqOverhaul>> list(PageVo pageVo,DlqOverhaulQuery query) {
        QueryWrapper<DlqOverhaul> queryWrapper = new QueryWrapper<DlqOverhaul>() ;
        //TODO 条件待填写
        Page page = dlqOverhaulService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             dlqOverhaulService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<DlqOverhaul> getById(BaseReqVO request) {
        try {
            DlqOverhaul dlqOverhaul = dlqOverhaulService.getById(request.getId());
            return  ResultUtil.data(dlqOverhaul);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

