package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjChushijiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjChushiji;
import cn.exrick.xboot.modules.huanjing.dao.HjChushijiDao;

/**
 * @desc 除湿机监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjChushijiServiceImpl extends ServiceImpl<HjChushijiDao, HjChushiji> implements HjChushijiService {

    @Autowired
    HjChushijiDao hjChushijiDao;

}
