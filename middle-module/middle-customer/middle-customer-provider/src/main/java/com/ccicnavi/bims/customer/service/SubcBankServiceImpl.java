package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.api.SubcBankService;
import com.ccicnavi.bims.customer.dao.SubBankDao;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 22:38
 * @Description:
 */
@Slf4j
public class SubcBankServiceImpl implements SubcBankService {
    @Autowired
    SubBankDao subBankDao;
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方下银行信息
     * @Date 22:39 2018/11/23
     * @Param [subBankDTO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    @Override
    public List<SubBankDO> listSubcBank(SubcontractorDTO subcontractorDTO) {
        try {
            return subBankDao.listSubBank(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包方得银行信息",e);
            return null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方添加银行信息
     * @Date 22:39 2018/11/23
     * @Param [subBank]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcBank(SubBankDO subBank) {
        try {
            return subBankDao.insertSubBank(subBank,null);
        } catch (Exception e) {
            log.error("插入分包方得银行信息",e);
            return null;
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方下删除指定得银行信息  支持批量删除
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
     * @Description //TODO 分包方下指定得银行信息修改
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
     * @Description //TODO 得到指定得银行信息
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
