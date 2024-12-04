package com.nnk.product.service;

import com.nnk.product.entity.UserEntity;
import com.nnk.product.repository.FeignUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private FeignUserRepository productRepository;
    @Override
    public UserEntity findByUserName(String userName) {
        return productRepository.findByUserName(userName);
    }
}
