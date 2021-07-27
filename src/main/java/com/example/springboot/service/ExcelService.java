package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.Results;
import com.example.springboot.entity.Users;
import org.springframework.web.multipart.MultipartFile;


public interface ExcelService extends IService<Users> {

    Results importProject(MultipartFile file);
}
