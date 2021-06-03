package cn.exrick.xboot.modules.stm.controller;

import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.stm.entity.SrmUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "用户管理")
@RequestMapping("/stm/api/user")
public class UserController {


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    public Result<SrmUser> addUser(@RequestBody SrmUser user){
        return ResultUtil.data(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "编辑用户")
    public Result<SrmUser> updateUser(@RequestBody SrmUser user){
        return ResultUtil.data(user);
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户")
    public Result<SrmUser> delUser(@RequestBody SrmUser user){
        return ResultUtil.data(user);
    }

}
