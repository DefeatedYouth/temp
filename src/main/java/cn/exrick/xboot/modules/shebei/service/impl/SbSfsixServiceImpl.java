package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbSfsixService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbSfsix;
import cn.exrick.xboot.modules.shebei.dao.SbSfsixDao;

/**
 * @desc 断路器sf6监测数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbSfsixServiceImpl extends ServiceImpl<SbSfsixDao, SbSfsix> implements SbSfsixService {

    @Autowired
    SbSfsixDao sbSfsixDao;

}
