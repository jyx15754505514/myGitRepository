package com.ccicnavi.bims.akita;

import com.github.tobato.fastdfs.domain.GroupState;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: husky
 * @Date: 2018/11/20 10:00
 * @Version 0.1
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AkitaProviderApplication.class)
@Slf4j
public class AkitaProviderApplicationTest {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private TrackerClient trackerClient;


    @Test
    public void contextLoads() {
        List<GroupState> groupStates = trackerClient.listGroups();
        for (GroupState groupState : groupStates) {
            System.out.println(groupState);
        }

    }



    /**
     * 测试文件上传
     */
    @Test
    public void upload() {
        try {
            File file = new File("C:\\Users\\husky\\Pictures\\20181120100740.jpg");
            FileInputStream inputStream = new FileInputStream(file);
            StorePath storePath = fastFileStorageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
            System.out.println(storePath);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试上传缩略图
     */
    @Test
    public void uploadCrtThumbImage() {
        try {
            File file = new File("C:\\Users\\husky\\Pictures\\20181120100740.jpg");
            FileInputStream inputStream = new FileInputStream(file);
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, file.length(), "jpg", null);
            System.out.println(storePath.getGroup() + "  " + storePath.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试文件下载
     */
    @Test
    public void download() {
        try {
            byte[] bytes = fastFileStorageClient.downloadFile("group1", "M00/00/00/wKh9B1vzfouAKqt4AAIt2fA-0ak247.jpg", new DownloadByteArray());
            FileOutputStream stream = new FileOutputStream("a.jpg");
            stream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试文件删除
     */
    @Test
    public void deleteFile(){
        fastFileStorageClient.deleteFile("group1","M00/00/00/wKiAjVlpQVyARpQwAADGA0F72jo566.jpg");

    }

}
