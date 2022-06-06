package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Role;
import com.example.androidbbs.Repository.RoleRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseBody<String> createRole(Role role) {
        roleRepository.save(role);
        return null;
    }

    @Override
    public ResponseBody<Role> getRoleInfo(Long id) {
        try {
            Role role = roleRepository.findRoleById(id);
            if (role == null) {
                throw new NullPointerException();
            }
            return ResponseBody.success(role);
        } catch (NullPointerException e) {
            return ResponseBody.failMsg("没有找到该角色信息");
        }
    }

    @Override
    public ResponseBody<List<Role>> getAllRole() {
        try {
            List<Role> roleList = roleRepository.findAll();
            if (roleList.isEmpty()) {
                throw new NullPointerException();
            }
            return ResponseBody.success(roleList);
        } catch (NullPointerException e) {
            return ResponseBody.failMsg("数据库中没有角色");
        }
    }

    @Override
    public ResponseBody<String> deleteRole(Long id) {
        try {
            Role role = roleRepository.findRoleById(id);
            if (role == null) {
                throw new NullPointerException();
            }
            roleRepository.delete(role);
            return ResponseBody.success("成功删除该角色");
        } catch (NullPointerException e) {
            return ResponseBody.failMsg("没有找到该角色");
        }
    }
}
