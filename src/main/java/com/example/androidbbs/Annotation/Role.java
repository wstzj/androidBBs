package com.example.androidbbs.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
    String value() default "user";

    String[] roles() default {};

    String[] mustRoles() default {};
}
