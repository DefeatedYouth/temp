package com.sgcc.bd.overallview.modules.stm.controller;

import com.sgcc.bd.overallview.businessapi.BusinessApiClient;
import com.sgcc.bd.overallview.businessapi.environmententer.*;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
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

        return ResultUtil.data(response);
    }

    @RequestMapping(value = "/eleLevel",method = RequestMethod.POST)
    @ApiOperation(value = "eleLevel")
    public Result<Object> eleLevel(){

        EleLevelRequest request=new EleLevelRequest();
        request.setTypeCode("010401");
        EleLevelResponse response= BusinessApiClient.getInstance().Execute(request);

        return ResultUtil.data(response);
    }

    @RequestMapping(value = "/jobOpTicket",method = RequestMethod.POST)
    @ApiOperation(value = "jobOpTicket")
    public Result<Object> jobOpTicket(){
        JobOpTicketRequest request=new JobOpTicketRequest();
        request.setCurrent(1);
        request.setFields("astId");
        JobOpTicketRequest.RequestData requestData = new JobOpTicketRequest.RequestData();
        requestData.setCompare("=");
        requestData.setFieldName("psrId");
        requestData.setFieldValue("1");
        request.setFilters(requestData);
        request.setOrderBy("astId desc");
        request.setPage(1);
        request.setPerpage(50);
        request.setSize(50);
        JobOpTicketResponse response= BusinessApiClient.getInstance().Execute(request);

        return ResultUtil.data(response);
    }


}
