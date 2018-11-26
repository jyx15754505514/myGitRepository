package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class PersonDO implements Serializable {

    private String personUuid;

    private String userUuid;

    private String personCode;

    private String name;

    private String firstName;

    private String personType;

    private String formerName;

    private String gender;

    private Date birthday;

    private String certType;

    private String certNo;

    private Integer age;

    private String nationality;

    private String nation;

    private String birthplace;

    private String nativePlace;

    private String domicilePlace;

    private String homeAddress;

    private String politicsStatus;

//    private Date joinPartyTime;

    private String maritalStatus;

    private String phone;

//    private String exigencyPerson;

//    private String exigencyPhone;

    private String studyExperience;

    private String degree;

    private String skillName;

    private String skillLevel;

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
