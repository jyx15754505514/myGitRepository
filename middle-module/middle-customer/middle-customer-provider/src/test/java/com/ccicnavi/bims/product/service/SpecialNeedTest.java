//package com.ccicnavi.bims.product.service;
//
//import com.ccicnavi.bims.customer.dao.Impl.SpecialNeedDaoImpl;
//import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: bims-backend
// * @description: 测试客户特殊需求信息Dao
// * @author: WangYingLing
// * @create: 2018-11-16 10:58
// */
//public class SpecialNeedTest {
//
//    SpecialNeedDaoImpl specialNeedDaoImpl =new SpecialNeedDaoImpl();
//
//    @Test
//    public void testListSpecialNeed() {
//
//        List<SpecialNeedDO> specialNeedDOList=specialNeedDaoImpl.listSpecialNeed();
//        System.out.println(specialNeedDOList);
//    }
//
//    @Test
//    public void testSaveSpecialNeed() {
//        for (int i = 1; i <= 15; i++) {
//            SpecialNeedDO specialNeedDO = new SpecialNeedDO();
//            specialNeedDO.setNeedUuid("asd" + i);
//            specialNeedDO.setCustUuid("asd" + i);
//            specialNeedDO.setNeedType("类型" + i);
//            specialNeedDO.setNeedContent("另一个"+i);
//            specialNeedDO.setDeptUuid("DeptUuid"+i);
//            specialNeedDO.setCreatedUuid("cud"+i);
//            specialNeedDO.setCreatedName("徐"+i);
////            System.out.println(specialNeedDO);
//            int count = specialNeedDaoImpl.saveSpecialNeed(specialNeedDO);
//            System.out.println("count-----" + count);
//        }
//    }
//
//    @Test
//    public void testUpdateSpecialNeed() {
//        SpecialNeedDO specialNeedDO = new SpecialNeedDO();
//        specialNeedDO.setNeedUuid("asd4");
//        specialNeedDO.setCreatedName("徐4被修改了~");
//        int count = specialNeedDaoImpl.updateSpecialNeed(specialNeedDO);
//        System.out.println(count);
//    }
//
//
//    @Test
//    public void testRemoveSpecialNeed() {
//        String uuids = "asd1,asd10,asd2";
//        int count = specialNeedDaoImpl.removeSpecialNeed(uuids);
//        System.out.println(count);
//    }
//
//    @Test
//    public void testGetSpecialNeed() {
//        SpecialNeedDO specialNeedDO = new SpecialNeedDO();
//        specialNeedDO.setNeedUuid("asd9");
//        SpecialNeedDO getCustAddr = specialNeedDaoImpl.getSpecialNeed(specialNeedDO);
//        System.out.println(getCustAddr);
//    }
//
//}
