package com.ccicnavi.bims.common.service.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/15 16:20
 * @Version 0.1
 * @Description:
 */
@Data
public class PageBean<T> implements Serializable {
    /**
     *
     */
    private int total;
    /**
     *
     */
    private int totalPage;
    /**
     *
     */
    private int pageNumber;
    /**
     *
     */
    private int pageSize;
    /**
     *
     */
    private int startIndex;
    /**
     *
     */
    private List<T> products;


    public PageBean(int totalRows,int totalpages,int currentpage,int pageRows,int startIndex, List<T> products){
        this.total = totalRows;
        this.totalPage = totalpages;
        this.pageNumber = currentpage;
        this.pageSize = pageRows;
        this.startIndex = startIndex;
        this.products = products;

    }
}
