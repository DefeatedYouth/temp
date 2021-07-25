package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/21 15:35
 * @File: ExcelInVo
 */
@Data
public class MoveRingVo {

    @ExcelProperty("数据源台账ID")
    private String dataSource;

    @ExcelProperty("设备名称")
    private String deveiceName;

    @ExcelProperty("设备类型")
    private String deviceType;

    @ExcelProperty("三维模型id")
    private String threeId;


}
