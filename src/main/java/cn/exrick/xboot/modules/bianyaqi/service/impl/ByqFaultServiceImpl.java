package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqFaultService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqFault;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqFaultDao;

/**
 * @desc 设备履历故障记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqFaultServiceImpl extends ServiceImpl<ByqFaultDao, ByqFault> implements ByqFaultService {

    @Autowired
    ByqFaultDao byqFaultDao;

}
