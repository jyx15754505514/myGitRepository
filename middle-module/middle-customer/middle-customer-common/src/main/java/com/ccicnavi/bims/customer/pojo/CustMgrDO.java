package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 10:56
 * @Description: TODO
 * @Version 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustMgrDO implements Serializable {
    /**
    客户uuid
    */
    private String custUuid;
    /**
     客户uuid
     */
    private String userUuid;
    /**
     绩效系数
     */
    private String performance;
    /**
     跟进状态
     */
    private String statusUuid;
    /**
     备注
     */
    private String comments;
}
