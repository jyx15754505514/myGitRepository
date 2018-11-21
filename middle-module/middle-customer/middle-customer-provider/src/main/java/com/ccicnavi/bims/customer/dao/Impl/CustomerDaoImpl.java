package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustomerDaoImpl implements CustomerDao {


    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) throws Exception{
        return new Eql().select("listCustomer").params(customer).returnType(CustomerDO.class).execute();
    }

    @Override
    public int saveCustomer(CustomerDO customer,EqlTran tran) throws Exception{
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertCustomer").params(customer).returnType(int.class).execute();
    }

    @Override
    public int removeCustomer(CustomerDO customer,EqlTran tran) throws Exception{
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteCustomer").params(customer).returnType(int.class).execute();
    }

    @Override
    public int updateCustomer(CustomerDO customer,EqlTran tran) throws Exception{
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateCustomer").params(customer).returnType(int.class).execute();
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customer) throws Exception{
        return new Eql().selectFirst("getCustomer").params(customer).returnType(CustomerDO.class).execute();
    }

    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertCustomer").params(customerDTO).returnType(int.class).execute();
    }


    @Override
    public int verifyCustInfoOnly(CustomerDO customer) throws Exception {
        return new Eql().selectFirst("verifyCustInfoOnly").params(customer).returnType(int.class).execute();
    }


    @Override
    public PageBean<CustomerDO> listCustomerPage(PageParameter<CustomerDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CustomerDO> custList = new Eql().select("listCustomer").params(pageParameter.getParameter()).returnType(CustomerDO.class).limit(page).execute();
        if(custList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custList);
        }else {
            return null;
        }
    }

    @Override
    public CustomerDTO getCustomerUuid(CustomerDO customer) throws Exception {
        return new Eql().selectFirst("getCustomer").params(customer).returnType(CustomerDTO.class).execute();
    }


}
