package com.ccicnavi.bims.common.service.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageParameter<T> implements Serializable {
    /**
     * 起始页码
     */
    public Integer startPage;

    /**
     * 起始位置
     */
    public Integer startIndex;

    public Integer getStartIndex(){
        return (startPage - 1) * pageRows;
    }

    /**
     * 每页显示条数
     */
    public Integer pageRows;

    /**
     * 参数实体
     */
    public T parameter;
}
