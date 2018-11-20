package com.ccicnavi.bims.akita.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: husky
 * @Date: 2018/11/20 11:28
 * @Version 0.1
 * @Description:
 */

/**
 * 基础类
 * @param <T>
 */
@Data
public class SuperEntity <T> implements Serializable{
    private static final long serialVersionUID = 7560570481504032191L;

    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createDate;


    /**
     * 乐观锁标识
     */
    private Long lockVersion;


    protected Serializable pkVal() {
        return this.id;
    }

}