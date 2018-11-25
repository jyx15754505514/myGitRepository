package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.service.GoodsServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/22 17:55
 */
public class GoodsServiceImplTest {

    @Test
    public void listGoodsDO() {
        GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setGoodsName("中国");
        List<GoodsDO> goodsDOList = goodsServiceTest.listGoodsDO(goodsDO);
        System.out.println("--------"+goodsDOList);
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
        GoodsServiceImpl goodsServiceTest = new GoodsServiceImpl();
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setGoodsUuid("000001");
        int count = goodsServiceTest.removeGoodsDO(goodsDO);
        System.out.println("------"+count);
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