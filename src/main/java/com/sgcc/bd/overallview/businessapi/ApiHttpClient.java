package com.sgcc.bd.overallview.businessapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class ApiHttpClient {
    //网关
    private String getway="http://20.132.145.55:30002";
    //应用ID
    private String appId="";
    //应用秘钥
    private String appSecret="";

    //加密秘钥
    private String refresh_token;
    //过期时间
    private Integer expires_in;
    //生成的jwt
    private String access_token="";


    private ApiHttpClient instance;

    public ApiHttpClient getInstance(){
        if(this.instance==null&&access_token.equals("")){
            JSONObject jsonReq=new JSONObject();
            jsonReq.put("client_id",this.appId);
            jsonReq.put("client_secret",this.appSecret);
            jsonReq.put("grant_type","credentials");
            String  strResJson=HttpClient.doPost(this.getway+"/psr-auth/oauth/accessToken",JSON.toJSONString(jsonReq),this.access_token);
            JSONObject jsonRes=JSON.parseObject(strResJson);
            this.expires_in=Integer.parseInt(jsonRes.get("expires_in").toString());
            this.refresh_token=jsonRes.get("refresh_token").toString();
            this.access_token=jsonRes.get("access_token").toString();
        }
        //判断token是否过期

        return this.instance;
    }
    private <T extends ApiResponse> T Execute(ApiRequest<T> request){
        T rsp = null;
        try {
            String httpUrl=this.getway+request.getApiUrl();
            String strResJson="";
            JSONObject jsonRequest=(JSONObject)JSON.toJSON(request);
            jsonRequest.remove("t");
            jsonRequest.remove("method");
            jsonRequest.remove("apiUrl");
            jsonRequest.remove("apiCode");
            jsonRequest.remove("apiName");

            Iterator iter = jsonRequest.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if(httpUrl.indexOf("{"+entry.getKey()+"}")>0){
                    httpUrl=httpUrl.replace("{"+entry.getKey()+"}",entry.getValue().toString());
                }
            }
            if(request.getMethod().equals("get")){
                httpUrl+="?";
                Iterator iter1 = jsonRequest.entrySet().iterator();
                while (iter1.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter1.next();
                        httpUrl += entry.getKey().toString() + "=" + entry.getValue().toString() + "&";
                }
                strResJson=HttpClient.doGet(httpUrl,this.access_token);
            }
            else{
                strResJson=HttpClient.doPost(httpUrl,JSON.toJSONString(jsonRequest),this.access_token);
            }
            rsp= (T)JSON.parse(strResJson);
        }
        catch (Exception ex){
            rsp= (T)JSON.parse("{\"status\":\"-9\",\"message\":\""+ex.getMessage()+"\"}");
        }
        return rsp;
    }
}
