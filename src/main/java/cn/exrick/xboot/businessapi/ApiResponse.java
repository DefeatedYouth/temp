package cn.exrick.xboot.businessapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="业务中台返回体基对象")
public class ApiResponse  implements Serializable{

    @ApiModelProperty(value = "响应状态码")
    private String status;

    @ApiModelProperty(value = "错误信息")
    private String message;


}
