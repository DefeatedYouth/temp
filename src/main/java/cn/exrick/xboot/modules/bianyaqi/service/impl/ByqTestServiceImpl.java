package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqTestService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqTest;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqTestDao;

/**
 * @desc 设备履历实验记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqTestServiceImpl extends ServiceImpl<ByqTestDao, ByqTest> implements ByqTestService {

    @Autowired
    ByqTestDao byqTestDao;

}
