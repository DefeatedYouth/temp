package cn.exrick.xboot.modules.stm.controller;

import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}
