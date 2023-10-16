package com.test.cn;

import com.test.cn.config.ModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ModuleConfig.class)
public class AApplication {
    public static void main(String[] args) {
        SpringApplication.run(AApplication.class, args);
    }
}
