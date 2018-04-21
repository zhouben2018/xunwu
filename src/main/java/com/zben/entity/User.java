package com.zben.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 10:48
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private int status;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private String avatar;

}
