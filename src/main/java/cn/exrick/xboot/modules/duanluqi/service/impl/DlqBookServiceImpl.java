package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqBookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqBook;
import cn.exrick.xboot.modules.duanluqi.dao.DlqBookDao;

/**
 * @desc 断路器设备台账 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqBookServiceImpl extends ServiceImpl<DlqBookDao, DlqBook> implements DlqBookService {

    @Autowired
    DlqBookDao dlqBookDao;

}
