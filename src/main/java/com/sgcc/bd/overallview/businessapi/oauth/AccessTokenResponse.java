package com.sgcc.bd.overallview.businessapi.oauth;

import com.sgcc.bd.overallview.businessapi.ApiResponse;

public class AccessTokenResponse extends ApiResponse {

    //加密秘钥
    private String refresh_token;
    //过期时间
    private Integer expires_in;
    //生成的jwt
    private String access_token;
}
