package com.ccicnavi.bims.akita;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.akita.api.AkitaService;
import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AkitaProviderApplication.class)
@Slf4j
public class AkiaDubboApplicationTest {

    @Reference(timeout = 60000, url = "dubbo://127.0.0.1:20880")
    AkitaService akitaService;

    @Test
    public void test1() {
        File file = new File("C:\\Users\\husky\\Pictures\\20181120100740.jpg");
        EnclosureVO enclosureVO = new EnclosureVO();
        enclosureVO.setBusinId(UUID.randomUUID().toString());
        enclosureVO.setCreateBy("husky");
        enclosureVO.setFile(file);
        enclosureVO.setFileOldName(file.getName());
        enclosureVO.setRemark("晚上去洗澡");
        boolean upload = akitaService.upload(enclosureVO);
        log.info(String.valueOf(upload));
    }

}
