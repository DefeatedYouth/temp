package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbDangerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbDanger;
import cn.exrick.xboot.modules.shebei.dao.SbDangerDao;

/**
 * @desc 断路器隐患信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbDangerServiceImpl extends ServiceImpl<SbDangerDao, SbDanger> implements SbDangerService {

    @Autowired
    SbDangerDao sbDangerDao;

}
