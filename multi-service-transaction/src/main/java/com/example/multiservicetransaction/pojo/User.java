package com.example.multiservicetransaction.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2021-08-04 22:02:02
 */
public class User implements Serializable {
    private static final long serialVersionUID = 683736633481064086L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 姓名
    */
    private String name;
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

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Double getSarary() {
        return sarary;
    }

    public void setSarary(Double sarary) {
        this.sarary = sarary;
    }
    
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}