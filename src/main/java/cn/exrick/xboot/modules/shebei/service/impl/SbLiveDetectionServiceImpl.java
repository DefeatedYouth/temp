package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbLiveDetectionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbLiveDetection;
import cn.exrick.xboot.modules.shebei.dao.SbLiveDetectionDao;

/**
 * @desc 设备带电测试记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Service
public class SbLiveDetectionServiceImpl extends ServiceImpl<SbLiveDetectionDao, SbLiveDetection> implements SbLiveDetectionService {

    @Autowired
    SbLiveDetectionDao sbLiveDetectionDao;

}
