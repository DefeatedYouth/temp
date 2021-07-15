package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumDangerStatus;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.sgcc.bd.overallview.modules.shebei.service.SbDangerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgcc.bd.overallview.modules.shebei.dao.SbDangerDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbDanger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器隐患信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbDangerServiceImpl extends ServiceImpl<SbDangerDao, SbDanger> implements SbDangerService {

    @Autowired
    SbDangerDao sbDangerDao;

    @Override
    public SbDefectDTO getCountDangerNum(BaseReqVO request) {
        try {
            SbDefectDTO sbDangger = new SbDefectDTO();

            Integer common = this.count(new QueryWrapper<SbDanger>().lambda().eq(SbDanger::getDeviceType, request.getType())
                    .eq(SbDanger::getSiteId,request.getSiteId())
                    .eq(SbDanger::getHiddenDangerLevel, EnumDangerStatus.Common.getValue()));
            Integer severity = this.count(new QueryWrapper<SbDanger>().lambda()
                    .eq(SbDanger::getSiteId,request.getSiteId())
                    .eq(SbDanger::getDeviceType, request.getType()).eq(SbDanger::getHiddenDangerLevel, EnumDangerStatus.Severity.getValue()));
            // Integer notdefect = sbDangerService.getBaseMapper().selectCount(new QueryWrapper<SbDanger>().lambda().eq(SbDanger::getDeviceType, "变压器").eq(SbDanger::getHiddenDangerLevel, EnumDangerStatus.notdefect.getValue()));
            sbDangger.setCommonNum(common);
            sbDangger.setSeverityNum(severity);
            //sbDefect.setCriticalNum(critical);
            sbDangger.setNotdefectNum(common+severity);
            return  sbDangger;
            //todo 根据前端传过来的设备类型来查询 具体是什么设备的缺陷信息统计 这里是写死的 变压器，后面根据传过来的type进行修改。
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
