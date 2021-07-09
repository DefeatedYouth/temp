package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseEquipmentInvestigationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseEquipmentInvestigation;
import cn.exrick.xboot.modules.base.dao.BaseEquipmentInvestigationDao;

/**
 * @desc 设备排查表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BaseEquipmentInvestigationServiceImpl extends ServiceImpl<BaseEquipmentInvestigationDao, BaseEquipmentInvestigation> implements BaseEquipmentInvestigationService {

    @Autowired
    BaseEquipmentInvestigationDao baseEquipmentInvestigationDao;

}
