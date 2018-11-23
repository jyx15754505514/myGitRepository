package com.ccicnavi.bims.sso.common.result;


import com.ccicnavi.bims.common.ResultCode;

import java.io.Serializable;

/**
 * common return
 *
 * @param <T>
 */
public class ReturnT<T> implements Serializable {
    public static final long serialVersionUID = 42L;

    private int code;
    private String msg;
    private T data;

    public ReturnT(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ReturnT(int code,String msg,T data) {
        this.code = code;
        this.msg = msg;
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
