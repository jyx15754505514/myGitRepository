package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户跟踪信息数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustTailDaoImpl implements CustTailDao {

    @Override
    public List<CustTailDO> listCustTail(CustTailDO custTail) {
        return new Eql().select("listCustTail").params(custTail).execute();
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        return new Eql().insert("insertCustTail").params(custTail).execute();
    }

    @Override
    public int removeCustTail(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return new Eql().update("deleteCustTail").params(data).execute();
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        return new Eql().update("updateCustTail").params(custTail).execute();
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTail) {
        return new Eql().selectFirst("getCustTail").params(custTail).returnType(CustTailDO.class).execute();
    }





}
