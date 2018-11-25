package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.customer.api.SubcBankService;
import com.ccicnavi.bims.customer.dao.SubBankDao;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 22:38
 * @Description:
 */
@Slf4j
@Service
public class SubcBankServiceImpl implements SubcBankService {

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    @Autowired
    SubBankDao subBankDao;


    /**
     * @Author FanDongSheng
     * @Description 分包方下银行信息
     * @Date 22:39 2018/11/23
     * @Param [subBankDTO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    @Override
    public List<SubBankDO> listSubcBank(SubcontractorDTO subcontractorDTO) {
        List<SubBankDO> subBankDOList = null;
        try {
            subBankDOList =  subBankDao.listSubBank(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包方得银行信息",e);
        }
        return subBankDOList;
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方添加银行信息
     * @Date 22:39 2018/11/23
     * @Param [subBank]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcBank(SubBankDO subBank) {
        try {
            String subcBankUuid = idWorkerService.getId(new Date());
            subBank.setSubcBankUuid(subcBankUuid);
            return subBankDao.insertSubBank(subBank,null);
        } catch (Exception e) {
            log.error("插入分包方得银行信息",e);
            return null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方下删除指定得银行信息  支持批量删除
     * @Date 22:39 2018/11/23
     * @Param [subBankDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteSubcBank(SubBankDTO subBankDTO) {
        try {
            return subBankDao.deleteSubBank(subBankDTO,null);
        } catch (Exception e) {
            log.error("删除分包方得银行信息",e);
            return null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方下指定得银行信息修改
     * @Date 22:40 2018/11/23
     * @Param [subBank]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubcBank(SubBankDO subBank) {
        try {
            return subBankDao.updateSubBank(subBank,null);
        } catch (Exception e) {
            log.error("修改分包方得银行信息",e);
            return null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description 得到指定得银行信息
     * @Date 22:40 2018/11/23
     * @Param [subBank]
     * @Return com.ccicnavi.bims.customer.pojo.SubBankDO
     */
    @Override
    public SubBankDO getSubcBank(SubBankDO subBank) {
        try {
            return subBankDao.getSubBank(subBank);
        } catch (Exception e) {
            log.error("得到指定得分包方得银行信息",e);
            return null;
        }
    }
}
