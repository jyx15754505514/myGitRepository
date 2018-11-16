package com.ccicnavi.bims.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Data
public class ResultT implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    public ResultT() {}

    public ResultT(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultT success() {
        ResultT resultT = new ResultT();
        resultT.setResultCode(ResultCode.SUCCESS);
        return resultT;
    }

    public static ResultT success(Object data) {
        ResultT resultT = new ResultT();
        resultT.setResultCode(ResultCode.SUCCESS);
        resultT.setData(data);
        return resultT;
    }

    public static ResultT failure(ResultCode resultCode) {
        ResultT resultT = new ResultT();
        resultT.setResultCode(resultCode);
        return resultT;
    }

    public static ResultT failure(ResultCode resultCode, Object data) {
        ResultT resultT = new ResultT();
        resultT.setResultCode(resultCode);
        //resultT.setData(data);
        return resultT;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
}