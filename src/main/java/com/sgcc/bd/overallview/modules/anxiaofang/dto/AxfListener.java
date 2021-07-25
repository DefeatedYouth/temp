package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sgcc.bd.overallview.modules.anxiaofang.entity.AxfDevice;
import com.sgcc.bd.overallview.modules.anxiaofang.service.AxfDeviceService;
import com.sgcc.bd.overallview.modules.shebei.entity.SbBook;
import com.sgcc.bd.overallview.modules.shebei.service.SbBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.face.ele.smart.modules.smart.excel
 * @description: 主设备类型
 * @author: dadi
 * @create: 2020-05-05 19:22
 */
@Slf4j
public class AxfListener extends AnalysisEventListener<ExcelInVo> {

    private static final int BATCH_COUNT = 1000;


    private AxfDeviceService axfDeviceService;

    List<ExcelInVo> list = new ArrayList<ExcelInVo>();

    public AxfListener(AxfDeviceService axfDeviceService) {
        this.axfDeviceService = axfDeviceService;
    }

    @Override
    public void invoke(ExcelInVo excelInVo, AnalysisContext analysisContext) {
       // LOGGER.info("解析到一条数据:{}", primaryDeviceTypeVO);
        list.add(excelInVo);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.forEach(excelInVo -> {
            AxfDevice axfDevice = axfDeviceService.getBaseMapper().selectOne(new QueryWrapper<AxfDevice>().lambda().eq(AxfDevice::getDeviceName, excelInVo.getDeveiceName()));
            if (StringUtils.isEmpty(axfDevice)){
                axfDeviceService.getBaseMapper().insert(axfDevice);
            }else {
                axfDeviceService.update(new UpdateWrapper<AxfDevice>().lambda()
                        .eq(AxfDevice::getDeviceName, excelInVo.getDeveiceName())
                        .set(AxfDevice::getResourcesId, excelInVo.getDataSource())
                        .set(AxfDevice::getThreeId, excelInVo.getThreeId())
                );
            }
        });
    }
}
