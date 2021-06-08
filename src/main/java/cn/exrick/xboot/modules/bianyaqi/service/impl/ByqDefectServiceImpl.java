package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqDefectService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqDefect;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqDefectDao;

/**
 * @desc 变压器缺陷信息账表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqDefectServiceImpl extends ServiceImpl<ByqDefectDao, ByqDefect> implements ByqDefectService {

    @Autowired
    ByqDefectDao byqDefectDao;

}
