package com.sgcc.bd.overallview.modules.stm.controller;


import com.sgcc.bd.overallview.common.utils.RSAUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;


@Slf4j
@RestController
@Api(tags = "工具")
@RequestMapping("/stm/api/tool")
public class ToolController {

    private static String publicKeyStr="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMDsGkxzH1mzSKcyQ+Lc5+BlsSiiADZvkKD7mImBrt/FoJx6ErHrpXYzL9z2P81oqwisnzCgfLAfOcb/57r+2wcCAwEAAQ==";

    @RequestMapping(value = "/getRsa",method = RequestMethod.GET)
    @ApiOperation(value = "getRsa")
    public Result<Object> getUserInfo(@RequestParam(value = "message")String message) {
        String rasMessageStr="";
        //=================客户端密码=================
        //hello, i am infi, good night!加密
//        String message = "hello, i am infi, good night!";
        //将Base64编码后的公钥转换成PublicKey对象
        try {
            PublicKey publicKey = RSAUtil.string2PublicKey(publicKeyStr);
            //用公钥加密
            byte[] publicEncrypt = RSAUtil.publicEncrypt(message.getBytes(), publicKey);
            //加密后的内容Base64编码
            rasMessageStr = RSAUtil.byte2Base64(publicEncrypt);
        }
        catch (Exception ex){
            return ResultUtil.error(ex.getMessage());
        }
        System.out.println("公钥加密并Base64编码的结果：" + rasMessageStr);
        return ResultUtil.data(rasMessageStr);
    }



}
