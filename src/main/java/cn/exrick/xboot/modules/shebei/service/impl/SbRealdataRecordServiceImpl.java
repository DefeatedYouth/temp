package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbRealdataRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbRealdataRecord;
import cn.exrick.xboot.modules.shebei.dao.SbRealdataRecordDao;

/**
 * @desc 设备实时状态历史数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Service
public class SbRealdataRecordServiceImpl extends ServiceImpl<SbRealdataRecordDao, SbRealdataRecord> implements SbRealdataRecordService {

    @Autowired
    SbRealdataRecordDao sbRealdataRecordDao;

}
