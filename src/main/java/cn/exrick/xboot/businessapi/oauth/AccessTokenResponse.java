package cn.exrick.xboot.businessapi.oauth;

import cn.exrick.xboot.businessapi.ApiResponse;

public class AccessTokenResponse extends ApiResponse {

    //加密秘钥
    private String refresh_token;
    //过期时间
    private Integer expires_in;
    //生成的jwt
    private String access_token;
}
