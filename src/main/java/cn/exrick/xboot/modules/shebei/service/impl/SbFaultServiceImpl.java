package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbFaultService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbFault;
import cn.exrick.xboot.modules.shebei.dao.SbFaultDao;

/**
 * @desc 设备履历故障记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFaultServiceImpl extends ServiceImpl<SbFaultDao, SbFault> implements SbFaultService {

    @Autowired
    SbFaultDao sbFaultDao;

}
