package com.nnk.client.service;

import com.nnk.client.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<UserEntity> findAll();
    UserEntity findByUserName(String name);
}
