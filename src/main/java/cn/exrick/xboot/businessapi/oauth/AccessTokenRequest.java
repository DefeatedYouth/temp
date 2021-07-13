package cn.exrick.xboot.businessapi.oauth;

import cn.exrick.xboot.businessapi.ApiRequest;

public class AccessTokenRequest extends ApiRequest<AccessTokenResponse> {

    public AccessTokenRequest(){
        super.apiCode="NA-B-2010-RE-00001";
        super.apiUrl="/psr-auth/oauth/accessToken";
        super.apiName="获取服务鉴权access_token";
    }


    //应用id
    private String client_id;
    //应用key
    private String client_secret;
    //授权方式（目前只支持credentials授权码方式）
    private String grant_type="credentials";
}
