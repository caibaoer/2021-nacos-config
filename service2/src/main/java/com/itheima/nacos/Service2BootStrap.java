package com.itheima.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ServiceBootStrap
 * @Description TODO
 * @Date 2021/7/15 15:41
 * @Created by huangwencai
 */
@SpringBootApplication
@RestController
public class Service2BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(Service2BootStrap.class, args);
    }
    @Value("${common.name}")
    private String config1;

    @GetMapping(value = "/configs")
    public  String getConfigs(){
        return config1;
    }
}

