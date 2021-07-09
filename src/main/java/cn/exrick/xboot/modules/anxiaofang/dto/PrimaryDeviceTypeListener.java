package cn.exrick.xboot.modules.anxiaofang.dto;

import cn.exrick.xboot.common.enums.EnumDeviceType;
import cn.exrick.xboot.modules.base.entity.BaseDevice;
import cn.exrick.xboot.modules.base.service.BaseDeviceService;
import cn.exrick.xboot.modules.robot.entity.RobotInspMessage;
import cn.exrick.xboot.modules.robot.service.RobotInspMessageService;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import cn.exrick.xboot.modules.shebei.service.SbBookService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.face.ele.smart.modules.smart.excel
 * @description: 主设备类型
 * @author: dadi
 * @create: 2020-05-05 19:22
 */
@Slf4j
public class PrimaryDeviceTypeListener extends AnalysisEventListener<PrimaryDeviceTypeVO> {
   // private static final Logger LOGGER = LoggerFactory.getLogger(DeciceListener.class);
    private static final int BATCH_COUNT = 1000;

    private SbBookService sbBookService;

    List<PrimaryDeviceTypeVO> list = new ArrayList<PrimaryDeviceTypeVO>();

    public PrimaryDeviceTypeListener(SbBookService sbBookService) {
        this.sbBookService = sbBookService;
    }

    @Override
    public void invoke(PrimaryDeviceTypeVO primaryDeviceTypeVO, AnalysisContext analysisContext) {
       // LOGGER.info("解析到一条数据:{}", primaryDeviceTypeVO);
     /*   if (analysisContext.readRowHolder().getRowIndex() == 5) {
            list = new ArrayList<PrimaryDeviceTypeVO>();
        }*/
        list.add(primaryDeviceTypeVO);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.forEach(primaryDeviceTypeVO -> {
            SbBook sbBook = new SbBook();
            sbBook.setSiteName(primaryDeviceTypeVO.getSiteName());
            sbBook.setSiteId(1L);
            sbBook.setVoltageLevel(primaryDeviceTypeVO.getVoltageLevel());
            sbBook.setDeviceType(EnumDeviceType.textOf(primaryDeviceTypeVO.getDeviceType()).getValue());
            sbBook.setSpacerUnit(primaryDeviceTypeVO.getSpaceUnit());
            sbBook.setDeviceName(primaryDeviceTypeVO.getDeviceName());
            sbBook.setFarewell(primaryDeviceTypeVO.getFarewell());
            sbBookService.save(sbBook);
        });

        //saveData();
       // redisHelper.hset(SmartConstants.redis_excel_import_plan_map,"1",SmartConstants.redis_excel_import_plan_key_device_type,"1");
    }



}
