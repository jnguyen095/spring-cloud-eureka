package com.nnk.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/product")
public class ProductController {
    @RequestMapping("/")
    public String home() {
        return "Product service";
    }
}
