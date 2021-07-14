package com.sgcc.bd.overallview.modules.stm.controller;

import com.sgcc.bd.overallview.businessapi.BusinessApiClient;
import com.sgcc.bd.overallview.businessapi.environmententer.FindMeteorologyRequest;
import com.sgcc.bd.overallview.businessapi.environmententer.FindMeteorologyResponse;
import com.sgcc.bd.overallview.businessapi.oauth.GetBusinessApplicationRequest;
import com.sgcc.bd.overallview.businessapi.oauth.GetBusinessApplicationResponse;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@Api(tags = "登录")
@RequestMapping("/stm/api/test")
public class TestController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiOperation(value = "test")
    public Result<Object> test(String id){
        log.error("error 级别322");
        log.info("info 级别322");
        log.debug("debug 级别32456912");
        System.out.println("1223222222222");
        return ResultUtil.data("api success");
    }

    @RequestMapping(value = "/businessapitest",method = RequestMethod.GET)
    @ApiOperation(value = "businessapitest")
    public Result<Object> businessapitest(){

        FindMeteorologyRequest request=new FindMeteorologyRequest();
        request.setCity("南京市");
        request.setTime(new Date());
        FindMeteorologyResponse response= BusinessApiClient.getInstance().Execute(request);

        System.out.println(response.getJsonContent());
        return ResultUtil.data(response.getJsonContent());
    }




}
