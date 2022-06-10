package com.example.androidbbs.Controller;

import com.example.androidbbs.Annotation.Role;
import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Repository.UserRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import com.example.androidbbs.Util.PasswordUtil;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/register")
    public ResponseBody<String> register(@RequestBody Map<String,String> requestBody, User user){
        String account = requestBody.get("account");
        if (userRepository.existsUserByAccount(account)){
            return ResponseBody.failMsg("已存在该账号");
        }
        String email = requestBody.get("email");
        if (userRepository.existsUserByEmail(email)){
            return ResponseBody.failMsg("已存在该邮箱");
        }
        String password = requestBody.get("password");
        password = PasswordUtil.encode(password);
        user.setAccount(account);
        user.setEmail(email);
        user.setPassword(password);
        user.setAvatar("");
        user.setIntroduction("");

        return userService.createUser(user);
    }

    @RequestMapping("/login")
    public ResponseBody<String> login(@RequestBody Map<String,String> requestBody, User user){

        try {
            String account  = requestBody.get("account");
            User findUser = userRepository.findUserByAccount(account);
            if(findUser == null){
                throw new NullPointerException();
            }
            String password = requestBody.get("password");
            if(PasswordUtil.matchCode(password,findUser.getPassword())){
                return ResponseBody.success("成功登录");
            }else {
                return ResponseBody.failMsg("密码错误");
            }
        }catch (NullPointerException e){
            return ResponseBody.failMsg("账号有误");
        }
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
