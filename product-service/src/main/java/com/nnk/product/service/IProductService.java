package com.nnk.product.service;

import com.nnk.product.entity.UserEntity;


public interface IProductService {
    UserEntity findByUserName(String userName);
}
