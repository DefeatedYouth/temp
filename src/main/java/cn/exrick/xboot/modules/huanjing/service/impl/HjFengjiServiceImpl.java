package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjFengjiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjFengji;
import cn.exrick.xboot.modules.huanjing.dao.HjFengjiDao;

/**
 * @desc 风机监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjFengjiServiceImpl extends ServiceImpl<HjFengjiDao, HjFengji> implements HjFengjiService {

    @Autowired
    HjFengjiDao hjFengjiDao;

}
