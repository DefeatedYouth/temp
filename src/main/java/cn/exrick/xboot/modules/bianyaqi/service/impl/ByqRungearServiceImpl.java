package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqRungearService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqRungear;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqRungearDao;

/**
 * @desc 变压器运行档位表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqRungearServiceImpl extends ServiceImpl<ByqRungearDao, ByqRungear> implements ByqRungearService {

    @Autowired
    ByqRungearDao byqRungearDao;

}
