package com.ccicnavi.bims.akita.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.akita.domain.ReturnCode;
import com.ccicnavi.bims.akita.service.AkitaService;
import com.ccicnavi.bims.akita.service.FastDFSFile;
import com.ccicnavi.bims.akita.domain.ReturnMessageTest;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * @Auther: husky
 * @Date: 2018/11/20 17:56
 * @Version 0.1
 * @Description:
 */
@Service
public class AkitaServiceImpl implements AkitaService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /*
     * 测试文件上传实现
     *
     * */
    @Override
    public ReturnMessageTest FileUpload(FastDFSFile fastDFSFile) {
//            File file = new File(fastDFSFile.getPath());
//            FileInputStream inputStream = new FileInputStream(file);
            InputStream inputStream = new ByteArrayInputStream(fastDFSFile.getContent());
            StorePath storePath = fastFileStorageClient.uploadFile(inputStream,fastDFSFile.getContent().length, FilenameUtils.getExtension(fastDFSFile.getExt()), null);
            System.out.println(storePath);
            ReturnMessageTest returnMessageTest = new ReturnMessageTest(storePath.getGroup(),storePath.getPath());
            return returnMessageTest;
    }

    /**
     * 测试上传缩略图
     */
    @Override
    public ReturnMessageTest Thumbnail(FastDFSFile fastDFSFile) {
            InputStream inputStream = new ByteArrayInputStream(fastDFSFile.getContent());
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, fastDFSFile.getFileSize(), fastDFSFile.getExt(), null);
            System.out.println(storePath.getGroup() + "  " + storePath.getPath());
            ReturnMessageTest returnMessageTest = new ReturnMessageTest(storePath.getGroup(),storePath.getPath());
            return returnMessageTest;
    }
    /**
     * 测试文件下载
     */
    @Override
    public ReturnCode FileDownload(FastDFSFile fastDFSFile) {
        try {
            byte[] bytes = fastFileStorageClient.downloadFile(fastDFSFile.getName(), fastDFSFile.getPath(), new DownloadByteArray());
            FileOutputStream stream = new FileOutputStream(fastDFSFile.getName());
            stream.write(bytes);
            System.out.print(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ReturnCode.SUCCESS;
    }
    /**
     * 测试文件删除
     */
    @Override
    public ReturnCode FileDelete(FastDFSFile fastDFSFile) {

        try{
        fastFileStorageClient.deleteFile(fastDFSFile.getName(), fastDFSFile.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ReturnCode.SUCCESS;
    }


}
