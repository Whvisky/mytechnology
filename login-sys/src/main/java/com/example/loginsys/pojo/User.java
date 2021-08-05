package com.example.loginsys.pojo;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2021-08-01 17:19:46
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 938482915490248412L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 邮箱
    */
    private String email;
    
    private Double sarary;
    /**
    * 创建时间
    */
    private Date createAt;

    public User(String name) {
        this.name = name;
    }



}