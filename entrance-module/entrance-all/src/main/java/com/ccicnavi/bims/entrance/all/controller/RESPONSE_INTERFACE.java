package com.ccicnavi.bims.entrance.all.controller;

import lombok.Data;

@Data
public class RESPONSE_INTERFACE {

    private Integer code;
    private String massge;

    public static RESPONSE_INTERFACE errorJSONString(int code, String massge) {
        RESPONSE_INTERFACE response = new RESPONSE_INTERFACE();
        response.setCode(code);
        response.setMassge(massge);
        return response;
    }
}
