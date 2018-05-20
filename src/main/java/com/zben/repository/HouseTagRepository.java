package com.zben.repository;

import com.zben.entity.HouseTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 10:56
 */
public interface HouseTagRepository extends JpaRepository<HouseTag, Long> {
    List<HouseTag> findAllByHouseId(Long id);
}
