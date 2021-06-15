package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbOverhaulService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbOverhaul;
import cn.exrick.xboot.modules.shebei.dao.SbOverhaulDao;

/**
 * @desc 断路器履历检修信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbOverhaulServiceImpl extends ServiceImpl<SbOverhaulDao, SbOverhaul> implements SbOverhaulService {

    @Autowired
    SbOverhaulDao sbOverhaulDao;

}
