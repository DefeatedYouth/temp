package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sgcc.bd.overallview.modules.base.entity.BaseCamera;
import com.sgcc.bd.overallview.modules.base.service.BaseCameraService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sgcc.bd.overallview.modules.shebei.entity.SbBook;
import com.sgcc.bd.overallview.modules.shebei.service.SbBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BaseCameraListener extends AnalysisEventListener<ExcelInVo> {

    private static final int BATCH_COUNT = 1000;

    private BaseCameraService baseCameraService;

    List<ExcelInVo> list = new ArrayList<ExcelInVo>();

    public BaseCameraListener(BaseCameraService baseCameraService) {
        this.baseCameraService = baseCameraService;
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
            BaseCamera baseCamera = baseCameraService.getBaseMapper().selectOne(new QueryWrapper<BaseCamera>().lambda().eq(BaseCamera::getCameraName, excelInVo.getDeveiceName()));
            if (StringUtils.isEmpty(baseCamera)){
                baseCameraService.getBaseMapper().insert(baseCamera);
            }else {
                baseCameraService.update(new UpdateWrapper<BaseCamera>().lambda()
                        .eq(BaseCamera::getCameraName, excelInVo.getDeveiceName())
                        .set(BaseCamera::getResourcesId, excelInVo.getDataSource())
                        .set(BaseCamera::getThreeId, excelInVo.getThreeId())
                );
            }
        });
        //saveData();
        // redisHelper.hset(SmartConstants.redis_excel_import_plan_map,"1",SmartConstants.redis_excel_import_plan_key_device_type,"1");
    }

}
