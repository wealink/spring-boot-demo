package com.wework.platformservice.controller;

import com.wework.platformservice.service.UserService;
import com.wework.platformservice.bean.User;
import com.wework.platformservice.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("通过用户id查询用户")
    @ApiImplicitParam(name = "id",value = "用户id",defaultValue = "1")
    @GetMapping("/user/{id}")
    public Result getUserById(@PathVariable("id")Integer id){
        User user=userService.getUserById(id);
        if (user != null) {
            return Result.success().add("user", user);
        } else {
            return Result.notfound();
        }
    }

    @ApiOperation("查询用户列表")
    @GetMapping("/user")
    public Result getAllUser(){
        List<User> users=userService.getAllUser();
        return Result.success().add("user",users);
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",defaultValue = "tom"),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "152258"),
    })
    @PostMapping("/user")
    public Result addUser(User user){
        userService.addUser(user);
        return Result.success();
    }

    @ApiOperation("更新用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "用户id",defaultValue = "1"),
            @ApiImplicitParam(name = "username",value = "用户名",defaultValue = "tom"),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "152258"),
    })
    @PutMapping("/user")
    public Result updateUser(User user){
        userService.updateUser(user);
        return Result.success();
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id",value = "用户id",defaultValue = "1")
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return Result.success();
    }
}
