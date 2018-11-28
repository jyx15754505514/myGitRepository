package com.ccicnavi.bims.akita.common.pojo;

import lombok.Data;

import java.io.File;
import java.io.Serializable;

/**
 * @Auther: husky
 * @Date: 2018/11/20 18:00
 * @Version 0.1
 * @Description:
 */
@Data
public class EnclosureVO implements Serializable {

    /**
     * 文件
     */
    private byte[] file;
    /**
     * 上传人
     */
    private String createBy;

    /**
     * 上传备注
     */
    private String remark;

    /**
     * 文件原始名称
     */
    private String fileOldName;

    /**
     * 业务ID
     */
    private String businId;

    private String ext;
    private long length;


}
