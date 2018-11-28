package com.ccicnavi.bims.akita;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.akita.api.AkitaService;
import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;
import com.ccicnavi.bims.akita.utils.FileUtils;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.n3r.eql.Eql;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AkitaProviderApplication.class)
@Slf4j
public class AkiaDubboApplicationTest {

    @Reference(timeout = 60000, url = "dubbo://192.168.125.12:20899")
    AkitaService akitaService;

    @Test
    public void test1() {
        File file = new File("C:\\test\\333.txt");
        EnclosureVO enclosureVO = new EnclosureVO();
        enclosureVO.setBusinId(UUID.randomUUID().toString());
        enclosureVO.setCreateBy("yj");
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            enclosureVO.setFile(FileUtils.input2byte(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        enclosureVO.setFileOldName(file.getName());
        enclosureVO.setRemark("测试");
        enclosureVO.setExt("txt");
        enclosureVO.setLength(file.length());
        boolean upload = akitaService.upload(enclosureVO);
        log.info(String.valueOf(upload));
    }

    @Test
    public void listAtta() {
        String businId = "91c69349-c3b4-4bdf-a62e-2489308489e2";
        List<AttaTmpDTO> attaDOS = akitaService.listAtta(businId);
        log.info("===========================attaDOS:{}", attaDOS);
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
