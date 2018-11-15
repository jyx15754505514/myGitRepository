package com.ccicnavi.bims.customer.dao.Impl;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        return EqlUtils.getInstance("druid").select("listCustAddr").params(custAddr).execute();
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        return EqlUtils.getInstance("druid").insert("insertCustAddr").params(custAddr).execute();
    }

    @Override
    public int removeCustAddr(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return EqlUtils.getInstance("druid").update("deleteCustAddr").params(data).execute();
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        return EqlUtils.getInstance("druid").update("updateCustAddr").params(custAddr).execute();
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO customer) {
        return EqlUtils.getInstance("druid").select("listCustAddr").params(customer).returnType(CustAddrDO.class).execute();
    }


    /**
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListCustAddr(){
        List<CustAddrDO> custList= EqlUtils.getInstance("druid").select("listCustAddr").returnType(CustAddrDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustAddr(){
        for (int i = 1; i <=10; i++) {
            CustAddrDO custAddr=new CustAddrDO();
            custAddr.setAddrUuid("asd"+i);
            custAddr.setCustUuid("asd"+i);
            custAddr.setCustAddr("客户地址"+i);
            custAddr.setBusinessLine("CustAddr");
            custAddr.setOrgUuid("XN102");
            custAddr.setAppSysUuid("KKLIMS102");
            int count= EqlUtils.getInstance("druid").select("insertCustAddr").params(custAddr).execute();
            System.out.println("count"+i);
        }
    }



    @Test
    public void testUpdateCustAddr(){
        CustAddrDO custAddrDO=new CustAddrDO();
        custAddrDO.setAddrUuid("asd10");
        custAddrDO.setCustAddr("客户地址10被修改了~");
        int count=EqlUtils.getInstance("druid").update("updateCustAddr").params(custAddrDO).execute();
    }


    @Test
    public void deleteCustAddr(){
        String uuids="asd1,asd10,asd2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustAddr").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void testGetCustAddr(){
        CustAddrDO custAddr=new CustAddrDO();
        custAddr.setAddrUuid("asd1");
        CustAddrDO getCustAddr= EqlUtils.getInstance("druid").selectFirst("getCustAddr").params(custAddr).returnType(CustAddrDO.class).execute();
        System.out.println(getCustAddr);
    }


    @Test
    public void testUuid(){
        System.out.println(UUID.randomUUID().toString());
    }





}
