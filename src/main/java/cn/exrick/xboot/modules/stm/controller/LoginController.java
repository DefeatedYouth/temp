package cn.exrick.xboot.modules.stm.controller;

import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.stm.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "登录")
@RequestMapping("/stm/api/login")
public class LoginController {



    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ApiOperation(value = "getUserInfo")
    public Result<Object> getUserInfo(UserVo userVo)
    {

        return ResultUtil.data(null);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "login")
    public Result<Object> login(@RequestBody UserVo userVo)
    {


        return ResultUtil.data(null);
    }

}
