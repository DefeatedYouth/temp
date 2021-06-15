package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbFuheService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbFuhe;
import cn.exrick.xboot.modules.shebei.dao.SbFuheDao;

/**
 * @desc 断路器负荷数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFuheServiceImpl extends ServiceImpl<SbFuheDao, SbFuhe> implements SbFuheService {

    @Autowired
    SbFuheDao sbFuheDao;

}
