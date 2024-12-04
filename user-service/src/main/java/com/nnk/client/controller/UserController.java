package com.nnk.client.controller;

import com.nnk.client.entity.UserEntity;
import com.nnk.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public List<UserEntity> home() {
        List<UserEntity> entityList = userService.findAll();
        return entityList;//"Client service " + entityList.size();
    }

    @GetMapping("/find/{userName}")
    public UserEntity findByUserName(@PathVariable(name = "userName")String userName) {
        return userService.findByUserName(userName);
    }

}
