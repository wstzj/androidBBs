package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    //创建User
    ResponseBody<String> createUser(User user);

    //获取User信息
    ResponseBody<User> getUserInfo(Long id);

    //删除User
    ResponseBody<String> deleteUser(Long id);

    //更新User信息
    ResponseBody<User> updateUser(User user);

}
