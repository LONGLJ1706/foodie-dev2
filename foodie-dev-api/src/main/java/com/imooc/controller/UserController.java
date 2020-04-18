package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Api(value = "注册登录",tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/userNameIsExist")
    @ResponseBody
    public IMOOCJSONResult userNameIsExist(@RequestParam String userName){
        //1、判断用户名是否为空
        if(StringUtils.isEmpty(userName)){
            return  IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //2、判断用户名是否已经存在、
        boolean bool=userService.queryUserIsExist(userName);
        if(bool){
            return  IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //3、请求成功，用户名没有重复
       return  IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBo userBo){
        String username=userBo.getUsername();
        String password=userBo.getPassword();
        String confirmpassword=userBo.getConfirmpassword();
        //0、判断账号和密码是否为空
         if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)||StringUtils.isEmpty(confirmpassword)){
             return  IMOOCJSONResult.errorMsg("用户名或者密码不能为空");
         }
        //1、判断用户名是否已经存在
        boolean bool=userService.queryUserIsExist(username);
        if(bool){
            return  IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //2、判断密码长度是否大于6位
        if(username.length()<6){
            return  IMOOCJSONResult.errorMsg("密码长度不能小于6位");
        }
        //3、判断两次密码是否一致
        if(!password.equals(confirmpassword)){
            return  IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        //4、实现注册
        Users users= userService.createUsers(userBo);
        return  IMOOCJSONResult.ok();
    }
}
