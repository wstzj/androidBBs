package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Repository.UserRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseBody<String> createUser(User user) {

        return ResponseBody.success("成功注册");
    }

    @Override
    public ResponseBody<User> getUserInfo(Long id) {
        return null;
    }

    @Override
    public ResponseBody<String> deleteUser(Long id) {
        return null;
    }

    @Override
    public ResponseBody<User> updateUser(User user) {
        return null;
    }
}
