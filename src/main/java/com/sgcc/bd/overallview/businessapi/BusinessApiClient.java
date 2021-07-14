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
    private static String getway="http://pms.pms30dev.com.cn";
    //应用ID
    private static String appId="";
    //应用秘钥
    private static String appSecret="";

    //加密秘钥
    private static String refresh_token;
    //过期时间
    private static Integer expires_in;
    //生成的jwt
    private static String access_token="eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJkYXNoYm9hcmQtcmVhZC11c2VyLXRva2VuLXQ2OHo2Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImRhc2hib2FyZC1yZWFkLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiJlODA0NjBkNy05ZTg0LTExZWItOTM2OC0wMDE2M2UwMTAzN2YiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06ZGFzaGJvYXJkLXJlYWQtdXNlciJ9.B5fxdVy0ZYm_8GLJCG74mhO9x4vnDDOC70L_TwZPtUaLeioeb1dTtgSFUAndtgtnJLyV8WjNOse-jH0Bj-5eScbNTLpFjBNTgDBcQi3UOKBaXOHfWnqplHS3WiZkkC4fnSyYhCkw-gRKuB1_n2oOk85GZnF5d5Nns6G0iXH4lNBihuD5K2O19Gbk2RwPZfGNhfR_dWc9SL-Dp_4OCC_hCFvlRbUmQ1bxvfzzZheKOGClLQVJOTHD0A8jOKya-mAyCDU1LSJpi-9HwbKodWfEiXOPNocFczDRNlEQ9lZQytneXGN2NmzKSupr3oFagUcfKYkAsNHJfeMhirj6NPNLNg";


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
