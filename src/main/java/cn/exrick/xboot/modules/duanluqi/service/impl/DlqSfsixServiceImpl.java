package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqSfsixService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqSfsix;
import cn.exrick.xboot.modules.duanluqi.dao.DlqSfsixDao;

/**
 * @desc 断路器sf6监测数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqSfsixServiceImpl extends ServiceImpl<DlqSfsixDao, DlqSfsix> implements DlqSfsixService {

    @Autowired
    DlqSfsixDao dlqSfsixDao;

}
