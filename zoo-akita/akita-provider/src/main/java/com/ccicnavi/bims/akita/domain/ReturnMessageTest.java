package com.ccicnavi.bims.akita.domain;

import java.io.Serializable;

/**
 * Created by zhaoxu on 2018/11/21.
 */
public class ReturnMessageTest implements Serializable {

    private String group;
    private String path;

    public ReturnMessageTest(String group, String path) {
        this.group = group;
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
