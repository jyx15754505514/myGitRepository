package com.ccicnavi.bims.akita.common.pojo.domain;

import lombok.Data;

/**
 * @Auther: husky
 * @Date: 2018/11/24 14:23
 * @Version 0.1
 * @Description:
 */
@Data
public class AttaTmpDO extends BaseDO {
    private String id;
    private String businId;
    private String attaId;
    private String remark;


    public AttaTmpDO(String id, String businId, String attaId, String remark) {
        this.id = id;
        this.businId = businId;
        this.attaId = attaId;
        this.remark = remark;
    }

    public AttaTmpDO() {
    }
}
