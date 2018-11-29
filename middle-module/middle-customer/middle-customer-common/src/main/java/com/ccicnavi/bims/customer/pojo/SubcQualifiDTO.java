package com.ccicnavi.bims.customer.pojo;

import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方资质信息实体DTO
 * @author: WangYingLing
 * @create: 2018-11-15 09:16
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcQualifiDTO implements Serializable {

    /**
     * 资质uuid
     */
    private String subcQualifiUuid;
    /**
     * 资质uuids
     */
    private List<String> subcQualifiUuids;

    /**
     *所属分包方UUID
     */
    private String subcUuid;

    /**
     *所属分包方UUIDS
     */
    private List<String> subcUuids;

    /**
     * 资质范围
     */
    private String qualifiRange;

    /**
     * 资质类型(枚举uuid)
     */
    private String qualifiEnmUuid;

    /**
     * 资质编码
     */
    private String qualifiCode;

    /**
     * 资质描述
     */
    private String qualifiDescribe;

    /**
     * 是否上传文件(Y是N否)'
     */
    private String isFile;

    /**
     * 备注
     */
    private String comments;

    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    /**
     * 创建人id
     */
    private String createdUuid;

    /**
     * 创建人
     */
    private String createdName;

    /**
     * 最后一次更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;

    /**
     * 更新人uuid
     */
    private String updatedUuid;

    /**
     * 更新人
     */
    private String updatedName;

    /**
     * 预留字段1
     */
    private String extend1;

    /**
     * 预留字段2
     */
    private String extend2;

    /**
     * 预留字段3
     */
    private String extend3;

    /**
     * 文件对象
     */
    EnclosureVO enclosureVO;

}
