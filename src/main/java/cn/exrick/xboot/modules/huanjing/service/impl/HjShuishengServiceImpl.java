package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjShuishengService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjShuisheng;
import cn.exrick.xboot.modules.huanjing.dao.HjShuishengDao;

/**
 * @desc 水浸传感器监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuishengServiceImpl extends ServiceImpl<HjShuishengDao, HjShuisheng> implements HjShuishengService {

    @Autowired
    HjShuishengDao hjShuishengDao;

}
