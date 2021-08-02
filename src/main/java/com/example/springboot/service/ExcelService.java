package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.bean.Result;
import com.example.springboot.bean.Results;
import com.example.springboot.bean.Users;
import org.springframework.web.multipart.MultipartFile;


public interface ExcelService extends IService<Users> {

    Results importProject(MultipartFile file);
}
