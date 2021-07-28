package com.example.springboot.controller;

import com.example.springboot.bean.User;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/document")
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("manualEntry.do")
    public String viewStudent(HttpServletRequest request){//HttpServletRequest request获取客户端请求参数
        request.setAttribute("users",studentService.viewStudent());
        return "viewStudent";
    }
    @GetMapping("deleteStudent")
    public String deleteStudent(String userid,HttpServletRequest request){
        studentService.deleteStudent(userid);
        request.setAttribute("users",studentService.viewStudent());
        return "viewStudent";
    }
    @PostMapping("insertStudent")
    public String insertStudent(User user,HttpServletRequest request){
        studentService.insertStudent(user);
        request.setAttribute("users",studentService.viewStudent());
        return "viewStudent";
    }
    @GetMapping("insertStudent")
    public String insertStudent(){
        return "insertStudent";
    }

    @PostMapping("updateStudent")
    public String updateStudent(User user,HttpServletRequest request){
        System.out.println("KKKKKKK");
        System.out.println(user.getUserid());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRealname());
        System.out.println(user.getSex());
        System.out.println(user.getTclass());
        System.out.println(user.getGrade());
        System.out.println(user.getContacts());
        studentService.updateStudent(user);
        System.out.println("LLLLLLLLLLLL");
        request.setAttribute("users",studentService.viewStudent());
        return "viewStudent";
    }
    @GetMapping ("getStudentbyId")
    public String updateStudent(String userid, Model model){
        System.out.println("sssssss");
        User user=studentService.getStudentbyId(userid);
        model.addAttribute("user",user);
        System.out.println("qqqqqq");
        return "updateStudent";
    }
}
