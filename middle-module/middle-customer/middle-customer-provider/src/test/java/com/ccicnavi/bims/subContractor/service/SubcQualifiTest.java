package com.ccicnavi.bims.subContractor.service;

import com.ccicnavi.bims.customer.dao.Impl.SubcQualifiDaoImpl;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import org.junit.jupiter.api.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

/**
 * @program: bims-backend
 * @description: 分包方资质信息测试
 * @author: WangYingLing
 * @create: 2018-11-16 15:15
 */
public class SubcQualifiTest {

    SubcQualifiDaoImpl subcQualifiDaoTest=new SubcQualifiDaoImpl();


    /**
     * @Author FanDongSheng
     * @Description //TODO 添加资质信息
     * @Date 20:14 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void insertSubcuQuali(){
        SubcQualifiDTO subcQualifiDTO=new SubcQualifiDTO();
        for (int i=1;i<=5;i++)
        {
            subcQualifiDTO.setSubcQualifiUuid("000"+i);
            //指定的分包方的uuid
            subcQualifiDTO.setSubcUuid("88881");
            subcQualifiDTO.setQualifiRange("资质范围"+i);
            subcQualifiDTO.setQualifiEnmUuid("资质类型UUID"+i);
            subcQualifiDTO.setQualifiDescribe("资质描述"+i);
            int count=subcQualifiDaoTest.insertSubcuQuali(subcQualifiDTO,null);
            System.out.println(count);
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 删除资质信息
     * @Date 20:33 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void removeSubcuQuali(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        SubcQualifiDTO subcQualifiDTO=new SubcQualifiDTO();
        subcQualifiDTO.setSubcQualifiUuid("111");
        int count=subcQualifiDaoTest.deleteSubcuQuali(subcQualifiDTO,eqlTran);
        System.out.println(count);
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 修改资质信息
     * @Date 20:33 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void updateSubcuQuali(){
        SubcQualifiDO subcQualifiDOTest=new SubcQualifiDO();
        subcQualifiDOTest.setSubcQualifiUuid("0002");
        subcQualifiDOTest.setQualifiRange("资质范围修改拉拉");
        int count=subcQualifiDaoTest.updateSubcuQuali(subcQualifiDOTest);
        System.out.println(count);
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 回显一条资质信息
     * @Date 20:34 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void getSubcQuali(){
        SubcQualifiDO subcQualifiDOGetTest=new SubcQualifiDO();
        subcQualifiDOGetTest.setSubcQualifiUuid("0002");
        SubcQualifiDO subcQualifiDOData=subcQualifiDaoTest.getSubcQuali(subcQualifiDOGetTest);
        System.out.println(subcQualifiDOData);
    }

}
