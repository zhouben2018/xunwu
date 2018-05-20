package com.zben.service.house;

import com.zben.dto.SubwayDTO;
import com.zben.dto.SubwayStationDTO;
import com.zben.dto.SupportAddressDTO;
import com.zben.entity.SupportAddress;
import com.zben.service.ServiceMultiResult;

import java.util.List;
import java.util.Map;

/**
 * 地址服务接口
 * @Author:zben
 * @Date: 2018/4/30/030 9:02
 */
public interface IAddressService {

    ServiceMultiResult<SupportAddressDTO> findAllCities();

    /**
     * 根据英文简写获取具体区域的信息
     * @param cityEnName
     * @param regionEnName
     * @return
     */
    Map<SupportAddress.Level, SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName);

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     * @param cityName
     * @return
     */
    ServiceMultiResult findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市所有的地铁线路
     * @param cityEnName
     * @return
     */
    List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路所有的站点
     * @param subwayId
     * @return
     */
    List<SubwayStationDTO> findAllStationBySubway(Long subwayId);

}
