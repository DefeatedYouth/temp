package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sgcc.bd.overallview.modules.huanjing.entity.*;
import com.sgcc.bd.overallview.modules.huanjing.service.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspRecords;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.face.ele.smart.modules.smart.excel
 * @description: 主设备类型
 * @author: dadi
 * @create: 2020-05-05 19:22
 */
@Slf4j
public class MoveRingListener extends AnalysisEventListener<MoveRingVo> {

    private static final int BATCH_COUNT = 1000;

    private HjChushijiService hjChushijiService;

    private HjDengguangService hjDengguangService;

    private HjFengjiService hjFengjiService;

    private HjKongtiaoService hjKongtiaoService;

    private HjSfsexService hjSfsexService;

    private HjShiduService hjShiduService;

    private HjShuibangService hjShuibangService;

    private HjShuishengService hjShuishengService;

    private HjShuiweiService hjShuiweiService;

    private HjWenduService hjWenduService;


    List<MoveRingVo> list = new ArrayList<MoveRingVo>();

    public MoveRingListener(HjChushijiService hjChushijiService,HjDengguangService hjDengguangService,HjFengjiService hjFengjiService,HjKongtiaoService hjKongtiaoService,HjSfsexService hjSfsexService,HjShiduService hjShiduService,HjShuibangService hjShuibangService,HjShuishengService hjShuishengService,HjShuiweiService hjShuiweiService,HjWenduService hjWenduService) {
        this.hjChushijiService = hjChushijiService;
        this.hjDengguangService = hjDengguangService;
        this.hjFengjiService = hjFengjiService;
        this.hjKongtiaoService = hjKongtiaoService;
        this.hjSfsexService = hjSfsexService;
        this.hjShiduService = hjShiduService;
        this.hjShuibangService = hjShuibangService;
        this.hjShuishengService = hjShuishengService;
        this.hjShuiweiService = hjShuiweiService;
        this.hjWenduService = hjWenduService;
    }

    @Override
    public void invoke(MoveRingVo moveRingVo, AnalysisContext analysisContext) {
       // LOGGER.info("解析到一条数据:{}", primaryDeviceTypeVO);
        list.add(moveRingVo);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.forEach(excelInVo -> {
            //除湿机,灯光,风机,空调,SF6,湿度,水泵,水浸,水位,温度
            switch (excelInVo.getDeviceType()){
                case "除湿机": this.dehumidifier(excelInVo);break;
                case "灯光":   this.light(excelInVo); break;
                case "风机":   this.fan(excelInVo);break;
                case "空调":   this.airConditioning(excelInVo); break;
                case "SF6":    this.sfSix(excelInVo);break;
                case "湿度":   this.humidity(excelInVo) ; break;
                case "水泵":   this.waterPump(excelInVo)  ;break;
                case "水浸":   this.flooding(excelInVo) ;break;
                case "水位":   this.waterLevel(excelInVo) ;break;
                case "温度":   this.temperature(excelInVo) ;break;
                default: break;
            }
        });
    }

    public void dehumidifier(MoveRingVo moveRingVo){
        HjChushiji hjChushiji = hjChushijiService.getBaseMapper().selectOne(new QueryWrapper<HjChushiji>().lambda().eq(HjChushiji::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjChushiji)){
            hjChushijiService.getBaseMapper().insert(hjChushiji);
        }else {
            hjChushijiService.update(new UpdateWrapper<HjChushiji>().lambda()
                    .eq(HjChushiji::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjChushiji::getResourcesId, moveRingVo.getDataSource())
                    .set(HjChushiji::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

    public void light(MoveRingVo moveRingVo){
        HjDengguang hjDengguang = hjDengguangService.getBaseMapper().selectOne(new QueryWrapper<HjDengguang>().lambda().eq(HjDengguang::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjDengguang)){
            hjDengguangService.getBaseMapper().insert(hjDengguang);
        }else {
            hjDengguangService.update(new UpdateWrapper<HjDengguang>().lambda()
                    .eq(HjDengguang::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjDengguang::getResourcesId, moveRingVo.getDataSource())
                    .set(HjDengguang::getThreeId, moveRingVo.getThreeId())
            );
        }
    }
    public void fan(MoveRingVo moveRingVo){
        HjFengji hjFengji = hjFengjiService.getBaseMapper().selectOne(new QueryWrapper<HjFengji>().lambda().eq(HjFengji::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjFengji)){
            hjFengjiService.getBaseMapper().insert(hjFengji);
        }else {
            hjFengjiService.update(new UpdateWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjFengji::getResourcesId, moveRingVo.getDataSource())
                    .set(HjFengji::getThreeId, moveRingVo.getThreeId())
            );
        }
    }
    public void airConditioning(MoveRingVo moveRingVo){
        HjKongtiao hjKongtiao = hjKongtiaoService.getBaseMapper().selectOne(new QueryWrapper<HjKongtiao>().lambda().eq(HjKongtiao::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjKongtiao)){
            hjKongtiaoService.getBaseMapper().insert(hjKongtiao);
        }else {
            hjKongtiaoService.update(new UpdateWrapper<HjKongtiao>().lambda()
                    .eq(HjKongtiao::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjKongtiao::getResourcesId, moveRingVo.getDataSource())
                    .set(HjKongtiao::getThreeId, moveRingVo.getThreeId())
            );
        }
    }
    public void sfSix(MoveRingVo moveRingVo){
        HjSfsex hjSfsex = hjSfsexService.getBaseMapper().selectOne(new QueryWrapper<HjSfsex>().lambda().eq(HjSfsex::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjSfsex)){
            hjSfsexService.getBaseMapper().insert(hjSfsex);
        }else {
            hjSfsexService.update(new UpdateWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjSfsex::getResourcesId, moveRingVo.getDataSource())
                    .set(HjSfsex::getThreeId, moveRingVo.getThreeId())
            );
        }
    }
    public void humidity(MoveRingVo moveRingVo){
        HjShidu hjShidu = hjShiduService.getBaseMapper().selectOne(new QueryWrapper<HjShidu>().lambda().eq(HjShidu::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjShidu)){
            hjShiduService.getBaseMapper().insert(hjShidu);
        }else {
            hjShiduService.update(new UpdateWrapper<HjShidu>().lambda()
                    .eq(HjShidu::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjShidu::getResourcesId, moveRingVo.getDataSource())
                    .set(HjShidu::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

    public void waterPump(MoveRingVo moveRingVo){
        HjShuibang hjShuibang = hjShuibangService.getBaseMapper().selectOne(new QueryWrapper<HjShuibang>().lambda().eq(HjShuibang::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjShuibang)){
            hjShuibangService.getBaseMapper().insert(hjShuibang);
        }else {
            hjShuibangService.update(new UpdateWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjShuibang::getResourcesId, moveRingVo.getDataSource())
                    .set(HjShuibang::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

    public void flooding(MoveRingVo moveRingVo){
        HjShuisheng hjShuisheng = hjShuishengService.getBaseMapper().selectOne(new QueryWrapper<HjShuisheng>().lambda().eq(HjShuisheng::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjShuisheng)){
            hjShuishengService.getBaseMapper().insert(hjShuisheng);
        }else {
            hjShuishengService.update(new UpdateWrapper<HjShuisheng>().lambda()
                    .eq(HjShuisheng::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjShuisheng::getResourcesId, moveRingVo.getDataSource())
                    .set(HjShuisheng::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

    public void waterLevel(MoveRingVo moveRingVo){
        HjShuiwei hjShuiwei = hjShuiweiService.getBaseMapper().selectOne(new QueryWrapper<HjShuiwei>().lambda().eq(HjShuiwei::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjShuiwei)){
            hjShuiweiService.getBaseMapper().insert(hjShuiwei);
        }else {
            hjShuiweiService.update(new UpdateWrapper<HjShuiwei>().lambda()
                    .eq(HjShuiwei::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjShuiwei::getResourcesId, moveRingVo.getDataSource())
                    .set(HjShuiwei::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

    public void temperature(MoveRingVo moveRingVo){
        HjWendu hjWendu = hjWenduService.getBaseMapper().selectOne(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getDeviceName, moveRingVo.getDeveiceName()));
        if (StringUtils.isEmpty(hjWendu)){
            hjWenduService.getBaseMapper().insert(hjWendu);
        }else {
            hjWenduService.update(new UpdateWrapper<HjWendu>().lambda()
                    .eq(HjWendu::getDeviceName, moveRingVo.getDeveiceName())
                    .set(HjWendu::getResourcesId, moveRingVo.getDataSource())
                    .set(HjWendu::getThreeId, moveRingVo.getThreeId())
            );
        }
    }

}
