package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspRecords;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspRecordsService;
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
public class RobotListener extends AnalysisEventListener<ExcelInVo> {

    private static final int BATCH_COUNT = 1000;


    private RobotInspRecordsService robotInspRecordsService;

    List<ExcelInVo> list = new ArrayList<ExcelInVo>();

    public RobotListener(RobotInspRecordsService robotInspRecordsService) {
        this.robotInspRecordsService = robotInspRecordsService;
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
            RobotInspRecords robotInspRecords = robotInspRecordsService.getBaseMapper().selectOne(new QueryWrapper<RobotInspRecords>().lambda().eq(RobotInspRecords::getRobotName, excelInVo.getDeveiceName()));
            if (StringUtils.isEmpty(robotInspRecords)){
                robotInspRecordsService.getBaseMapper().insert(robotInspRecords);
            }else {
                robotInspRecordsService.update(new UpdateWrapper<RobotInspRecords>().lambda()
                        .eq(RobotInspRecords::getRobotName, excelInVo.getDeveiceName())
                        .set(RobotInspRecords::getResourcesId, excelInVo.getDataSource())
                        .set(RobotInspRecords::getThreeId, excelInVo.getThreeId())
                );
            }
        });
    }
}
