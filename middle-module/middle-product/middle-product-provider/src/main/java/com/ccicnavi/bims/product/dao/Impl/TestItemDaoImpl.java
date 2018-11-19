package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.product.dao.TestItemDao;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-19 18:10
 */
@Service
public class TestItemDaoImpl implements TestItemDao {

    @Override
    public List<TestItemDO> listTestItemDO(){
        return new Eql().select("listTestItemDO").execute();
    }

    @Override
    public int saveTestItemDO(TestItemDO testItemDO){
        return new Eql().insert("saveTestItemDO").params(testItemDO).execute();
    }

    @Override
    public int removeTestItemDO(TestItemDO testItemDO){
        return new Eql().update("removeTestItemDO").params(testItemDO).execute();
    }

    @Override
    public int updateTestItemDO(TestItemDO testItemDO){
        return new Eql().update("updateTestItemDO").params(testItemDO).execute();
    }

    @Override
    public TestItemDO getTestItemDO(TestItemDO testItemDO){
        return new Eql().selectFirst("getTestItemDO").params(testItemDO).returnType(TestItemDO.class).execute();
    }
}
