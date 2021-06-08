package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqBookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqBook;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqBookDao;

/**
 * @desc 变压器台账表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqBookServiceImpl extends ServiceImpl<ByqBookDao, ByqBook> implements ByqBookService {

    @Autowired
    ByqBookDao byqBookDao;

}
