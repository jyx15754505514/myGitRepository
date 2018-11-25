package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 设备信息DTO
 * @Data 2018/11/23 11:08
 */
@Getter
@Setter
@ToString
public class EquipDTO implements Serializable {

    /*
     * 设备信息主键
     */
    private String equipUuid;
    /*
     * 设备名称
     */
    private String equipName;
    /*
     * 设备英文名称
     */
    private String equipNameEn;
    /*
     * 设备编号
     */
    private String controlCode;
    /*
     * 型号
     */
    private String equipModel;
    /*
     * 规格
     */
    private String equipSpec;
    /*
     * 出厂编号
     */
    private String factoryNo;
    /*
     * 生产厂家
     */
    private String manufacture;
    /*
     * 出厂等级
     */
    private String factoryLevel;
    /*
     * 测量范围
     */
    private String measureRange;
    /*
     * 准确度等级(不确定度、最大允许误差)
     */
    private String accuracyLevel;
    /*
     * abc分类
     */
    private String equipAbc;
    /*
     * 设备状态(数据字典)
     */
    private String statusUuid;
    /*
     * 当前所属计划/周检UUID
     */
    private String equipPlanUuid;
    /*
     * 当前所属订单ID
     */
    private String equipOrderUuid;
    /*
     * 所属预约单UUID
     */
    private String appointUuid;
    /*
     * 证书编号
     */
    private String certNo;
    /*
     * 检定日期
     */
    private Date testDate;
    /*
     * 启用日期
     */
    private Date useDate;
    /*
     * 使用部门uuid
     */
    private String useDeptUuid;
    /*
     * 是否计量确认
     */
    private String isVerify;
    /*
     * 检定周期
     */
    private String testCycle;
    /*
     * 是否长期有效
     */
    private String isLongTerm;
    /*
     * 检定有效日期
     */
    private Date testValidDate;
    /*
     * 检定结果（合格、不合格）
     */
    private String testResult;
    /*
     * 购置日期
     */
    private Date purchaseDate;
    /*
     * 购置价格
     */
    private Integer purchasePrice;
    /*
     * 购置数量
     */
    private Integer purchaseCount;
    /*
     * 是Y否N租赁
     */
    private String isRent;
    /*
     * 是Y否N现场检测，默认否N
     */
    private String isLocalTest;
    /*
     * 是Y否N自行检测，默认否N
     */
    private String isSelfTest;
    /*
     * 溯源机构uuid
     */
    private String agencyUuid;
    /*
     * 溯源机构名称
     */
    private String agencyName;
    /*
     * 检测类型(数据字典)
     */
    private String testType;
    /*
     * 费用
     */
    private Integer testFee;
    /*
     * 修理费
     */
    private Integer repairFee;
    /*
     * 费用说明
     */
    private String feeDesc;
    /*
     * 存放地点
     */
    private String locationAddr;
    /*
     * 管理部门uuid
     */
    private String deptUuid;
    /*
     * 负责人uuid
     */
    private String mgrUuid;
    /*
     * 配件/附件说明
     */
    private String partsDesc;
    /*
     * 依据技术文件说明
     */
    private String standardDesc;
    /*
     * 器具EQUIP或装置STD
     */
    private String rowType;
    /*
     * 是否上传文件
     */
    private String isFile;
    /*
     * 是否上传证书文件
     */
    private String isCertFile;
    /*
     * 证书在线url
     */
    private String onlineCertUrl;
    /*
     * 计量确认员
     */
    private String sourceCfmName;
    /*
     * 计量确认时间
     */
    private Date sourceCfmDate;
    /*
     * 备注
     */
    private String comments;
    /*
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;
    /*
     * 创建时间
     */
    private Date createdTime;
    /*
     * 创建人id
     */
    private String createdUuid;
    /*
     * 创建人
     */
    private String createdName;
    /*
     * 最后一次更新时间
     */
    private Date updatedTime;
    /*
     * 更新人uuid
     */
    private String updatedUuid;
    /*
     * 更新人
     */
    private String updatedName;
    /*
     * 产品线id
     */
    private String prodCatalogUuid;
    /*
     * 归属机构id
     */
    private String orgUuid;
    /*
     *应用系统id
     */
    private String appSysUuid;
    /**
     * 设备检定记录id
     */
    private String equipTestUuid;
    /*
     * 当前日期Date类型
     */
    private Date nowDate;
    /*
     * 到期提醒天数
     */
    private Integer expireDay;
    /**
     * 设备uuids
     */
    private List<String> equipUuids;
    /**
     * 检定记录List
     */
    private List<EquipTestDO> equipTestDTO;
    /**
     * 领用记录List
     */
    private List<EquipUseDO> equipUseDO;
}
