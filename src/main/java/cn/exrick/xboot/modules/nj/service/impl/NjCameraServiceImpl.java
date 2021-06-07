package cn.exrick.xboot.modules.nj.service.impl;


import cn.exrick.xboot.modules.nj.service.NjCameraService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.nj.entity.NjCamera;
import cn.exrick.xboot.modules.nj.dao.NjCameraDao;

/**
 * @desc  摄像机表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Service
public class NjCameraServiceImpl extends ServiceImpl<NjCameraDao, NjCamera> implements NjCameraService {

    @Autowired
    NjCameraDao njCameraDao;

}
