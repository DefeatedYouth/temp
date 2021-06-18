package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.MunicipalCompanyVO;
import cn.exrick.xboot.modules.base.entity.BaseDeviceToCamera;
import cn.exrick.xboot.modules.base.service.BasePlaceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BasePlace;
import cn.exrick.xboot.modules.base.dao.BasePlaceDao;

import java.util.List;

/**
 * @desc  serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class BasePlaceServiceImpl extends ServiceImpl<BasePlaceDao, BasePlace> implements BasePlaceService {

    @Autowired
    BasePlaceDao basePlaceDao;

    @Override
    public List<BasePlace> getMunicipalCompany(MunicipalCompanyVO municipalCompanyVO) {

        try {
            List<BasePlace> basePlaces =
                    this.getBaseMapper().selectList(new QueryWrapper<BasePlace>().lambda()
                            .eq(BasePlace::getLevel, municipalCompanyVO.getLevel())
                            .eq(municipalCompanyVO.getParentId()!=null&&!municipalCompanyVO.getParentId().equals(""),BasePlace::getParentId,municipalCompanyVO.getParentId())
                            .eq(municipalCompanyVO.getVoltageLevel()!=null&&!municipalCompanyVO.getVoltageLevel().equals(""),BasePlace::getVoltageLevel,municipalCompanyVO.getVoltageLevel())
                    );
            return basePlaces;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
