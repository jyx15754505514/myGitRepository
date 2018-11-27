package com.ccicnavi.bims.akita.common.pojo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: husky
 * @Date: 2018/11/27 12:01
 * @Version 0.1
 * @Description:
 */
@Data
public class AttaTmpDTO implements Serializable {
    private String id;
    private String fileNewName;
    private String fileOldName;
    private String fileExt;
    private String fileType;
    private String fileGroup;
    private String createBy;
    private String remark;
    private String businId;
}
