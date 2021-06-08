package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjKongtiaoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjKongtiao;
import cn.exrick.xboot.modules.huanjing.dao.HjKongtiaoDao;

/**
 * @desc 空调监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjKongtiaoServiceImpl extends ServiceImpl<HjKongtiaoDao, HjKongtiao> implements HjKongtiaoService {

    @Autowired
    HjKongtiaoDao hjKongtiaoDao;

}
