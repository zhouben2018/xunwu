package com.zben.form;

import lombok.Data;

/**
 * 租房请求数据结构体
 * @Author:zben
 * @Date: 2018/5/27/027 11:26
 */
@Data
public class RentSearch {
    private String cityEnName;
    private String regionEnName;
    private String priceBlock;
    private String areaBlock;
    private int room;
    private int direction;
    private String keywords;
    private int rentWay = -1;
    private String orderBy = "lastUpdateTime";
    private String orderDirection = "desc";

    private int start = 0;
    private int size = 5;
}
