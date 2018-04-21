package com.zben.repository;

import com.zben.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 10:52
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findOne(Long id);
}
