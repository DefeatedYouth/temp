package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqDefectService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqDefect;
import cn.exrick.xboot.modules.duanluqi.dao.DlqDefectDao;

/**
 * @desc 断路器缺陷信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqDefectServiceImpl extends ServiceImpl<DlqDefectDao, DlqDefect> implements DlqDefectService {

    @Autowired
    DlqDefectDao dlqDefectDao;

}
