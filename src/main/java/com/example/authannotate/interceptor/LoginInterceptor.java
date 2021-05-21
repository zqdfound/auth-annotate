package com.example.authannotate.interceptor;

import com.example.authannotate.auth.Auth;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhuangqingdian
 * @date 2021/5/21
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }else if(((HandlerMethod) handler).getBeanType() == BasicErrorController.class){
            return true;
        }

        Class<?> beanType = ((HandlerMethod) handler).getBeanType();
        Auth beanAuth = beanType.getAnnotation(Auth.class);
        if(beanAuth != null && !beanAuth.mustLogin()){
            return true;
        }

        Method beanMethod = ((HandlerMethod) handler).getMethod();
        Auth methodAuth = beanMethod.getAnnotation(Auth.class);
        if(methodAuth != null && !methodAuth.mustLogin()){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/test/401");
        return false;
    }
}
