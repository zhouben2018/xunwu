package com.zben.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:zben
 * @Date: 2018/4/22/022 10:57
 */
@Table(name = "role")
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private String name;
}
