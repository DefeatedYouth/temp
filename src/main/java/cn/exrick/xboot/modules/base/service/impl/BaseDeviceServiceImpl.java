package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseDevice;
import cn.exrick.xboot.modules.base.dao.BaseDeviceDao;

/**
 * @desc 主设备表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseDeviceServiceImpl extends ServiceImpl<BaseDeviceDao, BaseDevice> implements BaseDeviceService {

    @Autowired
    BaseDeviceDao baseDeviceDao;

}
