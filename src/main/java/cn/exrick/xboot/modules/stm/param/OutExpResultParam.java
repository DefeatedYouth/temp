package cn.exrick.xboot.modules.stm.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/24
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutExpResultParam {
    @ApiModelProperty(value = "器具ID")
    private  String applianceId;
    @ApiModelProperty(value = "试验现象")
    private  String reason;
    @ApiModelProperty(value = "试验结果 0：合格 1：不合格")
    private  Integer result;
    @ApiModelProperty(value = "试验结果串")
    private  ResultJson resultJson;
    @ApiModelProperty(value = "办理人id")
    private  String applyPeople;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultJson{

        @ApiModelProperty(value = "试验时间")
        private String testTime;
        @ApiModelProperty(value = "温度")
        private String temperature;
        @ApiModelProperty(value = "湿度")
        private String humidity;
        @ApiModelProperty(value = "试验人")
        private String name;
        @ApiModelProperty(value = "拉力")
        private String pull;
        @ApiModelProperty(value = "启动电压")
        private String startVoltage;
        @ApiModelProperty(value = "明显指示")
        private String indicate;
        @ApiModelProperty(value = "长度")
        private String length;
        @ApiModelProperty(value = "泄露电流（左）-绝缘手套和绝缘靴")
        private String reveal;
        @ApiModelProperty(value = "泄露电流（右）")
        private String reveal1;
        @ApiModelProperty(value = "时间")
        private String time;
        @ApiModelProperty(value = "工频耐压")
        private String withstand;
        @ApiModelProperty(value = "现象")
        private String reason;
        @ApiModelProperty(value = "试验结果 0：合格 1：不合格")
        private String result;
        @ApiModelProperty(value = "接地线长度(相线长)")
        private String lengthG;
        @ApiModelProperty(value = "接地线长度（线线长）")
        private String lengthX;
        @ApiModelProperty(value = "（an电阻值） 当前参数个数最多支持5相式")
        private String an;
        private String bn;
        private String cn;
        private String en;
        private String ab;
        private String bc;
        private String ca;
        private String ad;
        private String bd;
        private String cd;
        private String ae;
        private String be;
        private String ce;
        private String de;

    }
}
