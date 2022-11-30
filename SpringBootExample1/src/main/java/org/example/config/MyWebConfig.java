package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Bean
    public MyInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // getMyInterceptor()这种注册方式可以在拦截器里注入bean
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
        // 这种注册方式由于是自己new出来的，所以在拦截器里注册的bean都为null
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
