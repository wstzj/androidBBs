package com.example.androidbbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AndroidBBsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidBBsApplication.class, args);
    }

}
