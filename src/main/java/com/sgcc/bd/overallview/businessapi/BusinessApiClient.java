package com.sgcc.bd.overallview.businessapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

public class BusinessApiClient {
    //网关
    //开发环境：pms.pms30dev.com.cn
    private static String getway="http://dwzyzt.cloudjs.dev.com.cn";
    //应用ID
    private static String appId="";
    //应用秘钥
    private static String appSecret="";

    //加密秘钥
    private static String refresh_token;
    //过期时间
    private static Integer expires_in;
    //生成的jwt
    private static String access_token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDAwMDAwMDUwOTE5NiIsImlhdCI6MTYyNjE2ODkwNSwic3ViIjoid3doX3BtcyIsImF1ZCI6IuWQtOaWh-m5pCIsImV4cCI6MTYyNjI1NTMwNX0.ZwiTkVXBM952MlBc4HFw0wwNfOj-KBKs_JC9zjPy9CE";


    private static BusinessApiClient instance;

    public static BusinessApiClient getInstance(){

        instance=new BusinessApiClient();
        if(instance==null||access_token.equals("")){
            JSONObject jsonReq=new JSONObject();
            jsonReq.put("client_id",appId);
            jsonReq.put("client_secret",appSecret);
            jsonReq.put("grant_type","credentials");
            String  strResJson=HttpClient.doPost(getway+"/psr-auth/oauth/accessToken",JSON.toJSONString(jsonReq),access_token);
            JSONObject jsonRes=JSON.parseObject(strResJson);
            expires_in=Integer.parseInt(jsonRes.get("expires_in").toString());
            refresh_token=jsonRes.get("refresh_token").toString();
            access_token=jsonRes.get("access_token").toString();
        }
        //判断token是否过期

        return instance;
    }


    public <T extends ApiResponse> T Execute(ApiRequest<T> request){
        T rsp=null;
        try {
            String httpUrl=getway+request.getApiUrl();
            String strResJson="";
            JSONObject jsonRequest=(JSONObject)JSON.toJSON(request);
            jsonRequest.remove("method");
            jsonRequest.remove("apiUrl");
            jsonRequest.remove("apiCode");
            jsonRequest.remove("apiName");
            jsonRequest.remove("apiDescribe");

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
                strResJson=HttpClient.doGet(httpUrl,access_token);
            }
            else{
                strResJson=HttpClient.doPost(httpUrl,JSON.toJSONString(jsonRequest),access_token);
            }
            System.out.println(JSON.toJSONString("请求："+jsonRequest));
            System.out.println(JSON.toJSONString("返回："+strResJson));
            rsp= (T)JSON.parseObject(strResJson, request.responseClass());
            rsp.setJsonContent(strResJson);
        }
        catch (Exception ex){
            rsp=(T)JSON.parseObject("{\"message\":\""+ex.getMessage()+"\",\"status\":\"-9\",\"jsonContent\":\"\"}",request.responseClass());
        }
        return rsp;
    }
}
