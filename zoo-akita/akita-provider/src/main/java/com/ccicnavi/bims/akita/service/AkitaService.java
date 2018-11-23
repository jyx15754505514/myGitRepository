package com.ccicnavi.bims.akita.service;

import com.ccicnavi.bims.akita.domain.ReturnCode;
import com.ccicnavi.bims.akita.domain.ReturnMessageTest;
import com.ccicnavi.bims.akita.pojo.FastDFSFile;

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
     ReturnMessageTest FileUpload(FastDFSFile fastDFSFile);

    /**
     * 测试上传缩略图
     */
    ReturnCode Thumbnail(FastDFSFile fastDFSFile);
    /**
     * 测试文件下载
     */
     ReturnCode FileDownload(FastDFSFile fastDFSFile);
    /**
     * 测试文件删除
     */
     ReturnCode FileDelete(FastDFSFile fastDFSFile);

}
