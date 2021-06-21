package cn.exrick.xboot.modules.anxiaofang.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 安消防设备监视表 实体
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="AxfDevice对象", description="安消防设备监视表")
public class AxfDevice extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "1=变压器消防监视列表;	2=烟感探测器监视列表;	3=火灾探测器消防监视列表;	4=消防装置故障监视列表;	5=门禁异常监视列表;	6=门禁故障监视列表;	7=门禁报警监视列表;	8=电源故障监视列表;	9=通讯异常监视列表;	10=防区报警监视列表;	11=故障监视列表;	12=通信异常监视列表;	13=监控告警监视列表;	14=故障监视列表;	15=电源异常监视列表;	16=报警监视列表;	17=故障监视列表;	18=电源异常监视列表;	19=报警监视列表;	")
    private String deviceType;

    @ApiModelProperty(value = "节点类型")
    private String nodeType;

    @ApiModelProperty(value = "设备状态")
    private String deviceState;

    @ApiModelProperty(value = "事件描述")
    private String eventDesc;

    @ApiModelProperty(value = "通信状态")
    private String linkState;

    @ApiModelProperty(value = "报警状态")
    private String alarmState;

    @ApiModelProperty(value = "实时数据")
    private String realdata;

    @ApiModelProperty(value = "节点名称")
    private String nodeName;
}
