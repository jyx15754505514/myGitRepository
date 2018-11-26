package com.ccicnavi.bims.subContractor.service;

import com.ccicnavi.bims.customer.dao.Impl.SubLinkmanDaoImpl;
import com.ccicnavi.bims.customer.dao.SubLinkmanDao;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 20:36
 * @Description:
 */
public class SubcLinkmanTest{
    SubLinkmanDaoImpl subLinkmanDaoImpl = new SubLinkmanDaoImpl();
    /**
     * @Author FanDongSheng
     * @Description //TODO 新增联系人信息
     * @Date 20:52 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void insertSubcLinkman(){
        for (int i = 1; i <= 20; i++) {
            SubLinkmanDO subLinkmanDO = new SubLinkmanDO();
            subLinkmanDO.setLinkmanUuid("000000"+i);
            subLinkmanDO.setSubcUuid("000000100");
            subLinkmanDO.setLinkmanName("联系人名称" + i);
            subLinkmanDO.setGender("F");
            subLinkmanDO.setPhone("1314100013"+i);
            int count = subLinkmanDaoImpl.insertSubLinkman(subLinkmanDO,null);
            System.out.println("count-----" + count);
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 单个修改联系人信息
     * @Date 20:54 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void  updateSubcLinkman(){
        SubLinkmanDO subLinkmanDO = new SubLinkmanDO();
        subLinkmanDO.setLinkmanUuid("181125213417516366039202795520");
        subLinkmanDO.setLinkmanName("联系人改名称了");
        int count = subLinkmanDaoImpl.updateSubLinkman(subLinkmanDO,null);
        System.err.println(count);
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 删除联系人信息
     * @Date 20:57 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void deleteSubcLinkman(){

        SubLinkmanDTO subLinkmanDTO = new SubLinkmanDTO();
        subLinkmanDTO.setLinkmanUuids(subLinkmanDTO.getLinkmanUuids());
        Integer integer = subLinkmanDaoImpl.deleteSubLinkman(subLinkmanDTO, null);
        System.err.println(integer);


    }
    @Test
    public void getSubcLinkman(){
        SubLinkmanDO subLinkmanDO  = new SubLinkmanDO();
        subLinkmanDO.setLinkmanUuid("181126114612516580431408271360");
        SubLinkmanDO subLinkmanDO1 = subLinkmanDaoImpl.getSubLinkman(subLinkmanDO);
        System.err.println(subLinkmanDO1);
    }
}
