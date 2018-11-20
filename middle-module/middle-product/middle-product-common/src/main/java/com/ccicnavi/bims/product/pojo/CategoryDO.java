package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品类别DO
 * @author: LiJie
 * @create: 2018-11-19 17:24
 */
@Setter
@Getter
@ToString
public class CategoryDO implements Serializable {
	
    private String productCategoryUuid;//产品类别主键

    private String productCategoryTypeUuid;//产品类别分类ID

    private String parentCategoryUuid;//主父节点分类ID

    private String parentAllCategoryUuid;//所有分类的ID

    private String categoryName;//类别名称

    private String categoryCode;//类别编码

    private String seqNum;//排序号

    private String description;//备注
    
    private String longDescription;

    private String prodCatalogUuid;//产品线ID

    private String isEnabled;//是否可用Y/N

    private String isDeleted;//是否删除

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;//所属公司机构ID

    private String appSysUuid;//所属平台ID

    private String extend1;

    private String extend2;

    private String extend3;


}