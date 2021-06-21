package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbYousepuService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbYousepu;
import cn.exrick.xboot.modules.shebei.dao.SbYousepuDao;

/**
 * @desc 设备油色谱表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Service
public class SbYousepuServiceImpl extends ServiceImpl<SbYousepuDao, SbYousepu> implements SbYousepuService {

    @Autowired
    SbYousepuDao sbYousepuDao;

}
