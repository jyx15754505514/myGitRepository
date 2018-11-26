package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
  * @author songyateng
  * @description 客户
  * @date 2018/11/26 10:01
  */
@Setter
@Getter
@ToString
public class CustomerDO implements Serializable {
    /**
     * 客户唯一标识符
     */
    private String custUuid;
    /**
     * 客户所属公司id
     */
    private String custParentUuid;
    /**
     *客户名称
     */
    private String custName;
    /**
     *客户英文名称
     */
    private String custNameEn;
    /**
     *简称
     */
    private String custShortName;
    /**
     *客户代码
     */
    private String custCode;
    /**
     *统一社会信用代码
     */
    private String custUscc;
    /**
     *地址
     */
    private String custAddr;
    /**
     *英文地址
     */
    private String custRegion;
    /**
     *地址区域
     */
    private String custScale;
    /**
     *规模
     */
    private String custAddrEn;
    /**
     *客户邮编
     */
    private String custPostCode;
    /**
     *传真
     */
    private String custFax;
    /**
     *客户电话
     */
    private String custPhone;
    /**
     *网址
     */
    private String custUrl;
    /**
     *所在行业
     */
    private String custTrade;
    /**
     *开始合作时间
     */
    private Date cooperationStartDate;
    /**
     *是否沉淀（业务完成未结账N否Y是）
     */
    private String isSediment;
    /**
     *客户来源
     */
    private String custSource;
    /**
     *推荐部门
     */
    private String recommendDept;
    /**
     *推荐人
     */
    private String recommendUser;
    /**
     *推荐备注
     */
    private String recommendComm;
    /**
     *跟进部门
     */
    private String followDept;
    /**
     *服务种类
     */
    private String serveType;
    /**
     *特殊要求
     */
    private String specialRequire;
    /**
     *市场负责人
     */
    private String marketMgrName;
    /**
     *行业分类
     */
    private String custIndustryType;
    /**
     *信用等级
     */
    private String custCreditRating;
    /**
     *主联系人id
     */
    private String mainLinkmanUuid;
    /**
     *主联系人
     */
    private String mainLinkmanName;
    /**
     *客户等级
     */
    private String custLevel;
    /**
     *结算周期
     */
    private String finCycle;
    /**
     *客户状态id
     */
    private String statusUuid;
    /**
     *客户类型
     */
    private String custUnitType;
    /**
     *集团客户类型
     */
    private String corpUnitType;
    /**
     *竞争对手
     */
    private String custCompetitor;
    /**
     *主营产品
     */
    private String mainProduct;
    /**
     *备注
     */
    private String comments;
    /**
     *删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     *创建时间
     */
    private Date createdTime;
    /**
     *创建人id
     */
    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *最后一次更新时间
     */
    private Date updatedTime;
    /**
     *更新人
     */
    private String updatedName;
    /**
     *更新人uuid
     */
    private String updatedUuid;
    /**
     *产品线id
     */
    private String prodCatalogUuid;
    /**
     *归属机构id
     */
    private String orgUuid;
    /**
     *应用系统id
     */
    private String appSysUuid;
    /**
     *预留字段1
     */
    private String extend1;
    /**
     *预留字段2
     */
    private String extend2;
    /**
     *预留字段3
     */
    private String extend3;
    /**
     *要删除的客户主键
     */
    private List<String> uuids;





}
