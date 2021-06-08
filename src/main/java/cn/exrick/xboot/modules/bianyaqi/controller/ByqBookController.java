package cn.exrick.xboot.modules.bianyaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqBook;
import cn.exrick.xboot.modules.bianyaqi.query.ByqBookQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.bianyaqi.service.ByqBookService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 变压器台账表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/bianyaqi/byqBook")
@Slf4j
@ApiModel(value="ByqBook对象", description="变压器台账表")
@Api(tags = "bianyaqi-变压器台账表")
public class ByqBookController {

    @Autowired
    private ByqBookService byqBookService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<ByqBook> saveOrUpdate(@Valid @RequestBody ByqBook byqBook){
        try {
            byqBookService.saveOrUpdate(byqBook);
            return  ResultUtil.data(byqBook);
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
    public Result<Page<ByqBook>> list(PageVo pageVo,ByqBookQuery query) {
        QueryWrapper<ByqBook> queryWrapper = new QueryWrapper<ByqBook>() ;
        //TODO 条件待填写
        Page page = byqBookService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             byqBookService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<ByqBook> getById(BaseReqVO request) {
        try {
            ByqBook byqBook = byqBookService.getById(request.getId());
            return  ResultUtil.data(byqBook);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

