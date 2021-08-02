package com.example.springboot.controller;

import com.example.springboot.bean.Result;
import com.example.springboot.bean.User;
import com.example.springboot.service.IStudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("/document")
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    private int curPage=1;

    @GetMapping("manualEntry.do")
    public String viewStudent(String firstPage,String lastPage,String nextPage,String finalPage,HttpServletRequest request){//HttpServletRequest request获取客户端请求参数
        int pageSize=8;
        int totalPage = studentService.total(8);
        if (firstPage != null) {//首页
            curPage = 1;
        }
        if (lastPage != null) {//上一页
            curPage--;
        }
        if (nextPage != null) {//下一页
            curPage++;
        }
        if (finalPage != null) {//尾页
            curPage = totalPage;
        }
        if (curPage < 1) {//确定下界
            curPage = 1;
        }
        if (curPage >= totalPage) {//确定上界
            curPage = totalPage;
        }

        int startRow = (curPage-1)*pageSize;//当前页的第一条数据在数据库的位置
        request.setAttribute("users",studentService.viewStudent(startRow,8));
        return "viewStudent";
    }
    @GetMapping("deleteStudent")
    public String deleteStudent(String userid,HttpServletRequest request){
        studentService.deleteStudent(userid);
        request.setAttribute("users",studentService.viewStudent(0,8));
        return "viewStudent";
    }
    @PostMapping("insertStudent")
    public String insertStudent(User user,HttpServletRequest request){
        studentService.insertStudent(user);
        request.setAttribute("users",studentService.viewStudent(1,8));
        return "viewStudent";
    }
//    @PostMapping("insertStudent")
//    public String insertStudent(User user, HttpServletResponse response, HttpServletRequest request) {
//        System.out.println(user.getUserid());
//        Gson gson = new Gson();
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.fillInStackTrace();
//        }
//        try {
//            studentService.insertStudent(user);
//            request.setAttribute("users", studentService.viewStudent(0, 8));
//            Result result = new Result("studentToYes");//根据此标记来显示预约结果
//            out.write(gson.toJson(result));
//        } catch (NullPointerException e) {
//            Result result = new Result("studentToNo");
//            out.write(gson.toJson(result));
//        }
//        return "redirect:manualEntry.do";
//    }

    @PostMapping("updateStudent")
    public String updateStudent(User user,HttpServletRequest request){
        studentService.updateStudent(user);
        request.setAttribute("users",studentService.viewStudent(0,8));
        return "redirect:manualEntry.do";
    }
    @GetMapping ("getStudentbyId")
    public void getStudentbyId(String userid, HttpServletResponse response){
        System.out.println(userid);
        Gson gson = new Gson();
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        try {
            User user=studentService.getStudentbyId(userid);
            System.out.println(user.getUserid());
            Result result = new Result("studentToNo");//根据此标记来显示预约结果
            System.out.println("jieguo");
            out.write(gson.toJson(result));
        } catch (NullPointerException e) {
            Result result = new Result("studentToYes");
            System.out.println("buxing");
            out.write(gson.toJson(result));
        }
        System.out.println("chuanhui");
        out.flush();
        out.close();
    }
}

