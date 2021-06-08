package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseDeviceToCameraService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseDeviceToCamera;
import cn.exrick.xboot.modules.base.dao.BaseDeviceToCameraDao;

/**
 * @desc 设备与摄像机的关联表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseDeviceToCameraServiceImpl extends ServiceImpl<BaseDeviceToCameraDao, BaseDeviceToCamera> implements BaseDeviceToCameraService {

    @Autowired
    BaseDeviceToCameraDao baseDeviceToCameraDao;

}
