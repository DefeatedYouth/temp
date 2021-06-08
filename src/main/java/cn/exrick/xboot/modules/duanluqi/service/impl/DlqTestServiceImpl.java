package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqTestService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqTest;
import cn.exrick.xboot.modules.duanluqi.dao.DlqTestDao;

/**
 * @desc 断路器履历实验信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqTestServiceImpl extends ServiceImpl<DlqTestDao, DlqTest> implements DlqTestService {

    @Autowired
    DlqTestDao dlqTestDao;

}
