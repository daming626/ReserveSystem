package com.example.springboot.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.springboot.bean.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("viewAccount.do")
//    @ResponseBody
    public String viewUser(Model model) {
        System.out.println("lllll");
        model.addAttribute("users", userService.viewUser());
        System.out.println("ssss");
        return "viewAccount";
//        return userService.viewUser();
    }

    @GetMapping("alterPassword.do")
    public  String AlterPassword(Model model){
        model.addAttribute("users",userService.viewUser());
        return "AlterPassword";
    }

    @PostMapping("update")
    public String updateUser(User user, HttpSession session){
        System.out.printf("LLLLLLLLLLLLLLL");
        System.out.println(user.getUserid());
        System.out.println(user.getRealname());
        System.out.println(user.getSex());
        userService.updateUser(user);
        User user1 = userService.getUserById(user.getUserid());
        System.out.println(user1.getUsername());
        session.setAttribute("user",user1);
        System.out.println("修改的用户为 ： " + user.getUserid());
        return "viewAccount";
    }

    @PostMapping("alterpw")
    public String alterUser(User user,HttpSession session){
        System.out.println(user.getUserid());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userService.alterUser(user);
        user = userService.getUserById(user.getUserid());
        session.setAttribute("user",user);
        System.out.println("修改的用户为 ： " + user.getUserid());
        return "passend";
    }

    @GetMapping("deleteUser.do")
    public String deleteUser(String userId) {
        userService.deleteUser(userId);
        return "redirect:viewUser";
    }

    @PostMapping("checkUserId.do")
    public void checkUserId(String userId, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new Gson();
        PrintWriter out = null;
        String id = null;
        try {
            out = response.getWriter();
            id = userService.getUserById(userId).getUserid();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            id = "null";
            System.out.println("用户不存在");
        }
        out.write(gson.toJson(id));
        out.flush();
        out.close();
    }


}
