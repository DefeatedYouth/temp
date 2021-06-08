package cn.exrick.xboot.modules.bianyaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqRealdata;
import cn.exrick.xboot.modules.bianyaqi.query.ByqRealdataQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.bianyaqi.service.ByqRealdataService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 变压器实时数据表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/bianyaqi/byqRealdata")
@Slf4j
@ApiModel(value="ByqRealdata对象", description="变压器实时数据表")
@Api(tags = "bianyaqi-变压器实时数据表")
public class ByqRealdataController {

    @Autowired
    private ByqRealdataService byqRealdataService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<ByqRealdata> saveOrUpdate(@Valid @RequestBody ByqRealdata byqRealdata){
        try {
            byqRealdataService.saveOrUpdate(byqRealdata);
            return  ResultUtil.data(byqRealdata);
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
    public Result<Page<ByqRealdata>> list(PageVo pageVo,ByqRealdataQuery query) {
        QueryWrapper<ByqRealdata> queryWrapper = new QueryWrapper<ByqRealdata>() ;
        //TODO 条件待填写
        Page page = byqRealdataService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             byqRealdataService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<ByqRealdata> getById(BaseReqVO request) {
        try {
            ByqRealdata byqRealdata = byqRealdataService.getById(request.getId());
            return  ResultUtil.data(byqRealdata);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

