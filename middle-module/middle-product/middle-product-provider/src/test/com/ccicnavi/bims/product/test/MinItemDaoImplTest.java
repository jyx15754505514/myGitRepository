package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.MinItemDaoImpl;
import com.ccicnavi.bims.product.pojo.MinItemDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项测试
 * @author: LiJie
 * @create: 2018-11-19 20:17
 */
public class MinItemDaoImplTest {

    MinItemDaoImpl minItemDaoImpl=new MinItemDaoImpl();

    @Test
    public void listMinItem() {
        List<MinItemDO> minItemDOS = minItemDaoImpl.listMinItem(new MinItemDO());
        System.out.println(minItemDOS);
    }

    @Test
    public void saveMinItem() {
        MinItemDO minItemDO=new MinItemDO();
        minItemDO.setMinItemUuid("SY_TK");
        minItemDO.setMinItemName("铁矿");
        minItemDO.setMinItemCode("TK001");
        minItemDO.setProdCatalogUuid("CATALOG_MINERAL");
        minItemDO.setOrgUuid("CCIC");
        minItemDO.setAppSysUuid("BIMS2.0");
        int i = minItemDaoImpl.saveMinItem(minItemDO);
        System.out.println("count:"+i);
    }

    @Test
    public void removeMinItem() {
    }

    @Test
    public void updateMinItem() {
        MinItemDO minItemDO=new MinItemDO();
        minItemDO.setMinItemUuid("SY_TK");
        minItemDO.setMinItemName("铁矿被修改了~");
        minItemDO.setMinItemCode("TK001");
        minItemDO.setProdCatalogUuid("CATALOG_MINERAL");
        minItemDO.setOrgUuid("CCIC");
        minItemDO.setAppSysUuid("BIMS2.0");
        int i = minItemDaoImpl.updateMinItem(minItemDO);
        System.out.println("count:"+i);
    }

    @Test
    public void getMinItem() {
        MinItemDO minItemDO=new MinItemDO();
        minItemDO.setMinItemUuid("SY_TK");
        MinItemDO minItem = minItemDaoImpl.getMinItem(minItemDO);
        System.out.println(minItem);
    }

    @Test
    public void listMinItemPage() {
        PageParameter<MinItemDO> pageParameter=new PageParameter<MinItemDO>();
        pageParameter.setStartIndex(1);
        pageParameter.setPageRows(2);
        pageParameter.setStartPage(1);
        PageBean<MinItemDO> categoryDOPageBean = minItemDaoImpl.listMinItemPage(pageParameter);
        System.out.println(categoryDOPageBean);
    }
}
