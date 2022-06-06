package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    /**
     * 查找某一User的所有Role
     * userId:Long
     */
    List<UserRole> findUserRolesByUserId(Long userId);

    /**
     * 查找某一Role的所有User
     * roleId:Long
     */
    List<UserRole> findUserRolesByRoleId(Long roleId);

    /**
     * 删除User所有Role
     * userId:Long
     */
    boolean deleteUserRolesByUserId(Long userId);

    /**
     * 删除User指定Role
     * userId:Long
     * roleId:Long
     */
    boolean deleteUserRoleByUserIdAndRoleId(Long userId, Long roleId);

    /**
     * 查找User是否拥有Role
     * userId:Long
     * roleId:Long
     */
    boolean existsUserRoleByUserIdAndRoleId(Long userId, Long roleId);

}
