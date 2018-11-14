package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
/***
 * 日志
 */
@Getter
@Setter
@ToString
public class LogDO  implements  Serializable{
    private String logUuid;

    private String requestUrl;

    private String requestUri;

    private String requestMethod;

    private String contextPath;

    private String clientAgent;

    private String clientHostName;

    private String clientIpAddr;

    private String clientUserName;

    private String clientLocale;

    private String clientReferer;

    private String serverHostName;

    private String serverIpAddr;

    private String logType;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;
}
