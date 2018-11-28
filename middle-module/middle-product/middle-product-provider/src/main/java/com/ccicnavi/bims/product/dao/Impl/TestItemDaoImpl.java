package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.TestItemDao;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import com.ccicnavi.bims.product.pojo.TestItemDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标(product_test_item)DaoImpl
 * @author: WangYingLing
 * @create: 2018-11-19 18:10
 */
@Service
public class TestItemDaoImpl implements TestItemDao {

    @Override
    public List<TestItemDO> listTestItem(TestItemDTO testItemDTO){
        return new Eql().select("listTestItemDO").params(testItemDTO).returnType(TestItemDO.class).execute();
    }

    @Override
    public int saveTestItem(TestItemDO testItemDO){
        return new Eql().insert("saveTestItemDO").params(testItemDO).returnType(int.class).execute();
    }

    @Override
    public int removeTestItem(TestItemDO testItemDO){
        return new Eql().update("removeTestItemDO").params(testItemDO).returnType(int.class).execute();
    }

    @Override
    public int updateTestItem(TestItemDO testItemDO){
        return new Eql().update("updateTestItemDO").params(testItemDO).returnType(int.class).execute();
    }

    @Override
    public TestItemDO getTestItem(TestItemDO testItemDO){
        return new Eql().selectFirst("getTestItemDO").params(testItemDO).returnType(TestItemDO.class).execute();
    }

    @Override
    public PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDTO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<TestItemDO> testItemList = new Eql().select("listTestItemDO").params(pageParameter.getParameter()).returnType(TestItemDO.class).limit(page).execute();
        if(testItemList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),testItemList);//封装分页
        }else {
            return null;
        }
    }
}
