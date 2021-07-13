package cn.exrick.xboot.businessapi.oauth;

import cn.exrick.xboot.businessapi.ApiRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="获取业务应用信息Request")
public class GetBusinessApplicationRequest  extends ApiRequest<GetBusinessApplicationResponse> {

    public GetBusinessApplicationRequest(){
        super.apiCode="NA-B-2010-RE-00004";
        super.apiUrl="/yj-pms-authority/auth/getBusinessApplication/{busiCode}/{busiName}";
        super.apiName="获取业务应用信息";
    }

    @ApiModelProperty(value = "业务应用编码")
    private String busiCode;

    @ApiModelProperty(value = "业务应用名称")
    private String busiName;


}
