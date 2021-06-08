package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqOverhaulService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqOverhaul;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqOverhaulDao;

/**
 * @desc 设备履历检修信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqOverhaulServiceImpl extends ServiceImpl<ByqOverhaulDao, ByqOverhaul> implements ByqOverhaulService {

    @Autowired
    ByqOverhaulDao byqOverhaulDao;

}
