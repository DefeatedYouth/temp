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

    @ExcelProperty("*变电站名称")
    private String siteName;

    @ExcelProperty("*电压等级")
    private String voltageLevel;

    @ExcelProperty("设备类型名称")
    private String deviceType;

    @ExcelProperty("间隔单元")
    private String spaceUnit;

    @ExcelProperty("*设备名称")
    private String deviceName;

    @ExcelProperty("相别")
    private String farewell;
}
