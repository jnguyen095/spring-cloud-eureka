package com.nnk.client.controller;

import com.netflix.discovery.converters.Auto;
import com.nnk.client.entity.UserEntity;
import com.nnk.client.repository.UserRepository;
import com.nnk.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
