package com.zben.service;

import com.zben.entity.User;

/**
 * 用户服务
 * @Author:zben
 * @Date: 2018/4/22/022 10:49
 */
public interface IUserService {
    User findUserByName(String userName);
}
