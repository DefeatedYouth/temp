package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbRealdataService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbRealdata;
import cn.exrick.xboot.modules.shebei.dao.SbRealdataDao;

/**
 * @desc 断路器实时状态数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbRealdataServiceImpl extends ServiceImpl<SbRealdataDao, SbRealdata> implements SbRealdataService {

    @Autowired
    SbRealdataDao sbRealdataDao;

}
