package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustAddrService;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户地址基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustAddrServiceImpl implements CustAddrService {


    @Autowired
    CustAddrDao custAddrDao;

    @Override
    public List<CustAddrDO> listCustAddr(CustAddrDO custAddr) {
        try {
              return custAddrDao.listCustAddr(custAddr);
        } catch (Exception e) {
              log.error("查询客户地址信息失败",e);
              return null;
        }
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        try {
            return custAddrDao.saveCustAddr(custAddr,null);
        } catch (Exception e) {
            log.error("保存客户地址信息失败",e);
            return 0;
        }

    }

    @Override
    public int removeCustAddr(CustAddrDO custAddr) {
        try {
            return custAddrDao.removeCustAddr(custAddr,null);
        } catch (Exception e) {
            log.error("删除客户地址信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        try {
            return custAddrDao.updateCustAddr(custAddr,null);
        } catch (Exception e) {
            log.error("修改客户地址信息失败",e);
            return 0;
        }
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO custAddrDO) {
        try {
            return custAddrDao.getCustAddr(custAddrDO);
        } catch (Exception e) {
            log.error("根据主键查询客户地址信息失败",e);
            return null;
        }
    }

    /**
     * 分页查询客户地址
     * @param pageParameter
     * @return
     */
    @Override
    public PageBean<CustAddrDO> listCustAddrPage(PageParameter<CustAddrDO> pageParameter) {
        try {
            return custAddrDao.listCustAddrPage(pageParameter);
        } catch (Exception e) {
            log.error("客户地址信息查询失败");
            return null;
        }
    }


}
