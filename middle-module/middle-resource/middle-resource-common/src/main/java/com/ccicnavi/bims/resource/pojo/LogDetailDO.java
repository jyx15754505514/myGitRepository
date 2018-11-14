package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * 日志详情
 * @Date 2018/11/13 17 52
 * @Auther mzj
 */
@Getter
@Setter
@ToString
public class LogDetailDO {

    private String logUuid;

    private String operName;

    private Date operTime;

    private String operContent;

    private String operModule;

    private String comments;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;
}
