package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqDangerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqDanger;
import cn.exrick.xboot.modules.duanluqi.dao.DlqDangerDao;

/**
 * @desc 断路器隐患信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqDangerServiceImpl extends ServiceImpl<DlqDangerDao, DlqDanger> implements DlqDangerService {

    @Autowired
    DlqDangerDao dlqDangerDao;

}
