package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Role;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    ResponseBody<String>createRole(Role role);

    ResponseBody<Role>getRoleInfo(Long id);

    ResponseBody<List<Role>>getAllRole();

    ResponseBody<String>deleteRole(Long id);
}
