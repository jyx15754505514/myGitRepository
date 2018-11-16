package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户地址数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustAddrDaoImpl implements CustAddrDao {

    @Override
    public List<CustAddrDO> listCustAddr(CustAddrDO custAddr) {
        return new Eql().select("listCustAddr").params(custAddr).returnType(CustAddrDO.class).execute();
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        return new Eql().insert("insertCustAddr").params(custAddr).execute();
    }

    @Override
    public int removeCustAddr(String uuids) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("ids", uuids.split(","));
        return new Eql().update("deleteCustAddr").params(data).execute();
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        return new Eql().update("updateCustAddr").params(custAddr).execute();
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO customer) {
        return new Eql().select("listCustAddr").params(customer).returnType(CustAddrDO.class).execute();
    }





}
