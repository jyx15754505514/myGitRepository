package com.ccicnavi.bims.akita.service;

import com.ccicnavi.bims.akita.domain.ReturnCode;
import com.ccicnavi.bims.akita.domain.ReturnMessageTest;
import com.sun.javaws.jnl.MatcherReturnCode;

/**
 * @Auther: husky
 * @Date: 2018/11/20 11:26
 * @Version 0.1
 * @Description:
 */
public interface AkitaService {

    /*
     * 测试文件上传
     *
     * */
    public ReturnMessageTest FileUpload(FastDFSFile fastDFSFile);

    /**
     * 测试上传缩略图
     */
    public ReturnMessageTest Thumbnail(FastDFSFile fastDFSFile);
    /**
     * 测试文件下载
     */
    public ReturnCode FileDownload(FastDFSFile fastDFSFile);
    /**
     * 测试文件删除
     */
    public ReturnCode FileDelete(FastDFSFile fastDFSFile);

}
