package com.test.cn.controller;

import com.testb.cn.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller1 {

    @Autowired
    private BService bService;
    @GetMapping("/hello")
    public String sayHello() {
        return bService.sayHello();
    }

}
