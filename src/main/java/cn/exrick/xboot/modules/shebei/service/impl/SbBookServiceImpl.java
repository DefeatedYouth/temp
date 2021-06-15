package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbBookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbBook;
import cn.exrick.xboot.modules.shebei.dao.SbBookDao;

/**
 * @desc 断路器设备台账 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbBookServiceImpl extends ServiceImpl<SbBookDao, SbBook> implements SbBookService {

    @Autowired
    SbBookDao sbBookDao;

}
