package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    UserService userService;

    @GetMapping("/hello")
    ResponseBody<String> hello(){
        return userService.deleteUser(1L);
    }
    @GetMapping("/hello1")
    ResponseBody<User> hello1(){
        return userService.getUserInfo(1L);
    }
}
