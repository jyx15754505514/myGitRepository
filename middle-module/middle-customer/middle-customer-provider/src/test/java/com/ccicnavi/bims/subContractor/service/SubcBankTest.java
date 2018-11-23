package com.ccicnavi.bims.subContractor.service;

import com.ccicnavi.bims.customer.dao.Impl.SubBankDaoImpl;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 21:01
 * @Description:
 */
public class SubcBankTest {
    SubBankDaoImpl subBankDaoImpl = new SubBankDaoImpl();
    /**
     * @Author FanDongSheng
     * @Description //TODO 插入银行信息
     * @Date 21:10 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void insertSubBank(){
        try{
            for (int i = 1; i <= 30; i++) {
                SubBankDO subBankDO = new SubBankDO();
                subBankDO.setSubcBankUuid("000000"+i);
                subBankDO.setSubcUuid("000000100");
                subBankDO.setSubcCustomer("二级公司"+i);
                subBankDO.setSubcBankAccount("银行账号"+i);
                subBankDO.setSubcBankAddr("开户行地址"+i);
                subBankDO.setSubcBankCode("开户行编号"+i);
                int count = subBankDaoImpl.insertSubBank(subBankDO,null);
                System.out.println("count-----" + count);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 更新银行信息
     * @Date 21:22 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void updateSubBank(){
        try {
            SubBankDO subBankDO = new SubBankDO();
            subBankDO.setSubcBankUuid("0000001");
            subBankDO.setSubcCustomer("二级公司变更啦");
            subBankDaoImpl.updateSubBank(subBankDO,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 得到单条银行信息
     * @Date 21:23 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void getSubBank(){
        try {
            SubBankDO subBankDO = new SubBankDO();
            subBankDO.setSubcBankUuid("0000001");
            subBankDO.setSubcCustomer("二级公司变更啦");
            System.err.print(subBankDaoImpl.getSubBank(subBankDO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 删除
     * @Date 21:25 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void deleteSubBank(){
        try {
            SubBankDTO subBankDTO = new SubBankDTO();
            subBankDTO.setSubcBankUuid("0000001");
            List<String> subcBankUuidList= new ArrayList<String>();
             subcBankUuidList.add("0000001");
             subcBankUuidList.add("00000010");
             subcBankUuidList.add("00000011");
            subBankDTO.setSubcBankUuids(subcBankUuidList);
            subBankDTO.setIsDeleted("Y");
            System.err.print(subBankDaoImpl.deleteSubBank(subBankDTO,null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
