package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Auther: mzj
 * @Date: 2018/11/14 09:30
 * @Description:日志详情
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
