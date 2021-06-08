package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjWenduService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjWendu;
import cn.exrick.xboot.modules.huanjing.dao.HjWenduDao;

/**
 * @desc 温度监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjWenduServiceImpl extends ServiceImpl<HjWenduDao, HjWendu> implements HjWenduService {

    @Autowired
    HjWenduDao hjWenduDao;

}
