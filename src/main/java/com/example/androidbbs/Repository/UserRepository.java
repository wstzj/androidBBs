package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //通过Account查找User
    boolean existsUserByAccount(String account);

    //通过Email查找User
    boolean existsUserByEmail(String email);

    //通过Account查找User
    User findUserByAccount(String account);

    //通过Id查找User
    User findUserById(Long id);

}
