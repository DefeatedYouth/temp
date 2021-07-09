package cn.exrick.xboot.modules.anxiaofang.controller;

import cn.exrick.xboot.common.enums.EnumNodeType;
import cn.exrick.xboot.modules.anxiaofang.dto.*;
import cn.exrick.xboot.modules.base.service.BaseDeviceService;
import cn.exrick.xboot.modules.robot.service.RobotInspMessageService;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import cn.exrick.xboot.modules.shebei.entity.SbYousepu;
import cn.exrick.xboot.modules.shebei.service.SbBookService;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import cn.exrick.xboot.modules.anxiaofang.query.AxfDeviceQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.anxiaofang.service.AxfDeviceService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

import cn.exrick.xboot.common.vo.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @desc 安消防设备监视表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/anxiaofang/axfDevice")
@Slf4j
@ApiModel(value="AxfDevice对象", description="安消防设备监视表")
@Api(tags = "anxiaofang-安消防设备监视表")
public class AxfDeviceController {

    @Autowired
    private AxfDeviceService axfDeviceService;
    @Autowired
    private BaseDeviceService baseDeviceService;
    @Autowired
    private RobotInspMessageService robotInspMessageService;
    @Autowired
    private SbBookService sbBookService;

    @Value("${storeBasePath}")
    private  String storeBasePath;

    static ExecutorService executorService = ThreadUtil.newSingleExecutor();

    /**
     * @desc 新增或更新,带id为修改，不带id为新增 提交的成功嘛
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<AxfDevice> saveOrUpdate(@Valid @RequestBody AxfDevice axfDevice){
        try {
            axfDeviceService.saveOrUpdate(axfDevice);
            return  ResultUtil.data(axfDevice);
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
    public Result<Page<AxfDevice>> list(PageVo pageVo,AxfDeviceQuery query) {
        QueryWrapper<AxfDevice> queryWrapper = new QueryWrapper<AxfDevice>() ;
        //TODO 条件待填写
        queryWrapper.lambda().like(query.getOperationMaintenanceTeam()!=null,AxfDevice::getOperationMaintenanceTeam,query.getOperationMaintenanceTeam());
        queryWrapper.lambda().eq(query.getNodeType()!=null,AxfDevice::getNodeType, EnumNodeType.valueOf(query.getNodeType()).getValue());
        queryWrapper.lambda().like(query.getNodeName()!=null,AxfDevice::getNodeName,query.getNodeName());
        queryWrapper.lambda().like(query.getDeviceName()!=null,AxfDevice::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getRealData()!=null,AxfDevice::getRealdata,query.getRealData());
        queryWrapper.lambda().gt(query.getStartTime()!= null , AxfDevice::getHappenTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,AxfDevice::getHappenTime,query.getEndTime());
        queryWrapper.lambda().eq(AxfDevice::getSiteId,query.getSiteId());
        Page page = axfDeviceService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             axfDeviceService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<AxfDevice> getById(BaseReqVO request) {
        try {
            AxfDevice axfDevice = axfDeviceService.getById(request.getId());
            return  ResultUtil.data(axfDevice);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("消防设施信息总览")
    @GetMapping("/fireFightingOvweview")
    public Result<FirefightovweviewDTO> fireFightingOvweview(BaseReqVO request) {
        try {
            FirefightovweviewDTO firefightovweviewDTO = axfDeviceService.fireFightingOvweview(request);
            return  ResultUtil.data(firefightovweviewDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("红外对射信息监视")
    @GetMapping("/infraredRadiationCount")
    public Result<InfraredRadiationCountDTO> infraredRadiationCount(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.infraredRadiationCount(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("红外双鉴信息监视")
    @GetMapping("/infraredDoubleDetector")
    public Result<InfraredRadiationCountDTO>   infraredDoubleDetector(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.infraredDoubleDetector(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("摄像头信息")
    @GetMapping("/cameraInfoCount")
    public Result<InfraredRadiationCountDTO>   cameraInfoCount(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.cameraInfoCount(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("电子围栏信息监视")
    @GetMapping("/electronicFenceNum")
    public Result<ElectronicFenceDTO>   electronicFenceNum(BaseReqVO request){
        try {
            ElectronicFenceDTO electronicFenceDTO = axfDeviceService.electronicFenceNum(request);
            return  ResultUtil.data(electronicFenceDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("门禁信息监视")
    @GetMapping("/accessControlInformation")
    public Result<AccessControlInformationDTO>   accessControlInformation(BaseReqVO request){
        try {
            AccessControlInformationDTO electronicFenceDTO = axfDeviceService.accessControlInformation(request);
            return  ResultUtil.data(electronicFenceDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @PostMapping("/upload")
    @ApiOperation("上传excel模板")
    @ResponseBody
    public Result<Object> deviceInExcel(MultipartFile file) throws IOException {
        StringBuilder fullPath = new StringBuilder(128);
        fullPath.append(storeBasePath).append(System.currentTimeMillis()).append(".xls");
        File tmpFile = new File(fullPath.toString());
        IoUtil.copy(file.getInputStream(), new FileOutputStream(tmpFile));
        ExcelReader excelReader = null;
        List<ReadSheet> readSheetList = Lists.newArrayList();
        try {
            //导入设备类型点位基础模板数据
            excelReader = EasyExcel.read(tmpFile).build();
            ReadSheet readSheet0 =
                    EasyExcel.readSheet(3).headRowNumber(4).head(PrimaryDeviceTypeVO.class).registerReadListener(new PrimaryDeviceTypeListener(sbBookService)).build();
            readSheetList.add(readSheet0);

            this.myExecutgeExcelInner(tmpFile, excelReader, readSheetList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success("已提交导入模板，请几分钟后刷新");
    }
        private void myExecutgeExcelInner(File tmpFile, ExcelReader excelReader, List<ReadSheet> readSheetList) {
            executorService.execute(() -> {
                try {
                    excelReader.read(readSheetList);
                    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                    excelReader.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                   // log.error("上传导入异常{}", e.printStackTrace());
                } finally {
                    System.gc();
                    FileUtil.del(tmpFile);
                }
            });

        }

}

