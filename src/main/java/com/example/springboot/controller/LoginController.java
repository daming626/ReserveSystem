package com.example.springboot.controller;

import com.example.springboot.bean.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("login.do")
    public String login(String username, String password, HttpSession session, Model model) {
        int flag = 0;
        switch (username.substring(username.length() - 1)) {
            case "#"://若用户名结尾为#,则将默认用户以管理员身份登录
                flag = 1;
                username = username.substring(0, username.length() - 1);
                break;
            default:
                flag = 0;
        }
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            user = userService.getUserById(user.getUserid());//把用户的菜单取到
            session.setAttribute("user", user);
            if (flag == 0) {
                session.setAttribute("userTreeList", user.getRoleList().get(0).getTreeList());
            } else if (flag == 1 && user.getRoleList().size()>1) {//若用户拥有多个权限，则以管理员权限运行
                session.setAttribute("userTreeList", user.getRoleList().get(1).getTreeList());
                session.setAttribute("role","r1001");
            } else if (flag == 1 && user.getRoleList().size()==1 && !user.getRoleList().get(0).getRoleId().equals("r1000")) {//若用户只有一个权限，且角色不为学生，就直接以管理员身份登录
                session.setAttribute("userTreeList", user.getRoleList().get(0).getTreeList());
            } else {//用户无管理员权限
                model.addAttribute("message","您没有管理员权限");
                return "login";
            }
            return "redirect:/main.html";
        } else {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return "login";
        }
    }

    @GetMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login.html";
    }

    @GetMapping("login.html")
    public String login(String message,Model model){
        if (message!=null){
            model.addAttribute("message","没有权限,请先登录");
            return "login";
        }
        return "login";
    }

    @GetMapping("instructions.do")
    public String getInstructions(String message,Model model){
        return "instructions";
    }
}
