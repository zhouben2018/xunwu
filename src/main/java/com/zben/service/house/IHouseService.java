package com.zben.service.house;

import com.zben.dto.HouseDTO;
import com.zben.form.HouseForm;
import com.zben.service.ServiceResult;

/**
 * 房屋管理服务接口
 * @Author:zben
 * @Date: 2018/4/30/030 11:18
 */
public interface IHouseService {

    ServiceResult<HouseDTO> save(HouseForm houseForm);
}
