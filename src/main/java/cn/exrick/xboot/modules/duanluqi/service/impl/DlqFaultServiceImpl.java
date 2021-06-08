package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqFaultService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqFault;
import cn.exrick.xboot.modules.duanluqi.dao.DlqFaultDao;

/**
 * @desc 设备履历故障记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqFaultServiceImpl extends ServiceImpl<DlqFaultDao, DlqFault> implements DlqFaultService {

    @Autowired
    DlqFaultDao dlqFaultDao;

}
