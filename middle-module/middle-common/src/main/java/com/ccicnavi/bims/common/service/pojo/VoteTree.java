package com.ccicnavi.bims.common.service.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/21 10:15
 * @Version 0.1
 * @Description:
 */

@Data
public class VoteTree implements java.io.Serializable {

    // Fields

    /**
     * @Fields id : 编号
     */
    private Long id;
    /**
     * @Fields text : 文字
     */
    private String text;
    /**
     * @Fields pid :父目录的id
     */
    private Long pid;
    /**
     * @Fields levels : 所在级别
     */
    private Long levels;
    /**
     * @Fields children : 子节点集合
     */
    private List<VoteTree> children = new ArrayList();
}

