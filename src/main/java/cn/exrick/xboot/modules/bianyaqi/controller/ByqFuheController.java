package cn.exrick.xboot.modules.bianyaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqFuhe;
import cn.exrick.xboot.modules.bianyaqi.query.ByqFuheQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.bianyaqi.service.ByqFuheService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 变压器负荷信息表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/bianyaqi/byqFuhe")
@Slf4j
@ApiModel(value="ByqFuhe对象", description="变压器负荷信息表")
@Api(tags = "bianyaqi-变压器负荷信息表")
public class ByqFuheController {

    @Autowired
    private ByqFuheService byqFuheService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<ByqFuhe> saveOrUpdate(@Valid @RequestBody ByqFuhe byqFuhe){
        try {
            byqFuheService.saveOrUpdate(byqFuhe);
            return  ResultUtil.data(byqFuhe);
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
    public Result<Page<ByqFuhe>> list(PageVo pageVo,ByqFuheQuery query) {
        QueryWrapper<ByqFuhe> queryWrapper = new QueryWrapper<ByqFuhe>() ;
        //TODO 条件待填写
        Page page = byqFuheService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             byqFuheService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<ByqFuhe> getById(BaseReqVO request) {
        try {
            ByqFuhe byqFuhe = byqFuheService.getById(request.getId());
            return  ResultUtil.data(byqFuhe);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

