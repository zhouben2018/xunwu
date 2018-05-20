package com.zben.base;

import lombok.Data;

/**
 * @Author:zben
 * @Date: 2018/5/20/020 9:37
 */
@Data
public class ApiDataTableResponse extends ApiResponse {

    private int draw;
    private long recordsTotal;
    private long recordsFiltered;

    public ApiDataTableResponse(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public ApiDataTableResponse(ApiResponse.Status status) {
        this(status.getCode(), status.getMsg(), null);
    }
}
