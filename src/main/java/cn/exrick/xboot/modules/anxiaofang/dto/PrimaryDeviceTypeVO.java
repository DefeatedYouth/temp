package cn.exrick.xboot.modules.anxiaofang.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/3 10:12
 * @File: PrimaryDeviceTypeVO
 */
@Data
public class PrimaryDeviceTypeVO {

    @ExcelProperty("序号")
    private Integer attr;

    @ExcelProperty("设备巡检时间")
    private Date inspTime;

    @ExcelProperty("间隔设备命名编号")
    private String equipmentNameNumber;

  /*  @ExcelProperty("环境温度(℃)")
    private String inspValue;*/

    @ExcelProperty("结果")
    private String inspValue;

 /*   @ExcelProperty("简要分析")
    private String deviceName;*/
}
