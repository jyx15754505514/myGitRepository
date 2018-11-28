package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.GoodsService;
import com.ccicnavi.bims.product.dao.GoodsDao;
import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.pojo.GoodsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @description:商品信息
 * @author: guojinxu
 * @create: 2018/11/22 17:11
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    /**
     * @Author guojinxu
     * @Description 查询商品信息
     * @Date 2018/11/22 17:34
     * @Param [goodsDO]
     * @return java.util.List<com.ccicnavi.bims.product.pojo.GoodsDO>
     **/
    @Override
    public PageBean<GoodsDO> listGoodsPage(PageParameter<GoodsDTO> goodsDOPageParameter) {
        try {
            PageBean<GoodsDO> goodsDOPageBean = goodsDao.listGoodsPage(goodsDOPageParameter);
            return goodsDOPageBean;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询分页商品信息失败",e);
            return null;
        }
    }

    /**
     * @Author guojinxu
     * @Description 新增商品信息
     * @Date 2018/11/22 17:34
     * @Param [goodsDO]
     * @return int
     **/
    @Override
    public int saveGoodsDO(GoodsDO goodsDO) {
        try {
            int count = goodsDao.saveGoodsDO(goodsDO);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增商品信息失败",e);
            return 0;
        }
    }

    /**
     * @Author guojinxu
     * @Description 删除商品信息
     * @Date 2018/11/22 17:35
     * @Param [goodsDO]
     * @return int
     **/
    @Override
    public int removeGoodsDO(GoodsDTO goodsDTO){
        try {
            int count = goodsDao.removeGoodsDO(goodsDTO);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除商品信息失败",e);
            return 0;
        }
    }

    /**
     * @Author guojinxu
     * @Description 修改商品信息
     * @Date 2018/11/22 17:35
     * @Param [goodsDO]
     * @return int
     **/
    @Override
    public int updateGoodsDO(GoodsDO goodsDO){
        try {
            int count = goodsDao.updateGoodsDO(goodsDO);
            return count;
        } catch (Exception e) {
            log.error("修改商品信息失败",e);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<GoodsDO> listGoodsDO(GoodsDTO goodsDTO){
        try {
            List<GoodsDO> goodsDOList = goodsDao.listGoodsDO(goodsDTO);
            return goodsDOList;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询商品信息失败",e);
            return null;
        }
    }

    @Override
    public GoodsDO getGoodsDO(GoodsDO goodsDO) {
        try {
            GoodsDO goodsDO1 = goodsDao.getGoodsDO(goodsDO);
            return goodsDO1;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据主键查询商品信息失败",e);
            return null;
        }
    }
}
