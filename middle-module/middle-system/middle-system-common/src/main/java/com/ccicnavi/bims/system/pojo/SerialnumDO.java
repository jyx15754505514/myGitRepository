package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:21
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumDO {
    private String snUuid;

    private String sncUuid;

    private String snDeptCode;

    private String busUuid;

    private String seqId;

    private String seqYmd;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
