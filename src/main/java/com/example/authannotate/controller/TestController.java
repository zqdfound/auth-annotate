package com.example.authannotate.controller;

import com.example.authannotate.auth.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangqingdian
 * @date 2021/5/21
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/auth")
    @ResponseBody
    @Auth
    public String  test1(){
        return "auth";
    }

    @GetMapping("/auth1")
    @ResponseBody
    @Auth(mustLogin = false)
    public String  test2(){
        return "auth";
    }

    @GetMapping("/401")
    @Auth(mustLogin = false)
    public String  unAuthed(){
        return "/401";
    }

}
