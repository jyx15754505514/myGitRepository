package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.dao.SubBankDao;
import com.ccicnavi.bims.customer.dao.SubLinkmanDao;
import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * @Author WangYingling
 * @Description 分包方信息ServiceImpl
 * @Date 19:59 2018/11/14
 */

@Service
@Slf4j
public class SubcontractorServiceImpl implements SubcontractorService{

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    @Autowired
    SubcontractorDao subcontractorDao;

    @Autowired
    SubcQualifiDao subcQualifiDao;

    @Autowired
    SubBankDao subBankDao;

    @Autowired
    SubLinkmanDao subLinkmanDao;

    /**
     * @Author FanDongSheng
     * @Description 分页查询分包方信息
     * @Date 16:16 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public PageBean<SubcontractorDO> listSubcontractorPage(PageParameter<SubcontractorDO> pageParameter) {
        try {
            return subcontractorDao.listSubcontractor(pageParameter);
        } catch (Exception e) {
            log.error("分包方分页查询失败",e);
            return null;
        }
    }

    /**
     * @Author FanDongSheng
     * @Description 新增分包方信息
     * @Date 16:16 2018/11/23
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcontractor(SubcontractorDO subcontractor) {
        try {
            String subcontractorUuid = idWorkerService.getId(new Date());
            subcontractor.setSubcontractorUuid(subcontractorUuid);
           return subcontractorDao.insertSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("Service层新增分包方信息失败",e);
            return  null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description 根据分包方信息查询分包方包含的所有的信息（资质、联系人、银行信息）
     * @Date 18:22 2018/11/23
     * @Param [subcontractorDTO]
     * @Return com.ccicnavi.bims.customer.pojo.SubcontractorDTO
     */
    @Override
    public SubcontractorDTO getSubcontractorList(SubcontractorDTO subcontractorDTO){
        try {
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
            return subcontractorDTO;
        } catch (Exception e) {
            log.error("根据分包方信息查询资质、联系人、银行等信息失败",e);
            return  null;
        }
    }

    /**
     * @Author WangYingling
     * @Description 删除分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractorDTO
     * @return java.lang.Integer
     */
    @Override
    public Integer removeSubcontractor(SubcontractorDTO subcontractorDTO ) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Integer count=0;
        SubLinkmanDTO subLinkmanDTO = new SubLinkmanDTO();
        SubcQualifiDTO subcQualifiDTO = new SubcQualifiDTO();
        SubBankDTO subBankDTO = new SubBankDTO();
        try {
            eqlTran.start();
            /**删除分包方信息**/
            count=subcontractorDao.removeSubcontractor(subcontractorDTO, eqlTran);
            /**删除联系人 根据分包方主键删除所有得联系人*/
            subLinkmanDTO.setSubcUuids(subcontractorDTO.getSubcontractorUuids());
            Integer linkMan = subLinkmanDao.deleteSubLinkman(subLinkmanDTO,eqlTran);
            /**删除资质信息*/
            subcQualifiDTO.setSubcUuids(subcontractorDTO.getSubcontractorUuids());
            Integer subcuQuali = subcQualifiDao.deleteSubcuQuali(subcQualifiDTO, eqlTran);
            /**删除分包方银行*/
            subBankDTO.setSubcUuids(subcontractorDTO.getSubcontractorUuids());
            Integer subBank = subBankDao.deleteSubBank(subBankDTO, eqlTran);
            if(count>=0 && count !=null){
                eqlTran.commit();
                return count;
            }
        } catch (Exception e) {
            log.error("Service层删除分包方信息失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return -1;
    }

    /**
     * @Author WangYingling
     * @Description 修改分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return java.lang.Integer
     */
    @Override
    public Integer updateSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.updateSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("Service层修改分包方信息失败",e);
        }
        return count;
    }

    /**
     * @Author FanDongSheng
     * @Description //查询单个分包方信息不包含其余的信息
     * @Date 18:39 2018/11/23
     * @Param [subcontractorDTO]
     * @Return com.ccicnavi.bims.customer.pojo.SubcontractorDTO
     */
    @Override
    public SubcontractorDTO getSubcontractorOne(SubcontractorDTO subcontractorDTO) {
        SubcontractorDTO subcontractorBean=null;
        try {
            subcontractorBean=subcontractorDao.getSubcontractor(subcontractorDTO);
        } catch (Exception e) {
            log.error("Service层查询分包方信息失败",e);
        }
        return subcontractorBean;
    }
}
