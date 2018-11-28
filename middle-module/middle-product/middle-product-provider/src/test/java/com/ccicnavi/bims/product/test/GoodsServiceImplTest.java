package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.common.service.pojo.Constants;
import com.ccicnavi.bims.product.api.GoodsService;
import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.pojo.GoodsDTO;
import com.ccicnavi.bims.product.service.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/22 17:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {
    @Resource
    GoodsService goodsService;

    @Test
    public void listGoodsDO() {
        //GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsName("牛");
        goodsDTO.setOrgUuid("XN102");
        goodsDTO.setPublicOrgUuid(Constants.PUBLIC_ORGUUID);
        goodsDTO.setAppSysUuid("BIMS2.0");
        List<GoodsDO> goodsDOList = null;
        try {
            goodsDOList = goodsService.listGoodsDO(goodsDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---sssssssssssssssssssssssssssssss-----"+goodsDOList);
    }

    @Test
    public void saveGoodsDO() {
        int count = 0;
        GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        GoodsDO goodsDO = new GoodsDO();
        for(int i = 1;i<5;i++){
            goodsDO.setGoodsUuid("00000"+i);
            goodsDO.setProdCatalogUuid("11111"+i);
            goodsDO.setOrgUuid("22222"+i);
            goodsDO.setAppSysUuid("3333");
            count += goodsServiceTest.saveGoodsDO(goodsDO);
        }
        System.out.println("------"+count);
    }

    @Test
    public void removeGoodsDO() {
        //GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        //GoodsDO goodsDO = new GoodsDO();
        GoodsDTO goodsDTO = new GoodsDTO();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        goodsDTO.setGoodsUuidList(list);
        int count = 0;
        try {
            count = goodsService.removeGoodsDO(goodsDTO);
            System.out.println("------"+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateGoodsDO() {
        GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setGoodsUuid("000002");
        goodsDO.setGoodsName("中国2222");
        int count = goodsServiceTest.updateGoodsDO(goodsDO);
        System.out.println("------"+count);
    }
}