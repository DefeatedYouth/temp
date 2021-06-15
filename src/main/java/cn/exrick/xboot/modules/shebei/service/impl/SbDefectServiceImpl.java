package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbDefectService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbDefect;
import cn.exrick.xboot.modules.shebei.dao.SbDefectDao;

/**
 * @desc 断路器缺陷信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbDefectServiceImpl extends ServiceImpl<SbDefectDao, SbDefect> implements SbDefectService {

    @Autowired
    SbDefectDao sbDefectDao;

}
