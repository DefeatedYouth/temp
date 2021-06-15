package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbTestService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbTest;
import cn.exrick.xboot.modules.shebei.dao.SbTestDao;

/**
 * @desc 断路器履历实验信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbTestServiceImpl extends ServiceImpl<SbTestDao, SbTest> implements SbTestService {

    @Autowired
    SbTestDao sbTestDao;

}
