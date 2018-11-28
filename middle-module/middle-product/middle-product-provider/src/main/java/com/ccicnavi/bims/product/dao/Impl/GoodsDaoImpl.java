package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.GoodsDao;
import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.pojo.GoodsDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商品信息
 * @author: guojinxu
 * @create: 2018/11/22 15:53
 */
@Service
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public PageBean<GoodsDO> listGoodsPage(PageParameter<GoodsDTO> goodsDOPageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(goodsDOPageParameter.getStartIndex(), goodsDOPageParameter.getPageRows());
        //执行查询
        List<GoodsDO> goodsDOList = new Eql().select("listGoodsDO").params(goodsDOPageParameter.getParameter()).returnType(GoodsDO.class).limit(page).execute();
        if(goodsDOList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),goodsDOList);//封装分页
        }else {
            return null;
        }
    }

    @Override
    public int saveGoodsDO(GoodsDO goodsDO) {
        return new Eql().insert("saveGoodsDO").params(goodsDO).returnType(int.class).execute();
    }

    @Override
    public int removeGoodsDO(GoodsDTO goodsDTO) {
        return new Eql().update("removeGoodsDO").params(goodsDTO).returnType(int.class).execute();
    }

    @Override
    public int updateGoodsDO(GoodsDO goodsDO) {
        return new Eql().update("updateGoodsDO").params(goodsDO).returnType(int.class).execute();
    }

    @Override
    public List<GoodsDO> listGoodsDO(GoodsDTO goodsDTO) {
        return new Eql().select("listGoodsDO").params(goodsDTO).returnType(GoodsDO.class).execute();
    }

    @Override
    public GoodsDO getGoodsDO(GoodsDO goodsDO) {
        return new Eql().selectFirst("getGoodsDO").params(goodsDO).returnType(GoodsDO.class).execute();
    }
}
