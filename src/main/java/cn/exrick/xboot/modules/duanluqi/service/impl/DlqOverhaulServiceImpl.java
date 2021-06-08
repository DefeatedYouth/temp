package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqOverhaulService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqOverhaul;
import cn.exrick.xboot.modules.duanluqi.dao.DlqOverhaulDao;

/**
 * @desc 断路器履历检修信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqOverhaulServiceImpl extends ServiceImpl<DlqOverhaulDao, DlqOverhaul> implements DlqOverhaulService {

    @Autowired
    DlqOverhaulDao dlqOverhaulDao;

}
