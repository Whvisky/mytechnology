package com.example.multiservicetransaction.pojo;

import java.io.Serializable;

/**
 * 角色表(Role)实体类
 *
 * @author makejava
 * @since 2021-08-04 22:03:15
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 729036342348863385L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 角色名
    */
    private String roleName;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}