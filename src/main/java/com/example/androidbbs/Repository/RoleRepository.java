package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleById(Long id);
    Role findRoleByRole(String role);
}
