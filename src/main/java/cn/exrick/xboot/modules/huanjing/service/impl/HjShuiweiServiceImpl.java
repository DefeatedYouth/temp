package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.modules.huanjing.service.HjShuiweiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjShuiwei;
import cn.exrick.xboot.modules.huanjing.dao.HjShuiweiDao;

/**
 * @desc 水位传感器监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuiweiServiceImpl extends ServiceImpl<HjShuiweiDao, HjShuiwei> implements HjShuiweiService {

    @Autowired
    HjShuiweiDao hjShuiweiDao;

}
