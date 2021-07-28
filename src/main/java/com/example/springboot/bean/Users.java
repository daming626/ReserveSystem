package com.example.springboot.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

/**
 * Users实体类
 */
@Data
@TableName("tb_user")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)

    private String userid;
    private String username;
    private String password;
    private String realname;
    private String sex;
    private String tclass;
    private String grade;
    private String contacts;
    private Integer state;

}
