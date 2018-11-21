package com.ccicnavi.bims.customer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    CustomerExtDao customerExtDao;
    @Autowired
    CustAddrDao custAddrDao;
    @Autowired
    LinkmanDao linkmanDao;

    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) {
        try {
            return customerDao.listCustomer(customer);
        } catch (Exception e) {
            log.error("查询客户信息失败~", e);
            return Collections.emptyList();
        }
    }

    @Override
    public int saveCustomer(CustomerDO customer) {
        try {
            return customerDao.saveCustomer(customer,null);
        } catch (Exception e) {
            log.error("保存客户信息失败~", e);
            return 0;
        }
    }

    @Override
    public int removeCustomer(CustomerDO customer) {
        int num =0;
        try {
            num=customerDao.removeCustomer(customer,null);//删除客户基本信息
        } catch (Exception e) {
            log.error("删除客户信息失败~", e);
        }
        return num;
    }

    @Override
    public int updateCustomer(CustomerDO customer) {
        try {
            return customerDao.updateCustomer(customer,null);
        } catch (Exception e) {
            log.error("修改客户信息失败~", e);
            return 0;
        }
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customerDO) {
        try {
            return customerDao.getCustomer(customerDO);
        } catch (Exception e) {
            log.error("根据主键查询客户信息失败~", e);
            return new CustomerDO();
        }
    }

    /**
     * 保存客户信息与客户公司注册信息
     *
     * @param customerDTO
     * @return
     */
    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO) {
        EqlTran tran = new Eql().newTran();
        Integer saveCust = 0;
        Integer saveCustExt = 0;
        try {
            tran.start();
            saveCust = customerDao.saveCustomerAndExt(customerDTO, tran);//新增客户基本信息
            if (saveCust > 0 ) {
                tran.commit();
                return saveCust;
            }
        } catch (Exception e) {
            log.error("新增客户信息与客户公司注册信息失败~");
            tran.rollback();
        } finally {
            Closes.closeQuietly(tran);//关闭事物
        }
        return saveCust;
    }

    /**
     * 客户信息唯一性验证
     *
     * @param customer
     * @return
     */
    @Override
    public ResultT verifyCustInfoOnly(CustomerDO customer) {
        boolean flag = true;
        Integer count =0;
        try {
            //验证客户名称
            if(!StringUtils.isEmpty(customer.getCustName())){
                count = customerDao.verifyCustInfoOnly(customer);
                if (count > 0) {
                    return ResultT.failure(ResultCode.CUST_NAME_REPEAT);
                }
            }
            customer.setCustName(null);//清空客户名称，避免以下验证受影响
            //验证客户代码
            if (!StringUtils.isEmpty(customer.getCustCode())) {
                count = customerDao.verifyCustInfoOnly(customer);
                if (count > 0) {
                    return ResultT.failure(ResultCode.CUST_CODE_REPEAT);
                }
            }
            customer.setCustCode(null);
            //验证客户统一社会信用代码
            if (!StringUtils.isEmpty(customer.getCustUscc())) {
                count = customerDao.verifyCustInfoOnly(customer);
                if (count > 0) {
                    return ResultT.failure(ResultCode.CUST_USCC_REPEAT);
                }
            }
        } catch (Exception e) {
            log.error("客户信息唯一性验证失败~");
            e.printStackTrace();
            return ResultT.failure(ResultCode.VERIFY_CUSTINFO_ONLY_FAILURE);
        }
        return ResultT.success("可用");
    }

    /**
     * 客户分页信息展示
     *
     * @param pageParameter
     * @return
     */
    @Override
    public PageBean<CustomerDO> listCustomerPage(PageParameter<CustomerDO> pageParameter) {
        try {
            return customerDao.listCustomerPage(pageParameter);
        } catch (Exception e) {
            log.error("服务端客户分页查询失败");
            return null;
        }
    }

    @Override
    public CustomerDTO getCustomerUuid(CustomerDO customer) {
        try {
            CustomerDTO customerDTO = customerDao.getCustomerUuid(customer);
            if(customerDTO!=null &&!StringUtils.isEmpty(customerDTO.getCustUuid())){
                CustAddrDO custAddrDO = new CustAddrDO();
                custAddrDO.setCustUuid(customer.getCustUuid());
                //查询地址信息
                List<CustAddrDO> listAddr = custAddrDao.listCustAddr(custAddrDO);
                LinkmanDO linkmanDO = new LinkmanDO();
                linkmanDO.setCustUuid(customer.getCustUuid());
                //查询联系人信息
                List<LinkmanDO> listMan = linkmanDao.listLinkman(linkmanDO);
                customerDTO.setLinkmanList(listMan);
                customerDTO.setCustAddrList(listAddr);
            }
            return customerDTO;
        } catch (Exception e) {
            log.error("根据客户uuid查询客户信息失败",e);
            return null;
        }

    }


}
