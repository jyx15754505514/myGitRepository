package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: （标准）
 * @author: zhangpengwei
 * @create: 2018-11-15 14:49
 */

@Getter
@Setter
@ToString
public class StandardInfoDO implements Serializable {

    private List<String> uuids;

    private String stdUuid;

    private String stdName;

    private String stdCode;

    private String stdReplCode;

    private Date implDate;

    private String isCnas;

    private String isFile;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private Date updatedTime;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    private String orderBy;

//    private Integer currPage;
//
//    private Integer pageRows;
//
//    private Integer totalPages;

}