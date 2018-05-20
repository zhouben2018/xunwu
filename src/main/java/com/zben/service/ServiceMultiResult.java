package com.zben.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通用多结果Service返回结构
 * @Author:zben
 * @Date: 2018/4/30/030 9:42
 */
@Getter
@Setter
public class ServiceMultiResult<T> {
    private long total;
    private List<T> result;

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public int getResultSize() {
        if (this.result == null) {
            return 0;
        }
        return this.result.size();
    }
}
