package com.zben.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 17:50
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private Integer code;

    private String message;

    private Object data;

    private boolean more;

    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse message(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(),
                Status.SUCCESS.getMsg(), data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public enum Status {

        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        UPLOAD_ERROR(40007, "Upload Error"),
        NOT_LOGIN(500000, "Not Login"),

;
        private Integer code;
        private String msg;

        Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
