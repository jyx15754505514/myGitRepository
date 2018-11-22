package com.ccicnavi.bims.akita;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.akita.service.AkitaService;
import com.ccicnavi.bims.akita.service.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AkitaProviderApplication.class)
@Slf4j
public class AkiaDubboApplicationTest {

    @Reference(timeout = 10000,url = "dubbo://127.0.0.1:20880")
    AkitaService akitaService;

/*
* 测试文件上传demo
* */
    @Test
    public void upload(){
        try {
            File file = new File("F:\\photo\\aaa.jpg");
            FileInputStream inputStream = new FileInputStream(file);

            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setName("测试");
            fastDFSFile.setExt(".jpg");
            fastDFSFile.setContent(toByteArray(inputStream));
//StorePath [group=group1, path=M00/00/00/wKh9B1v1WH2ACaTjAAA5aX69MdU007.jpg]
            akitaService.FileUpload(fastDFSFile);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void uploadOne(){
        try {
            File file = new File("F:\\photo\\aaa.jpg");
            FileInputStream inputStream = new FileInputStream(file);

            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setFileSize(222L);
            fastDFSFile.setExt("jpg");
            fastDFSFile.setContent(toByteArray(inputStream));
//group1  M00/00/00/wKh9B1v1cm2AV-DOAAAA3rK6_R4970.jpg
            akitaService.Thumbnail(fastDFSFile);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadTwo(){
        try {
            File file = new File("F:\\photo\\aaa.jpg");
            FileInputStream inputStream = new FileInputStream(file);

            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setName("group1");
            fastDFSFile.setPath("M00/00/00/wKh9B1v1dZOAIoyoAAA5aX69MdU157.jpg");
            fastDFSFile.setContent(toByteArray(inputStream));
            akitaService.FileDownload(fastDFSFile);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadThree(){
        try {
            File file = new File("F:\\photo\\aaa.jpg");
            FileInputStream inputStream = new FileInputStream(file);

            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setName("group1");
            fastDFSFile.setPath("M00/00/00/wKh9B1v1dRGAa4_KAAA5aX69MdU700.jpg");
            fastDFSFile.setContent(toByteArray(inputStream));
            akitaService.FileDelete(fastDFSFile);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
