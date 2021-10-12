package com.itheima.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ServiceBootStrap
 * @Description ServiceBootStrap
 * @Date 2021/7/15 15:41
 * @Created by huangwencai
 */
@SpringBootApplication
@RestController
public class Service1BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(Service1BootStrap.class, args);
    }
    //实时获取配置文件的值，变化了也可以获取到
    @Autowired
    ConfigurableApplicationContext configurableApplicationContext;
    //使用@Value注解的话，是无法获取服务端实时变化的值的，其实服务端是通知了的，但是@Value注解无法获取，这个问题就需要使用@ConfigurableApplicationContext配置文件上下文
    @Value("${common.name}")
    private String config1;

    //使用@Value注解，获取不到实时更新的值
    @GetMapping(value = "/configs")
    public  String getConfigs(){
        return config1;
    }

    //使用ConfigurableApplicationContext配置文件上下文可以获取到实时更新的值
    @GetMapping(value = "/configs2")
    public  String getConfigs2(){
        return configurableApplicationContext.getEnvironment().getProperty("common.name");
    }

    //如果配置文件有多个的情况下获取配置文件内容,group是默认的DEFAULT_GROUP
    @GetMapping(value = "/configs3")
    public  String getConfigs3(){
        return configurableApplicationContext.getEnvironment().getProperty("thisname");
    }

    //如果配置文件有多个的情况下获取配置文件内容,group是自己设置的
    @GetMapping(value = "/configs4")
    public  String getConfigs4(){
        return configurableApplicationContext.getEnvironment().getProperty("hisname");
    }
    /**
     * 配置文件获取属性优先级：
     * 1、系统默认的自带的那种，也就是application名字+。+file-extension最优先。
     * 2、其次：才是扩展的方式，如果同样都是扩展方式的配置文件，那么也要区分优先级， ext-config[n]  n越大优先级越高  和在文档写的先后顺序无关。
     */
}

