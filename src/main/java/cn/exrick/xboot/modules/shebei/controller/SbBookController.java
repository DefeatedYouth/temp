package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import cn.exrick.xboot.modules.shebei.query.SbBookQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbBookService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器设备台账 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbBook")
@Slf4j
@ApiModel(value="SbBook对象", description="断路器设备台账")
@Api(tags = "shebei-断路器设备台账")
public class SbBookController {

    @Autowired
    private SbBookService sbBookService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbBook> saveOrUpdate(@Valid @RequestBody SbBook sbBook){
        try {
            sbBookService.saveOrUpdate(sbBook);
            return  ResultUtil.data(sbBook);
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
    public Result<Page<SbBook>> list(PageVo pageVo,SbBookQuery query) {
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<SbBook>() ;
        //TODO 条件待填写
        queryWrapper.lambda().eq(query.getDeviceType()!= null,SbBook::getDeviceType,query.getDeviceType());
        Page page = sbBookService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbBookService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbBook> getById(BaseReqVO request) {
        try {
            SbBook sbBook = sbBookService.getById(request.getId());
            return  ResultUtil.data(sbBook);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

