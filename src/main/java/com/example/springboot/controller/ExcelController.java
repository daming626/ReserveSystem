package com.example.springboot.controller;

import com.example.springboot.bean.Result;
import com.example.springboot.bean.Results;
import com.example.springboot.service.ExcelService;
import com.example.springboot.utils.ExcelTool;
import com.example.springboot.utils.FileUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 接口
 */

@Controller
@RequestMapping("/document")
public class ExcelController {

    Logger logger = LoggerFactory.getLogger(ExcelController.class);//LoggerFactory.getLogger意思是日志输出的时候，可以打印出日志信息所在类

    @Autowired
    private ExcelService excelService;

        @GetMapping("documentEntry.do")
        public String documententry(){
            System.out.println("页面跳转");
            return "index";
    }
    @PostMapping("/import")
    @ResponseBody//响应体
    public Results importProject(MultipartFile file) {
        String postfix = ExcelTool.getPostfix(file.getOriginalFilename());//调用getPostfix获得文件后缀名

        if (!"xlsx".equals(postfix)) {
            return Results.error("导入失败，请选择正确的文件格式支持xlsx");
        }
        System.out.println("拿到file文件");
        return excelService.importProject(file);
    }

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {//HttpServletRequest接口最常用的方法就是获得请求中的参数，这些参数一般是客户端表单中的数据,当服务器响应客户端的一个请求时，就要用到HttpServletResponse接口
        String fileName = "template.xlsx";
        String result = FileUtils.downloadFiles(request, response, fileName);
        if (request == null) {
            return null;
        }
        return result;
    }
}
