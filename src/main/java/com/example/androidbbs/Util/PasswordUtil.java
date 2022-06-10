package com.example.androidbbs.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    public static String encode(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
        return  bCryptPasswordEncoder.encode(password);
    }
    public static boolean matchCode(String password,String encodedPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password,encodedPassword);
    }
}
