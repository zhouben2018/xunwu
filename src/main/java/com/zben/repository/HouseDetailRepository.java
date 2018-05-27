package com.zben.repository;

import com.zben.entity.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 10:55
 */
public interface HouseDetailRepository extends JpaRepository<HouseDetail, Long> {
    HouseDetail findByHouseId(Long id);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
