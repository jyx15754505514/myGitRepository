package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
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
        return EqlUtils.getInstance("druid").select("listCustTail").params(custTail).execute();
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        return EqlUtils.getInstance("druid").insert("insertCustTail").params(custTail).execute();
    }

    @Override
    public int removeCustTail(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return EqlUtils.getInstance("druid").update("deleteCustTail").params(data).execute();
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        return EqlUtils.getInstance("druid").update("updateCustTail").params(custTail).execute();
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTail) {
        return EqlUtils.getInstance("druid").selectFirst("getCustTail").params(custTail).returnType(CustTailDO.class).execute();
    }


    /**
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListCustTail(){
        List<CustTailDO> custList= EqlUtils.getInstance("druid").select("listCustTail").returnType(CustTailDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustTail(){
        for (int i = 1; i <=10; i++) {
            CustTailDO custTail=new CustTailDO();
            custTail.setTailUuid("客户跟踪"+i);
            custTail.setCustUuid("客户跟踪"+i);
            custTail.setIdea("客户跟踪");
            int count= EqlUtils.getInstance("druid").select("insertCustTail").params(custTail).execute();
            System.out.println("count"+i);
        }
    }

    @Test
    public void testUpdateCustTail(){
        CustTailDO custTailDO=new CustTailDO();
        custTailDO.setTailUuid("客户跟踪1");
        custTailDO.setPerformance("客户跟踪1被修改了~");
        int count=EqlUtils.getInstance("druid").update("updateCustTail").params(custTailDO).execute();
        System.out.println(count);
    }


    @Test
    public void deleteCustTail(){
        String uuids="客户跟踪1,客户跟踪10,客户跟踪2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustTail").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void getCustTail(){
        CustTailDO custTailDO=new CustTailDO();
        custTailDO.setTailUuid("客户跟踪1");
        CustTailDO custTail= EqlUtils.getInstance("druid").selectFirst("listCustTail").params(custTailDO).returnType(CustTailDO.class).execute();
        System.out.println(custTail);
    }



}
