package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqRealdataService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqRealdata;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqRealdataDao;

/**
 * @desc 变压器实时数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqRealdataServiceImpl extends ServiceImpl<ByqRealdataDao, ByqRealdata> implements ByqRealdataService {

    @Autowired
    ByqRealdataDao byqRealdataDao;

}
