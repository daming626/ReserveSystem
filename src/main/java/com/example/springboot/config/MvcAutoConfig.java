package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcAutoConfig implements WebMvcConfigurer {
    /*
    * MVC拓展配置类
    * */


    //自定义视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("main");//将所有/main.html的请求，表现至main视图下
    }


    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")//被拦截的请求，/**表示所有请求
                .excludePathPatterns("/user/login.html", "/", "/user/login.do", "/css/**", "/img/**", "/js/**");//予以放行的请求、页面、静态资源
    }
}
