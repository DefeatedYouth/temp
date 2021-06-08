package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqDangerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqDanger;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqDangerDao;

/**
 * @desc 变压器隐患信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqDangerServiceImpl extends ServiceImpl<ByqDangerDao, ByqDanger> implements ByqDangerService {

    @Autowired
    ByqDangerDao byqDangerDao;

}
