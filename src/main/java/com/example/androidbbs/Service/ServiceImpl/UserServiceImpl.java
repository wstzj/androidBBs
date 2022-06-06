package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Repository.UserRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseBody<String> createUser(User user) {
        userRepository.save(user);
        return ResponseBody.success("成功注册");
    }

    @Override
    public ResponseBody<User> getUserInfo(Long id) {
        try {
            User user = userRepository.findUserById(id);
            if (user == null){
                throw new NullPointerException();
            }
            return ResponseBody.success(user);
        }catch (NullPointerException e){
            return ResponseBody.failMsg("未查找到用户");
        }
    }

    @Override
    public ResponseBody<String> deleteUser(Long id) {
        try {
            User user = userRepository.findUserById(id);
            if (user == null){
                throw new NullPointerException();
            }
            userRepository.delete(user);
            return ResponseBody.success("成功删除");
        }catch (NullPointerException e){
            return ResponseBody.failMsg("未查找到用户");
        }

    }

    @Override
    public ResponseBody<User> updateUser(User user) {
        userRepository.save(user);
        return ResponseBody.success(user);
    }

    @Override
    public ResponseBody<List<User>> findAllUser() {
        try {
            List<User> userList = userRepository.findAll();
            if (userList.isEmpty()){
                throw new NullPointerException();
            }
            return ResponseBody.success(userList);
        }catch (NullPointerException e){
            return ResponseBody.failMsg("数据库中没有用户");
        }
    }
}
