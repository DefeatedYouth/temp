package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbHiddenDangersCountermeasuresService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbHiddenDangersCountermeasures;
import cn.exrick.xboot.modules.shebei.dao.SbHiddenDangersCountermeasuresDao;

/**
 * @desc 隐患反措专项排查表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbHiddenDangersCountermeasuresServiceImpl extends ServiceImpl<SbHiddenDangersCountermeasuresDao, SbHiddenDangersCountermeasures> implements SbHiddenDangersCountermeasuresService {

    @Autowired
    SbHiddenDangersCountermeasuresDao sbHiddenDangersCountermeasuresDao;

}
