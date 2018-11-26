package com.ccicnavi.bims.akita;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.akita.api.AkitaService;
import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.n3r.eql.Eql;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
//        log.info(String.valueOf(upload));
    }

    @Test
    public void listAtta() {
        String businId = "0d4e8e03-0577-477a-9a14-128edea555de";
        List<AttaDO> attaDOS = akitaService.listAtta(businId);
        log.info("attaDOS:{}", attaDOS);
    }

    @Test
    public void delete() {
        File file = new File("C:\\Users\\husky\\Pictures\\20181120100740.jpg");
        AttaDO attaDO = new AttaDO();
        attaDO.setId("181124205031515992630157512704");
        attaDO.setFileNewName("group1/M00/00/00/wKh9B1v5SReALdUCAAIt2fA-0ak068.jpg");
        akitaService.delete(attaDO);
    }

/*    @Test
    public void test3() {
        List<String> stringList = new ArrayList<>();
        stringList.add("0d4e8e03-0577-477a-9a14-128edea555de");
        List<AttaDO> listAttaTmp = new Eql().select("listAttaTmp1").params(stringList).returnType(AttaDO.class).execute();
        System.out.println(listAttaTmp);
    }

    @Test
    public void test4() {

        List<String> names = new Eql().select("selectString").params(Lists.newArrayList("181124205031515992630157512704","111")).execute();
        System.out.println("-----------------------");
        System.out.println(names);
    }*/


}
