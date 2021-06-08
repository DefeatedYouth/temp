package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqFuheService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqFuhe;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqFuheDao;

/**
 * @desc 变压器负荷信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqFuheServiceImpl extends ServiceImpl<ByqFuheDao, ByqFuhe> implements ByqFuheService {

    @Autowired
    ByqFuheDao byqFuheDao;

}
