package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BasePlaceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BasePlace;
import cn.exrick.xboot.modules.base.dao.BasePlaceDao;

/**
 * @desc  serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class BasePlaceServiceImpl extends ServiceImpl<BasePlaceDao, BasePlace> implements BasePlaceService {

    @Autowired
    BasePlaceDao basePlaceDao;

}
