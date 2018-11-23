package com.ccicnavi.bims.sso.common.result;


import java.io.Serializable;

/**
 * common return
 *
 * @param <T>
 */
public class ReturnT<T> implements Serializable {
    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int NO_LOGIN_CODE = 201;
    public static final int LOGIN_OUT_CODE = 202;
    public static final int CANT_ACCESS_CODE = 203;



    public static final ReturnT<String> SUCCESS = new ReturnT<String>("");

    private int code;
    private String msg;
    private T data;

    public ReturnT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ReturnT(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
