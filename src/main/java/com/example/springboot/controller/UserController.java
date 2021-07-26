package com.example.springboot.controller;

import com.example.springboot.service.IUserService;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("viewUser.do")
    public String viewUser(Model model) {
        model.addAttribute("users", userService.viewUser());
        return "viewUser";
    }

    @GetMapping("deleteUser.do")
    public String deleteUser(String userId) {
        userService.deleteUser(userId);
        return "redirect:viewUser";
    }

    @PostMapping("login.do")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            user = userService.getUserById(user.getUserId());//把用户的菜单取到
            session.setAttribute("userTreeList", user.getRoleList().get(0).getTreeList());
            return "redirect:/main.html";
        } else {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return "login";
        }
    }

    @GetMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login.html";
    }

    @GetMapping("login.html")
    public String login() {
        return "login";
    }
}
