package com.ccicnavi.bims.product.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品线标准信息DO
 * @author: lvqiru
 * @create: 2018-11-21 18:00
 */
@Setter
@Getter
@ToString
public class StandardInfoDTO implements Serializable {

	/**
	 * 主键
	 */
	private String stdUuid;

	/**
	 * 标准名称
	 */
	private String stdName;

	/**
	 * 标准编号
	 */
	private String stdCode;

	/**
	 * 代替标准号
	 */
	private String stdReplaceCode;

	/**
	 * 负责部门
	 */
	private String deptUuid;

	/**
	 * 备注
	 */
	private String comments;

    /**
     * 产品线id
	 */
	private String prodCatalogUuid;

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
	 *更新人uuid
	 */
	private String updatedUuid;

	/**
	 *更新人
	 */
	private String updatedName;

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
	 * 批量主键
	 */
	private String [] uuids;

}
