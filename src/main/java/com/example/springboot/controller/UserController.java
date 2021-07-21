package com.example.springboot.controller;

import com.example.springboot.service.IUserService;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("viewUser.do")
    public String viewUser(Model model){
        model.addAttribute("users",userService.viewUser());
        return "viewUser";
    }

    @GetMapping("deleteUser.do")
    public String deleteUser(String userId) {
        userService.deleteUser(userId);
        return "redirect:viewUser";
    }

    @PostMapping("login.do")
    public String login(String username, String password, HttpServletRequest request){
        User user = userService.login(username,password);
        if (user!=null){
            request.setAttribute("user",user);
            user = userService.getUserById(user.getUserId());//把用户的菜单取到
            request.setAttribute("userTreeList", user.getRoleList().get(0).getTreeList());
            return "main";
        }else{
            return "redirect:..//login.html";
        }
    }

    @GetMapping("login.html")
    public String login(){
        return "redirect:../login.html";
    }

}
