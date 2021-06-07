package cn.exrick.xboot.modules.nj.service.impl;


import cn.exrick.xboot.modules.nj.service.NjDeviceToCameraService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.nj.entity.NjDeviceToCamera;
import cn.exrick.xboot.modules.nj.dao.NjDeviceToCameraDao;

/**
 * @desc 设备与摄像机的关联表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Service
public class NjDeviceToCameraServiceImpl extends ServiceImpl<NjDeviceToCameraDao, NjDeviceToCamera> implements NjDeviceToCameraService {

    @Autowired
    NjDeviceToCameraDao njDeviceToCameraDao;

}
