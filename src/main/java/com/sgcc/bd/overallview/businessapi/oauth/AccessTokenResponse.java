package com.sgcc.bd.overallview.businessapi.oauth;

import com.sgcc.bd.overallview.businessapi.ApiResponse;

public class AccessTokenResponse extends ApiResponse {

    //加密秘钥
    private String refreshToken;
    //过期时间
    private Integer expiresIn;
    //生成的jwt
    private String accessToken;
}
