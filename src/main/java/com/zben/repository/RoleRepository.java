package com.zben.repository;

import com.zben.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 角色数据DAO
 * @Author:zben
 * @Date: 2018/4/22/022 10:59
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);

}
