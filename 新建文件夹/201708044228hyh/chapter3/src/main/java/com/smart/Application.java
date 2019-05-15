package com.smart;

//主类,应用启动类

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //启动注解事务管理
public class Application extends SpringBootServletInitializer { //-1
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override      //-2
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
}
//-1和-2 配置Spring MVC框架
//-1处继承了Spring Boot提供的servlet初始化器，在-2处重写了SpringBootServletInitializer的configure()方法
