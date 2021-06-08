package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjShiduService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjShidu;
import cn.exrick.xboot.modules.huanjing.dao.HjShiduDao;

/**
 * @desc 湿度监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShiduServiceImpl extends ServiceImpl<HjShiduDao, HjShidu> implements HjShiduService {

    @Autowired
    HjShiduDao hjShiduDao;

}
