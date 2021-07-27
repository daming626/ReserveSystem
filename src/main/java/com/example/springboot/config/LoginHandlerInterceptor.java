package com.example.springboot.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    /*
    * 拦截器
    */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //声明用户对象，从Session中获取
        Object loginUser = request.getSession().getAttribute("user");


        //判读用户是否登录
        if (loginUser == null){//用户对象不存在，说明用户没有登录，不予放行
            request.setAttribute("message","没有权限，请先登录");//向前端发送错误参数
            request.getRequestDispatcher("/user/login.html").forward(request,response);//请求转发回登录页面
            return false;
        }else {//用户对象已存在，予以放行
            return true;
        }


    }
}
