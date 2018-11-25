package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.GoodsDO;

import java.util.List;

/**
 * @description: 商品信息
 * @author: guojinxu
 * @create: 2018/11/22 15:46
 */
public interface GoodsDao {

    PageBean<GoodsDO> listGoodsPage(PageParameter<GoodsDO> goodsDOPageParameter) throws Exception;

    int saveGoodsDO(GoodsDO goodsDO) throws Exception;

    int removeGoodsDO(GoodsDO goodsDO) throws Exception;

    int updateGoodsDO(GoodsDO goodsDO) throws Exception;

    List<GoodsDO> listGoodsDO(GoodsDO goodsDO)throws Exception;

    GoodsDO getGoodsDO(GoodsDO goodsDO) throws Exception;
}
