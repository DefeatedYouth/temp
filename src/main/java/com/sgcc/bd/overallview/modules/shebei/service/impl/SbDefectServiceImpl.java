package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumDefectStatus;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.sgcc.bd.overallview.modules.shebei.service.SbDefectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgcc.bd.overallview.modules.shebei.dao.SbDefectDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbDefect;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器缺陷信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbDefectServiceImpl extends ServiceImpl<SbDefectDao, SbDefect> implements SbDefectService {

    @Autowired
    SbDefectDao sbDefectDao;

    @Override
    public SbDefectDTO getCountDefectNum(BaseReqVO request) {
        try {
            SbDefectDTO sbDefect = new SbDefectDTO();

            QueryWrapper<SbDefect> sbDefectQueryWrapper = new QueryWrapper<>();

            Integer common = this.count(sbDefectQueryWrapper.lambda().eq(SbDefect::getDeviceType, request.getType())
                    .eq(SbDefect::getSiteId,request.getSiteId())
                    .eq(SbDefect::getDefectLevel, EnumDefectStatus.Common.getValue()));
            Integer severity = this.count(new QueryWrapper<SbDefect>().lambda()
                    .eq(SbDefect::getSiteId,request.getSiteId())
                    .eq(request.getType()!=null,SbDefect::getDeviceType, request.getType()).eq(SbDefect::getDefectLevel, EnumDefectStatus.Severity.getValue()));
            Integer critical = this.count(new QueryWrapper<SbDefect>().lambda()
                    .eq(SbDefect::getSiteId,request.getSiteId())
                    .eq(request.getType()!=null,SbDefect::getDeviceType, request.getType()).eq(SbDefect::getDefectLevel, EnumDefectStatus.Critical.getValue()));
            //Integer notdefect = sbDefectService.getBaseMapper().selectCount(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getDeviceType, "变压器").eq(SbDefect::getDefectLevel, EnumDefectStatus.notdefect.getValue()));
            sbDefect.setCommonNum(common);
            sbDefect.setSeverityNum(severity);
            sbDefect.setCriticalNum(critical);
            int notdefectNum = this.count(new QueryWrapper<SbDefect>().lambda()
                    .eq(SbDefect::getDeviceType, request.getType())
                    .eq(SbDefect::getSiteId, request.getSiteId())
                    .eq(SbDefect::getDefaultState, "未消缺")
            );
            sbDefect.setNotdefectNum(notdefectNum);
            int overNum = this.count(new QueryWrapper<SbDefect>().lambda().eq(SbDefect::getSiteId, request.getSiteId())
                    .eq(SbDefect::getDeviceType, request.getType())
                    .eq(SbDefect::getIsOver, "是")
                    .eq(SbDefect::getDefaultState, "未消缺")
            );
            sbDefect.setOvernotdefectNum(overNum);
            return  sbDefect;
            //todo 根据前端传过来的设备类型来查询 具体是什么设备的缺陷信息统计 这里是写死的 变压器，后面根据传过来的type进行修改。
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
