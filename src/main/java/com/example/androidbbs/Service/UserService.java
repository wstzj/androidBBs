package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseBody<String> createUser(User user);

    ResponseBody<User> getUserInfo(Long id);

    ResponseBody<String> deleteUser(Long id);

    ResponseBody<User> updateUser(User user);

}
