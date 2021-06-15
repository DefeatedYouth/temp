package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbFeedService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbFeed;
import cn.exrick.xboot.modules.shebei.dao.SbFeedDao;

/**
 * @desc 断路器状态评价数据数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFeedServiceImpl extends ServiceImpl<SbFeedDao, SbFeed> implements SbFeedService {

    @Autowired
    SbFeedDao sbFeedDao;

}
