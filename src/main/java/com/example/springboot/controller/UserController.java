package com.example.springboot.controller;

import com.example.springboot.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
