package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 人员DTO
 * @author: zqq
 * @create: 2018-11-29 16:22
 */
@Setter
@Getter
@ToString
public class PersonDTO implements Serializable {

    private String personUuid;

    private String userUuid;

    private String personCode;

    private String firstName;

    private String personType;

    private String formerName;

    private String gender;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthdate;

    private String certType;

    private String certNo;

    private Integer age;

    private String nationality;

    private String nation;

    private String birthplace;

    private String nativePlace;

    private String domiPlace;

    private String homeAddress;

    private String politicsStatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date joinPartyDate;

    private String maritalStatus;

    private String phone;

    private String exigencyPerson;

    private String exigencyPhone;

    private String studyExperience;

    private String degree;

    private String skillName;

    private String skillLevel;

    private String comments;

    private String isDeleted;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    private String createdUuid;

    private String createdName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;

    private String updatedName;

    private String updatedUuid;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    /**
     * 部门id
     */
    private String deptUuid;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 职位
     */
    private String position;
    /**
     * 资质信息
     */
    private String qualificationCert;
}
