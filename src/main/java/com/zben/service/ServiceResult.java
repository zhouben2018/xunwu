package com.zben.service;

import lombok.Data;

/**
 * 服务接口通用结构
 * @Author:zben
 * @Date: 2018/4/30/030 11:19
 */
@Data
public class ServiceResult<T> {
    private boolean success;
    private String message;
    private T result;

    public ServiceResult(boolean success) {
        this.success = success;
    }

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServiceResult(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }
}
