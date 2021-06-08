package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqYoushepuService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqYoushepu;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqYoushepuDao;

/**
 * @desc 变压器油色谱表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqYoushepuServiceImpl extends ServiceImpl<ByqYoushepuDao, ByqYoushepu> implements ByqYoushepuService {

    @Autowired
    ByqYoushepuDao byqYoushepuDao;

}
