package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqFuheService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqFuhe;
import cn.exrick.xboot.modules.duanluqi.dao.DlqFuheDao;

/**
 * @desc 断路器负荷数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqFuheServiceImpl extends ServiceImpl<DlqFuheDao, DlqFuhe> implements DlqFuheService {

    @Autowired
    DlqFuheDao dlqFuheDao;

}
