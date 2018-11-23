package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.dao.Impl.MinItemTestDaoImpl;
import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import org.junit.Test;

import java.util.Date;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-22 21:56
 */
public class TestIgnoreInsert {

    /**
     * 22 22:15:24 CST 2018
     * 22 22:15:28 CST 2018
     *
     * 22 22:27:25
     * 22 22:29:09
     *
     * insert之后:    24.638s
     * 22 22:36:05
     * 22 22:36:30
     *
     *
     * 加入ignore之后：    27.5s
     * 22 22:33:30
     * 22 22:33:57
     *
     * 数据重复insert之后：63.159s
     * 22 22:38:19
     * 22 22:39:22
     */
    @Test
    public void testSaveDate(){
        MinItemTestDaoImpl minItemTestDaoImpl = new MinItemTestDaoImpl();
        MinItemTestDO minItemTestDao = new MinItemTestDO();
        long t1=System.currentTimeMillis();
        System.out.println("方法执行前：——————————————————"+new Date());
        for (int i = 1; i <= 1000; i++) {
            minItemTestDao.setMinItemUuid("KC_MT_JM_JC");
            minItemTestDao.setTestItemUuid("item_"+i);
            minItemTestDao.setOrgUuid("HD"+i);
            minItemTestDao.setAppSysUuid("BIMS2.0");
            minItemTestDaoImpl.saveMinItemTest(minItemTestDao);
        }
        long t2=System.currentTimeMillis();
        System.out.println("差——————————————————————————"+(t2-t1));
        System.out.println("方法执行后：——————————————————"+new Date());
    }

}
