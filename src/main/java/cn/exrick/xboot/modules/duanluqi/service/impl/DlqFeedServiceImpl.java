package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqFeedService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqFeed;
import cn.exrick.xboot.modules.duanluqi.dao.DlqFeedDao;

/**
 * @desc 断路器状态评价数据数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqFeedServiceImpl extends ServiceImpl<DlqFeedDao, DlqFeed> implements DlqFeedService {

    @Autowired
    DlqFeedDao dlqFeedDao;

}
