package cn.exrick.xboot.modules.nj.service.impl;


import cn.exrick.xboot.modules.nj.entity.NjDevice;
import cn.exrick.xboot.modules.nj.service.NjDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.nj.dao.NjDeviceDao;

/**
 * @desc 主设备表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Service
public class NjDeviceServiceImpl extends ServiceImpl<NjDeviceDao, NjDevice> implements NjDeviceService {

    @Autowired
    NjDeviceDao njDeviceDao;

}
