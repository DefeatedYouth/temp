package com.sgcc.bd.overallview.businessapi.oauth;

import com.sgcc.bd.overallview.businessapi.ApiRequest;

public class AccessTokenRequest extends ApiRequest<AccessTokenResponse> {

    public AccessTokenRequest(){
        super.apiCode="NA-B-2010-RE-00001";
        super.apiUrl="/psr-auth/oauth/accessToken";
        super.apiName="获取服务鉴权access_token";
    }


    //应用id
    private String clientId;
    //应用key
    private String clientSecret;
    //授权方式（目前只支持credentials授权码方式）
    private String grantType="credentials";
}
