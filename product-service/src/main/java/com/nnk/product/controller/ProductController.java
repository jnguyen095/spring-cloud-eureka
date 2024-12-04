package com.nnk.product.controller;

import com.nnk.product.entity.UserEntity;
import com.nnk.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/")
    public String home() {
        return "Product service";
    }

    @GetMapping("/users/{userName}")
    public UserEntity users(@PathVariable(name = "userName") String userName) {
        return productService.findByUserName(userName);
    }
}
