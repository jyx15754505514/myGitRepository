package com.ccicnavi.bims.akita.common.pojo;

import lombok.Data;

import java.io.File;

/**
 * @Auther: husky
 * @Date: 2018/11/20 18:00
 * @Version 0.1
 * @Description:
 */
@Data
public class EnclosureDomain extends SuperEntity {

    /**
     * 文件
     */
    private File file;
    /**
     * 文件关联ID
     */
    private String relationId;


}
