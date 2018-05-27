package com.zben.service.user;

import com.zben.dto.UserDTO;
import com.zben.entity.User;
import com.zben.service.ServiceResult;

/**
 * 用户服务
 * @Author:zben
 * @Date: 2018/4/22/022 10:49
 */
public interface IUserService {
    User findUserByName(String userName);

    ServiceResult<UserDTO> findById(Long adminId);
}
