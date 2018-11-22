package com.ccicnavi.bims.akita.pojo;

import java.io.Serializable;

/*
* 附件并联表SysFileParallel
* */
public class SysFileParallel implements Serializable {

    private String parallelId;
    //附件表ID
    private String fileUuId;
    //文件表Id
    private String fileId;
    //文件名字
    private String fileName;
    //文件扩展名
    private String fileExt;
    //文件路径
    private String filePath;
    //文件大小
    private Long fileSize;

    public String getParallelId() {
        return parallelId;
    }

    public void setParallelId(String parallelId) {
        this.parallelId = parallelId;
    }

    public String getFileUuId() {
        return fileUuId;
    }

    public void setFileUuId(String fileUuId) {
        this.fileUuId = fileUuId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
