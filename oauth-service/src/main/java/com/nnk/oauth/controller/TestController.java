package com.nnk.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/rest")
    public String publicMethod(){
        return "Public method, every one can see, no need to logon.";
    }

    @RequestMapping("/logon")
    public String logonMethod(){
        return "When logon then user can see this!";
    }

    @RequestMapping("/user")
    public String userRoleMethod(){
        return "Only user has role USER can see this!";
    }

    @RequestMapping("/admin")
    public String adminRoleMethod(){
        return "Only user has role ADMIN can see this!";
    }
}
