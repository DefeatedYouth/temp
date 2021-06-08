package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjShuibangService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjShuibang;
import cn.exrick.xboot.modules.huanjing.dao.HjShuibangDao;

/**
 * @desc 水泵监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuibangServiceImpl extends ServiceImpl<HjShuibangDao, HjShuibang> implements HjShuibangService {

    @Autowired
    HjShuibangDao hjShuibangDao;

}
