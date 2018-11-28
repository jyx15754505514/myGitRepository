package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.pojo.GoodsDTO;

import java.util.List;

/**
 * @description: 商品信息
 * @author: guojinxu
 * @create: 2018/11/22 15:45
 */
public interface GoodsService {
    /**分页 查询商品信息*/
    PageBean<GoodsDO> listGoodsPage(PageParameter<GoodsDTO> goodsDOPageParameter) throws Exception;

    /**新增商品信息*/
    int saveGoodsDO(GoodsDO goodsDO) throws Exception;

    /**删除商品信息*/
    int removeGoodsDO(GoodsDTO goodsDTO) throws Exception;

    /**修改商品信息*/
    int updateGoodsDO(GoodsDO goodsDO) throws Exception;

    /**查询商品信息*/
    List<GoodsDO> listGoodsDO(GoodsDTO goodsDTO)throws Exception;

    /**根据主键 查询商品信息*/
    GoodsDO getGoodsDO(GoodsDO goodsDO)throws Exception;

}
