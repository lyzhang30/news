package com.DY.entity;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String loginName;
    private String password;
    private String tel;
    private Date registerTime;
    private String status;
    private Integer roleId;
    //为了方便列表页显示角色名，增加roleName属性
    private String roleName;
}
