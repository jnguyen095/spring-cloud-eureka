package com.nnk.product.service;

import com.nnk.product.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


public interface IProductService {
    public UserEntity findByUserName(String userName);
}
