package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseCameraRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseCameraRecords;
import cn.exrick.xboot.modules.base.dao.BaseCameraRecordsDao;

/**
 * @desc  摄像机录像识别记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseCameraRecordsServiceImpl extends ServiceImpl<BaseCameraRecordsDao, BaseCameraRecords> implements BaseCameraRecordsService {

    @Autowired
    BaseCameraRecordsDao baseCameraRecordsDao;

}
