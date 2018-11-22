package com.ccicnavi.bims.akita.pojo;

import org.omg.CORBA.StringHolder;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件表
 * */
public class SysFile implements Serializable {

    private String fileUuid;

    private String confUuid;
    //实体名称
    private String entityName;
    //实体中记录Id
    private String entity_RwId;
    //文件分类/类型/类别
    private String fileCtegory;
    //文件名称
    private String fileNme;
    //mimeType(如：application/msword)
    private String mimeTypeId;
    //上传路径(如： WD161128119/CERT/sampleCode.doc,WD161128119/CERT/sampleCode.jpg)
    private String filePath;
    //文件大小
    private String fileSize;
    //文件扩展名
    private String fileExtName;
    //上传时间
    private Date uploadTime;
    //图片描述
    private String fileText;
    //客户cmUUId
    private String orgUuid;

    private String appSysUuid;

    private String createdName;

    private String createdUuid;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updatedTime;

    private String updatedName;
    //删除标识（N正常Y删除）默认N
    private char isDeleted;
    //是否为系统配置  0:不是系统配置  1:系统配置
    private char is_sys;

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }

    public String getConfUuid() {
        return confUuid;
    }

    public void setConfUuid(String confUuid) {
        this.confUuid = confUuid;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntity_RwId() {
        return entity_RwId;
    }

    public void setEntity_RwId(String entity_RwId) {
        this.entity_RwId = entity_RwId;
    }

    public String getFileCtegory() {
        return fileCtegory;
    }

    public void setFileCtegory(String fileCtegory) {
        this.fileCtegory = fileCtegory;
    }

    public String getFileNme() {
        return fileNme;
    }

    public void setFileNme(String fileNme) {
        this.fileNme = fileNme;
    }

    public String getMimeTypeId() {
        return mimeTypeId;
    }

    public void setMimeTypeId(String mimeTypeId) {
        this.mimeTypeId = mimeTypeId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtName() {
        return fileExtName;
    }

    public void setFileExtName(String fileExtName) {
        this.fileExtName = fileExtName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

    public String getOrgUuid() {
        return orgUuid;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    public String getAppSysUuid() {
        return appSysUuid;
    }

    public void setAppSysUuid(String appSysUuid) {
        this.appSysUuid = appSysUuid;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getCreatedUuid() {
        return createdUuid;
    }

    public void setCreatedUuid(String createdUuid) {
        this.createdUuid = createdUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public char getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(char isDeleted) {
        this.isDeleted = isDeleted;
    }

    public char getIs_sys() {
        return is_sys;
    }

    public void setIs_sys(char is_sys) {
        this.is_sys = is_sys;
    }

    public String getProdCatalogUuid() {
        return prodCatalogUuid;
    }

    public void setProdCatalogUuid(String prodCatalogUuid) {
        this.prodCatalogUuid = prodCatalogUuid;
    }

    //产品线id
    private String prodCatalogUuid;

}