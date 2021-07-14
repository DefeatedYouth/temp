package com.sgcc.bd.overallview.businessapi;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="业务中台返回体基对象")
public class ApiResponse  implements Serializable {
    private static final long serialVersionUID = -6957361951748382519L;


    @ApiModelProperty(value = "响应状态码")
    @JSONField(name="status")
    private String status;

    @ApiModelProperty(value = "错误信息")
    @JSONField(name="message")
    private String message;


    @ApiModelProperty(value = "返回内容")
    @JSONField(name="jsonContent")
    private String jsonContent;

}
