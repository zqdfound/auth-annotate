package com.example.authannotate.auth;

import java.lang.annotation.*;

/**
 * @author zhuangqingdian
 * @date 2021/5/21
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {

    /**
     * 默认需要登录
     * @return
     */
    boolean mustLogin() default true;


}
