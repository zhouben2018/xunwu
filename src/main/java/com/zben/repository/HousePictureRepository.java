package com.zben.repository;

import com.zben.entity.HousePicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 10:55
 */
public interface HousePictureRepository extends JpaRepository<HousePicture, Long> {
    List<HousePicture> findAllByHouseId(Long id);
}
