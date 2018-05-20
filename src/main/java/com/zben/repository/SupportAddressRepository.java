package com.zben.repository;

import com.zben.entity.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 8:55
 */
public interface SupportAddressRepository extends JpaRepository<SupportAddress, Long> {

    //获取所有对应行政级别的信息
    List<SupportAddress> findAllByLevel(String level);

    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);
}
