package com.testb.cn.service;

import org.springframework.stereotype.Service;

@Service
public class BServiceImpl implements BService{
    @Override
    public String sayHello() {
        return "hello spring, from B";
    }
}
