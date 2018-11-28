package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.product.dao.MinItemTestDao;
import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import com.ccicnavi.bims.product.pojo.MinItemTestDTO;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-22 15:27
 */
@Service
public class MinItemTestDaoImpl implements MinItemTestDao {

    @Override
    public int saveMinItemTest(MinItemTestDO minItemTest) {
        return new Eql().insert("insertMinItemTest").params(minItemTest).returnType(int.class).execute();
    }

    @Override
    public int removeMinItemTest(MinItemTestDO minItemTest) {
        return new Eql().delete("deleteMinItemTest").params(minItemTest).returnType(int.class).execute();
    }

    @Override
    public List<TestItemDO> findTestItemByMinItemUuid(MinItemTestDTO minItemTestDTO) {
        return new Eql().select("findTestItemByMinItemUuid").params(minItemTestDTO).returnType(TestItemDO.class).execute();
    }
}
