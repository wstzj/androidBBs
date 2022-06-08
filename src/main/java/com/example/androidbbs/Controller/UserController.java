package com.example.androidbbs.Controller;

import com.example.androidbbs.Annotation.Role;
import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/register")
    public ResponseBody<String> register(@RequestBody Map<String,String> requestBody, User user){
        return userService.createUser(user);
    }

    @RequestMapping("/login")
    public ResponseBody<String> login(@RequestBody Map<String,String> requestBody, User user){
        return userService.createUser(user);
    }

    @RequestMapping("/updateUser")
    public ResponseBody<User> updateUser(@RequestBody Map<String,String> requestBody, User user){
        return userService.updateUser(user);
    }

    @RequestMapping("/logout")
    public ResponseBody<String> logout(@RequestBody Map<String,String> requestBody, User user){
        return ResponseBody.success("成功登出");
    }

    @RequestMapping("/emailVerify")
    public ResponseBody<String> emailVerify(@RequestBody Map<String,String> requestBody, User user){
        return ResponseBody.success("成功发送");
    }

    @RequestMapping("/getUserInfo")
    public ResponseBody<User> getUserInfo(@RequestBody Map<String,String> requestBody, User user){
        return userService.getUserInfo(1L);
    }

    @RequestMapping("/getAllUserInfo")
    public ResponseBody<List<User>> getAllUserInfo(@RequestBody Map<String,String> requestBody, User user){
        return userService.getAllUser();
    }
}
