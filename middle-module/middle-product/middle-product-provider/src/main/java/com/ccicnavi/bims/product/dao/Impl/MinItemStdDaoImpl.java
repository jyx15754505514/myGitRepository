package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.product.dao.MinItemStdDao;
import com.ccicnavi.bims.product.pojo.MinItemStdDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

/**
 * @program: bims-backend
 * @description: 最小服务项与标准数据库交互
 * @author: LiJie
 * @create: 2018-11-22 14:51
 */
@Service
public class MinItemStdDaoImpl implements MinItemStdDao {

    @Override
    public int saveMinItemStd(MinItemStdDO minItemStd) {
        return new Eql().insert("insertMinItemStd").params(minItemStd).returnType(int.class).execute();
    }

    @Override
    public int removeMinItemStd(MinItemStdDO minItemStd) {
        return new Eql().delete("deleteMinItemStd").params(minItemStd).returnType(int.class).execute();
    }

}
