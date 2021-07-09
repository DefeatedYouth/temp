package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbSparePartsListService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbSparePartsList;
import cn.exrick.xboot.modules.shebei.dao.SbSparePartsListDao;

/**
 * @desc 备品备件表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbSparePartsListServiceImpl extends ServiceImpl<SbSparePartsListDao, SbSparePartsList> implements SbSparePartsListService {

    @Autowired
    SbSparePartsListDao sbSparePartsListDao;

}
