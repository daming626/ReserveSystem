package com.example.springboot.controller;

import com.example.springboot.bean.User;
import com.example.springboot.service.IManageService;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;


@Controller
@RequestMapping("manage")
public class ManageController {

    @Autowired
    private IManageService manageService;

    @Autowired
    private IUserService userService;

    private int curPageu = 1;

    private int curPagem = 1;

    private int curPages = 1;

    //查看用户
    @GetMapping("viewUser.do")
    public String viewUser(Model model, String firstPage, String lastPage, String nextPage, String finalPage){


        int pageSize = 8;
        int totalPage = manageService.totalu(pageSize,"r1000");
        if (firstPage != null) {//首页
            curPageu = 1;
        }
        if (lastPage != null) {//上一页
            curPageu --;
        }
        if (nextPage != null) {//下一页
            curPageu ++;
        }
        if (finalPage != null) {//尾页
            curPageu = totalPage;
        }
        if (curPageu < 1) {//确定下界
            curPageu = 1;
        }
        if (curPageu > totalPage) {//确定上界
            if(totalPage==0){curPageu = 1;}
            else {curPageu = totalPage;}
        }

        int startPage = (curPageu-1) * pageSize;

        model.addAttribute("viewUser", manageService.getUserById("r1000",startPage,pageSize));
        model.addAttribute("flag",0);
        return "viewUser";
    }

    @GetMapping("deleteUser.do")
    public String deleteUser(String userId, Model model){
        manageService.deleteManage(userId);
        return "redirect:viewUser.do";
    }

    //查看管理员
    @GetMapping("viewManager.do")
    public String viewManage(Model model, String firstPage, String lastPage, String nextPage, String finalPage){

        int pageSize = 8;
        int totalPage = manageService.totalm(pageSize,"r1001");
        if (firstPage != null) {//首页
            curPagem = 1;
        }
        if (lastPage != null) {//上一页
            curPagem --;
        }
        if (nextPage != null) {//下一页
            curPagem ++;
        }
        if (finalPage != null) {//尾页
            curPagem = totalPage;
        }
        if (curPagem < 1) {//确定下界
            curPagem = 1;
        }
        if (curPagem > totalPage) {//确定上界
            if(totalPage==0){curPagem = 1;}
            else {curPagem = totalPage;}
        }

        int startPage = (curPagem-1) * pageSize;

        model.addAttribute("viewManager", manageService.getManageById("r1001",startPage,pageSize));
        return "viewManager";
    }

    @GetMapping("deleteManage.do")
    public String deleteManage(String userId, Model model){
        manageService.deleteManage(userId);
        return "redirect:viewManager.do";
    }

    @GetMapping("addManager.do")
    public String addManager(){


        return "addManager";
    }

    @PostMapping("insertAdministrator.do")
    public String insertAdministrator(User user){
        System.out.println(user.getUserid());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        manageService.insertAdministrator(user);
        return "redirect:viewUser.do";
    }

    @GetMapping("searchUser.do")
    public String searchUser(String txt,Model model, String firstPage, String lastPage, String nextPage, String finalPage) {

        int pageSize = 8;
        int totalPage = manageService.totals(pageSize, "r1000");
        if (firstPage != null) {//首页
            curPages = 1;
        }
        if (lastPage != null) {//上一页
            curPages--;
        }
        if (nextPage != null) {//下一页
            curPages++;
        }
        if (finalPage != null) {//尾页
            curPages = totalPage;
        }
        if (curPages < 1) {//确定下界
            curPages = 1;
        }
        if (curPages > totalPage) {//确定上界
            if (totalPage == 0) {
                curPages = 1;
            } else {
                curPages = totalPage;
            }
        }

        int startPage = (curPages - 1) * pageSize;

        model.addAttribute("text", txt);
        model.addAttribute("viewUser", manageService.searchUser(txt, "r1000", startPage, pageSize));
        model.addAttribute("flag", 1);
        return "viewUser";

    }

    @GetMapping("insertManagerById.do")
    public String insertManagerById(String userId){

        userService.insertManagerById(userId);
        System.out.println(userId);
        System.out.println("a");

        return "redirect:viewUser.do";
    }
}
