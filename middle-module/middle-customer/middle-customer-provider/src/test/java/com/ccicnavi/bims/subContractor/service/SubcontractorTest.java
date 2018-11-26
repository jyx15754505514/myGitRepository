package com.ccicnavi.bims.subContractor.service;

import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.Impl.SubBankDaoImpl;
import com.ccicnavi.bims.customer.dao.Impl.SubLinkmanDaoImpl;
import com.ccicnavi.bims.customer.dao.Impl.SubcQualifiDaoImpl;
import com.ccicnavi.bims.customer.dao.Impl.SubcontractorDaoImpl;
import com.ccicnavi.bims.customer.pojo.*;
import com.ccicnavi.bims.customer.util.EqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 分包方信息测试
 * @author: WangYingLing
 * @create: 2018-11-16 14:21
 */
@Slf4j
public class SubcontractorTest {

    SubcontractorDaoImpl subcontractorDaoTest=new SubcontractorDaoImpl();
    SubcontractorDaoImpl subcontractorDao=new SubcontractorDaoImpl();
    SubcQualifiDaoImpl subcQualifiDao=new SubcQualifiDaoImpl();
    SubBankDaoImpl subBankDao=new SubBankDaoImpl();
    SubLinkmanDaoImpl subLinkmanDao=new SubLinkmanDaoImpl();
    /**
     * @Author FanDongSheng
     * @Description //TODO 新增分包方信息
     * @Date 17:25 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void insertSubcontractor() {
        for (int i = 1; i <= 300; i++) {
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            subcontractorDO.setSubcontractorUuid("8888" + i);
            subcontractorDO.setSubcCode("分包方代码" + i);
            subcontractorDO.setLegalRep("法人" + i);
            subcontractorDO.setRegCapital("注册资本"+i);
            subcontractorDO.setName("分包方名称"+i);
            subcontractorDO.setEnName("分包方英文名称"+i);
            subcontractorDO.setAppSysUuid("BIMS");
            subcontractorDO.setOrgUuid("CCIC");
            subcontractorDO.setCreatedUuid("fands");
            subcontractorDO.setCreatedName("樊东升");
            int count = subcontractorDaoTest.insertSubcontractor(subcontractorDO);
            System.out.println("count-----" + count);
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方信息
     * @Date 17:26 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void listSubcontractor() {
        try{
            PageParameter<SubcontractorDO> pageParameter = new PageParameter<>();
            pageParameter.startPage = 1;
            pageParameter.pageRows = 2;
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            pageParameter.setParameter(subcontractorDO);
            subcontractorDaoTest.listSubcontractor(pageParameter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   
    /**
     * @Author FanDongSheng
     * @Description //TODO 修改分包方信息
     * @Date 17:42 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void testUpdateSubcontractor() {
        SubcontractorDO subcontractorDO = new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("0000001");
        subcontractorDO.setName("分包方名称修改啦~");
        int count = subcontractorDaoTest.updateSubcontractor(subcontractorDO);
        System.out.println(count);
    }

    /**
     * @Author FanDongSheng
     * @Description //TODO 删除分包方信息
     * @Date 17:42 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void removeSubcontractor() {
        EqlTran eqlTran = new Eql().newTran();
        /**联系人对象*/
        SubLinkmanDTO subLinkmanDTO = new SubLinkmanDTO();
        SubcQualifiDTO subcQualifiDTO = new SubcQualifiDTO();
        SubBankDTO subBankDTO = new SubBankDTO();
        try {
            eqlTran.start();
            SubcontractorDTO subcontractorDTO=new SubcontractorDTO();
            subcontractorDTO.setSubcontractorUuid("181125202847516349557563592704");
            /**删除分包方信息*/
            Integer integer = subcontractorDaoTest.removeSubcontractor(subcontractorDTO, eqlTran);
            System.out.println("删除分包方信息为："+integer);
            /**删除联系人*/
            subLinkmanDTO.setSubcUuid(subcontractorDTO.getSubcontractorUuid());
            Integer linkMan = subLinkmanDao.deleteSubLinkman(subLinkmanDTO,eqlTran);
            System.out.println("删除联系人为："+linkMan);
            /**删除资质信息*/
            subcQualifiDTO.setSubcUuid(subcontractorDTO.getSubcUuid());
            Integer subcuQuali = subcQualifiDao.deleteSubcuQuali(subcQualifiDTO, eqlTran);
            System.out.println("资质信息为："+subcuQuali);
            /**删除分包方银行*/
            subBankDTO.setSubcUuid(subcontractorDTO.getSubcontractorUuid());
            Integer subBank = subBankDao.deleteSubBank(subBankDTO, eqlTran);
            System.out.println("银行信息为："+subcuQuali);
            eqlTran.commit();
        } catch (Exception e){
            log.error("删除失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }

    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 查询一条分包方信息以及相应的资质联系人银行信息
     * @Date 17:45 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void getSubcontractorList() {
        try{
            SubcontractorDTO subcontractorDTO = new SubcontractorDTO();
            subcontractorDTO.setSubcUuid("000000100");
            //得到分包方信息
            subcontractorDTO = subcontractorDao.getSubcontractor(subcontractorDTO);
            //添加资质信息
            List<SubcQualifiDO> subcQualifiDOList = subcQualifiDao.listSubcuQuali(subcontractorDTO);
            subcontractorDTO.setSubcQualifiDOList(subcQualifiDOList);
            //添加银行的信息
            List<SubBankDO> subBankList = subBankDao.listSubBank(subcontractorDTO);
            subcontractorDTO.setSubBankDOList(subBankList);
            //添加联系人信息
            List<SubLinkmanDO> subLinkmanDOList = subLinkmanDao.listSubLinkman(subcontractorDTO);
            subcontractorDTO.setSubLinkmanDOList(subLinkmanDOList);
            System.out.println(subcontractorDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
