package com.nnk.product.repository;

import com.nnk.product.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@FeignClient(name = "user-service")
@RequestMapping("/api/user")
public interface FeignUserRepository {
    @GetMapping("/find/{userName}")
    UserEntity findByUserName(@PathVariable("userName") String userName);
}

