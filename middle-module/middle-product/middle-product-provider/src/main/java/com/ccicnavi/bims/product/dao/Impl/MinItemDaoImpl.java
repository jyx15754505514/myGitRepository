package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.MinItemDao;
import com.ccicnavi.bims.product.pojo.MinItemDO;
import com.ccicnavi.bims.product.pojo.MinItemDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项数据库交互
 * @author: LiJie
 * @create: 2018-11-19 21:27
 */
@Service
public class MinItemDaoImpl implements MinItemDao {


    @Override
    public List<MinItemDO> listMinItem(MinItemDO minItem) {
        return new Eql().select("listMinItem").returnType(MinItemDO.class).execute();
    }

    @Override
    public int saveMinItem(MinItemDO minItem) {
        return new Eql().insert("insertMinItem").params(minItem).returnType(int.class).execute();
    }

    @Override
    public int removeMinItem(MinItemDTO minItemDTO) {
        return new Eql().update("deleteMinItem").params(minItemDTO).returnType(int.class).execute();
    }

    @Override
    public int updateMinItem(MinItemDO minItem) {
        return new Eql().update("updateMinItem").params(minItem).returnType(int.class).execute();
    }

    @Override
    public MinItemDO getMinItem(MinItemDO minItem) {
        return new Eql().selectFirst("getMinItem").params(minItem).returnType(MinItemDO.class).execute();
    }

    @Override
    public PageBean<MinItemDO> listMinItemPage(PageParameter<MinItemDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<MinItemDO> minItemList = new Eql().select("listMinItem").params(pageParameter.getParameter()).returnType(MinItemDO.class).limit(page).execute();
        if (minItemList != null) {
            return new PageBean<>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), minItemList);//封装分页
        } else {
            return null;
        }
    }
}
