package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjDengguangService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjDengguang;
import cn.exrick.xboot.modules.huanjing.dao.HjDengguangDao;

/**
 * @desc 灯光监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjDengguangServiceImpl extends ServiceImpl<HjDengguangDao, HjDengguang> implements HjDengguangService {

    @Autowired
    HjDengguangDao hjDengguangDao;

}
