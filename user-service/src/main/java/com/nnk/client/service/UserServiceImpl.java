package com.nnk.client.service;

import com.nnk.client.entity.UserEntity;
import com.nnk.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>)userRepository.findAll();
    }

    @Override
    public UserEntity findByUserName(String name) {
        return userRepository.findByUserName(name);
    }
}
