package com.kelin.springboot.entity;

/**
 * 接口返回统一类
 *
 * Author: Mr.tan
 * Date:  2017/08/21
 */
public class RestResponse {

    private int code;
    private String msg;
    private Object data;

    public RestResponse() {

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
