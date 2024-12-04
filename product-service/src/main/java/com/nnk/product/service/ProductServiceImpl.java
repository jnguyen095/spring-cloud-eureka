package com.nnk.product.service;

import com.nnk.product.entity.UserEntity;
import com.nnk.product.repository.FeignUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private FeignUserRepository userRepository;
    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
