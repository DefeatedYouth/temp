package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjSfsexService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjSfsex;
import cn.exrick.xboot.modules.huanjing.dao.HjSfsexDao;

/**
 * @desc SF6监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjSfsexServiceImpl extends ServiceImpl<HjSfsexDao, HjSfsex> implements HjSfsexService {

    @Autowired
    HjSfsexDao hjSfsexDao;

}
