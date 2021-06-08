package cn.exrick.xboot.modules.duanluqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.duanluqi.entity.DlqRealdata;
import cn.exrick.xboot.modules.duanluqi.query.DlqRealdataQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.duanluqi.service.DlqRealdataService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器实时状态数据表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/duanluqi/dlqRealdata")
@Slf4j
@ApiModel(value="DlqRealdata对象", description="断路器实时状态数据表")
@Api(tags = "duanluqi-断路器实时状态数据表")
public class DlqRealdataController {

    @Autowired
    private DlqRealdataService dlqRealdataService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<DlqRealdata> saveOrUpdate(@Valid @RequestBody DlqRealdata dlqRealdata){
        try {
            dlqRealdataService.saveOrUpdate(dlqRealdata);
            return  ResultUtil.data(dlqRealdata);
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
    public Result<Page<DlqRealdata>> list(PageVo pageVo,DlqRealdataQuery query) {
        QueryWrapper<DlqRealdata> queryWrapper = new QueryWrapper<DlqRealdata>() ;
        //TODO 条件待填写
        Page page = dlqRealdataService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             dlqRealdataService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<DlqRealdata> getById(BaseReqVO request) {
        try {
            DlqRealdata dlqRealdata = dlqRealdataService.getById(request.getId());
            return  ResultUtil.data(dlqRealdata);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

