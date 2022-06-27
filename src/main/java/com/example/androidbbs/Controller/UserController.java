package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Repository.UserRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import com.example.androidbbs.Util.CodeUtil;
import com.example.androidbbs.Util.EmailUtil;
import com.example.androidbbs.Util.JwtUtil;
import com.example.androidbbs.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/register")
    public ResponseBody<String> register(@RequestBody Map<String, String> requestBody, User user) {
        String account = requestBody.get("account");
        if (userRepository.existsUserByAccount(account)) {
            return ResponseBody.failMsg("已存在该账号");
        }
        String email = requestBody.get("email");
        if (userRepository.existsUserByEmail(email)) {
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
            String account = requestBody.get("account");
            User findUser = userRepository.findUserByAccount(account);
            if (findUser == null) {
                throw new NullPointerException();
            }
            String password = requestBody.get("password");
            if (PasswordUtil.matchCode(password, findUser.getPassword())) {
                String jwt = JwtUtil.generateToken(account, 60 * 60 * 24);
                return ResponseBody.success(jwt);
            } else {
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
    public ResponseBody<String> emailVerify(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        if (email == null || email.equals("")) {
            return ResponseBody.failMsg("邮箱不能为空");
        }
        if (userRepository.existsUserByEmail(email)) {
            return ResponseBody.failMsg("邮箱已经注册过了");
        }
        String code = CodeUtil.generateVerCode();
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(email, code, 60 * 60 * 3, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
        String message = "尊敬的用户,您好:\n"
                + "\n本次请求的邮件验证码为:" + code + ",本验证码5分钟内有效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）";    //设置邮件正文
        EmailUtil.sendMail(email, message, "请查看你的验证码");
        return ResponseBody.success("发送成功");
    }

    @RequestMapping("/getUserInfo")
    public ResponseBody<User> getUserInfo(@RequestBody Map<String, String> requestBody, @RequestHeader("Authorization") String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            final String authToken = authorization.substring("Bearer ".length());
            String account = JwtUtil.parseToken(authToken, "_secret");
            try {
                User findUser = userRepository.findUserByAccount(account);
                if (findUser != null) {
                    return ResponseBody.success(findUser);
                } else {
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                return ResponseBody.failMsg("token有误");
            }
        } else {
            return ResponseBody.success(null);
        }
    }

    @RequestMapping("/getAllUserInfo")
    public ResponseBody<List<User>> getAllUserInfo(@RequestBody Map<String, String> requestBody, @RequestHeader("Authorization") String authorization) {
        return userService.getAllUser();
    }
}
