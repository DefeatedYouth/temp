package cn.exrick.xboot.modules.base.service;

import cn.exrick.xboot.common.vo.MunicipalCompanyVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.base.entity.BasePlace;

import java.util.List;


/**
 * @desc  service
 * @author chenfeixiang
 * @since 2021-06-10
 */
public interface BasePlaceService  extends IService<BasePlace>{

    List<BasePlace> getMunicipalCompany(MunicipalCompanyVO municipalCompanyVO);
}
