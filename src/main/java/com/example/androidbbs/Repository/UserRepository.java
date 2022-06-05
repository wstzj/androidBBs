package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByAccount(String account);
    boolean existsUserByEmail(String email);
    User findUserByAccountAndPassword(String account,String password);
    User findUserById(Long id);
}
