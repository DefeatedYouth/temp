package cn.exrick.xboot.modules.shebei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.shebei.entity.SbSfsix;
import cn.exrick.xboot.modules.shebei.query.SbSfsixQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.shebei.service.SbSfsixService;

import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 断路器sf6监测数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbSfsix")
@Slf4j
@ApiModel(value="SbSfsix对象", description="断路器sf6监测数据表")
@Api(tags = "shebei-断路器sf6监测数据表")
public class SbSfsixController {

    @Autowired
    private SbSfsixService sbSfsixService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbSfsix> saveOrUpdate(@Valid @RequestBody SbSfsix sbSfsix){
        try {
            sbSfsixService.saveOrUpdate(sbSfsix);
            return  ResultUtil.data(sbSfsix);
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
    public Result<Page<SbSfsix>> list(PageVo pageVo,SbSfsixQuery query) {
        QueryWrapper<SbSfsix> queryWrapper = new QueryWrapper<SbSfsix>() ;
        queryWrapper.lambda().eq(SbSfsix::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getAgasConcentration()!=null,SbSfsix::getAgasConcentration,query.getAgasConcentration());
        queryWrapper.lambda().like(query.getAgasMoisture()!=null,SbSfsix::getAgasMoisture,query.getAgasMoisture());
        queryWrapper.lambda().like(query.getAgasPressure()!=null,SbSfsix::getAgasPressure,query.getAgasPressure());
        queryWrapper.lambda().like(query.getBgasConcentration()!=null,SbSfsix::getBgasConcentration,query.getBgasConcentration());
        queryWrapper.lambda().like(query.getBgasMoisture()!=null,SbSfsix::getBgasMoisture,query.getBgasMoisture());
        queryWrapper.lambda().like(query.getBgasPressure()!=null,SbSfsix::getBgasPressure,query.getBgasPressure());
        queryWrapper.lambda().like(query.getCgasConcentration()!=null,SbSfsix::getCgasConcentration,query.getCgasConcentration());
        queryWrapper.lambda().like(query.getCgasMoisture()!=null,SbSfsix::getCgasMoisture,query.getCgasMoisture());
        queryWrapper.lambda().like(query.getCgasPressure()!=null,SbSfsix::getCgasPressure,query.getCgasPressure());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbSfsix::getMonitoringTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,SbSfsix::getMonitoringTime,query.getEndTime());//结束时间
        // queryWrapper.lambda()
        //TODO 条件待填写
        Page page = sbSfsixService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbSfsixService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbSfsix> getById(BaseReqVO request) {
        try {
            SbSfsix sbSfsix = sbSfsixService.getById(request.getId());
            return  ResultUtil.data(sbSfsix);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

