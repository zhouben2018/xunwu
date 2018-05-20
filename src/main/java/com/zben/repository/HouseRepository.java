package com.zben.repository;

import com.zben.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 10:54
 */
public interface HouseRepository extends JpaRepository<House, Long> {
}
