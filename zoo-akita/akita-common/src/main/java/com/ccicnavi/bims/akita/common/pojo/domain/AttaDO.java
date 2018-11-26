package com.ccicnavi.bims.akita.common.pojo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: husky
 * @Date: 2018/11/24 14:21
 * @Version 0.1
 * @Description:
 */
@Data
public class AttaDO extends BaseDO implements Serializable {
    private String id;
    private String fileNewName;
    private String fileOldName;
    private String fileExt;
    private String fileType;
    private String fileGroup;
    private String createBy;
    private String remark;

    public AttaDO(){

    }

    public AttaDO(String id, String fileNewName, String fileOldName, String fileExt, String fileType, String fileGroup, String createBy, String remark) {
        this.id = id;
        this.fileNewName = fileNewName;
        this.fileOldName = fileOldName;
        this.fileExt = fileExt;
        this.fileType = fileType;
        this.fileGroup = fileGroup;
        this.createBy = createBy;
        this.remark = remark;
    }
}
