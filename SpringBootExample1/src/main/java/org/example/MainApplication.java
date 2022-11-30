package org.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication //微服务启动
@EnableAsync //异步操作
@ServletComponentScan //WebFilter过滤器
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);
//        context.publishEvent(new MyApplicationEvent("想涨工资"));

    }
}