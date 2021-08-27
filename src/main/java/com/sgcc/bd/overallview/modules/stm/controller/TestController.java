package com.sgcc.bd.overallview.modules.stm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sgcc.bd.overallview.businessapi.ApiResponse;
import com.sgcc.bd.overallview.businessapi.BusinessApiClient;
import com.sgcc.bd.overallview.businessapi.CommonData;
import com.sgcc.bd.overallview.businessapi.environmententer.*;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbBook;
import com.sgcc.bd.overallview.modules.shebei.query.SbBookQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    //天气查询接口
    @RequestMapping(value = "/businessapitest",method = RequestMethod.GET)
    @ApiOperation(value = "businessapitest")
    public Result<Object> businessapitest(){

        FindMeteorologyRequest request=new FindMeteorologyRequest();
        request.setCity("南京市");
        request.setTime(new Date());
        FindMeteorologyResponse response= BusinessApiClient.getInstance().Execute(request);

        return ResultUtil.data(response);
    }

    //电压等级查询接口
    @RequestMapping(value = "/eleLevel",method = RequestMethod.POST)
    @ApiOperation(value = "eleLevel")
    public Result<Object> eleLevel(){

        EleLevelRequest request=new EleLevelRequest();
        request.setTypeCode("010401");
        EleLevelResponse response= BusinessApiClient.getInstance().Execute(request);

        return ResultUtil.data(response);
    }

    //工作票查询接口
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

    //资产通用查询
    @RequestMapping(value = "/assetGeneralQuery",method = RequestMethod.POST)
    @ApiOperation(value = "assetGeneralQuery")
    public Result<Object> assetGeneralQuery(){
        AssetGeneralQueryRequest assetGeneralQueryRequest = new AssetGeneralQueryRequest();
        assetGeneralQueryRequest.setAssetType("astLvZone");
        String apiUrl = assetGeneralQueryRequest.getApiUrl();
        assetGeneralQueryRequest.setAssetType(apiUrl.replace("{assetType}", assetGeneralQueryRequest.getAssetType()));
        CommonData commonData = new CommonData();
        AssetGeneralQueryRequest.AssetGeneralQueryData c = new AssetGeneralQueryRequest.AssetGeneralQueryData();
        c.setId("6975c8234b8a10f363766975c701766975c8110022");
        commonData.setCurrent(1);
        commonData.setFields("");
        CommonData.RequestData requestData = new CommonData.RequestData();
        requestData.setCompare("=");
        requestData.setFieldName("psrId");
        requestData.setFieldValue("6975c8234b8a10f363766975c701766975c8110022");
        commonData.setFilters(requestData);
        commonData.setOrderBy("");
        commonData.setPage(1);
        commonData.setPerpage(10);
        commonData.setSize(10);
        c.setCommonData(commonData);
        assetGeneralQueryRequest.setData(c);
        AssetGeneralQueryResponse response =  BusinessApiClient.getInstance().Execute(assetGeneralQueryRequest);
        return ResultUtil.data(response);
    }

/*    public static void main(String[] args) {
        String s = "/ast-center/astQueryServices/{assetType}";
        String ss = "abc";
        String replace = s.replace("{assetType}", ss);
        System.out.println(replace);
    }*/

 /*   //缺陷记录查询服务
    @RequestMapping(value = "/defectRecord",method = RequestMethod.POST)
    @ApiOperation(value = "defectRecord")
    public   Result<Object> defectRecord(){

        DefectFindRequest defectFindRequest = new DefectFindRequest();



    }*/
    //设备台账查询  变压器
    @RequestMapping(value = "/assetGeneralQuery",method = RequestMethod.POST)
    @ApiOperation(value = "assetGeneralQuery")
    public Result<Page<SbBook>> EquipmentLedgerQuery(PageVo pageVo, SbBookQuery query){
        TransformerRequest transformerRequest = new TransformerRequest();
        transformerRequest.setProfessionalKind("1");
        transformerRequest.setPsrType("0301");
        CommonData commonData = new CommonData();
        commonData.setCurrent(pageVo.getPage());
        commonData.setOrderBy("psrId desc");
        commonData.setSize(pageVo.getPageSize());
        TransformerResponse execute = BusinessApiClient.getInstance().Execute(transformerRequest);
        TransformerResponse.TransformerData transformerData = execute.getResult().get("0301Z");
        List<TransformerResponse.TransformerData.Record> records = transformerData.getRecords();
        List<SbBook> list = new ArrayList<>();
        records.forEach(record -> {
            SbBook sbBook = new SbBook();
            sbBook.setResourcesId(record.getResourceData().getPsrId());
            sbBook.setDeviceName(record.getResourceData().getName());
            sbBook.setRegion(record.getResourceData().getCity());
            sbBook.setMaintenanceUnit(record.getResourceData().getMaintOrg());
            sbBook.setMaintenanceTeam(record.getResourceData().getMaintGroup());
            sbBook.setSiteName(record.getResourceData().getStation());
            sbBook.setVoltageLevel(record.getResourceData().getVoltageLevel());
            sbBook.setManufacturer(record.getAssects().getManufacturer());
            sbBook.setEquipmentModel(record.getAssects().getModel());
            sbBook.setLatelyUseTime(record.getAssects().getOperateDate());
        });
        Page page = PageUtil.initMpPage(pageVo);
        page.setRecords(list);
        return ResultUtil.data(page);
    }



    //生产厂家查询
/*
    @RequestMapping(value = "/assetGeneralQuery",method = RequestMethod.POST)
    @ApiOperation(value = "assetGeneralQuery")
    public Result<Object> EquipmentLedgerQuery(){

    }
*/


}
