package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqRealdataService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqRealdata;
import cn.exrick.xboot.modules.duanluqi.dao.DlqRealdataDao;

/**
 * @desc 断路器实时状态数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqRealdataServiceImpl extends ServiceImpl<DlqRealdataDao, DlqRealdata> implements DlqRealdataService {

    @Autowired
    DlqRealdataDao dlqRealdataDao;

}
