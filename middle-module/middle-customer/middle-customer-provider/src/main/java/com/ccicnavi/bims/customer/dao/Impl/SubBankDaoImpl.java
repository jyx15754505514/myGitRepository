package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.SubBankDao;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 15:27
 * @Description: 分包方银行信息
 */
@Service
public class SubBankDaoImpl implements SubBankDao {
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行信息查询
     * @Date 15:34 2018/11/23
     * @Param [subBankDO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    @Override
    public List<SubBankDO> listSubBank(SubcontractorDTO subcontractorDTO) throws Exception {
        return new Eql().select("listSubBank").params(subcontractorDTO).returnType(SubBankDO.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行信息保存
     * @Date 15:34 2018/11/23
     * @Param [subBankDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubBank(SubBankDO subBankDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertSubBank").params(subBankDO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行信息删除
     * @Date 15:34 2018/11/23
     * @Param [subBankDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteSubBank(SubBankDTO subBankDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteSubBank").params(subBankDTO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行信息修改
     * @Date 15:34 2018/11/23
     * @Param [subBankDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubBank(SubBankDO subBankDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateSubBank").params(subBankDO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 得到指定分包方银行信息
     * @Date 15:34 2018/11/23
     * @Param [subBankDO]
     * @Return com.ccicnavi.bims.customer.pojo.SubBankDO
     */
    @Override
    public SubBankDO getSubBank(SubBankDO subBankDO) throws Exception {
        return new Eql().selectFirst("getSubBank").params(subBankDO).returnType(SubBankDO.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方银行信息
     * @Date 15:34 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    @Override
    public PageBean<SubBankDO> listSubBankPage(PageParameter<SubBankDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SubBankDO> linkmanList = new Eql().select("listSubLinkman").params(pageParameter.getParameter()).returnType(SubBankDO.class).limit(page).execute();
        if(linkmanList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),linkmanList);
        }else {
            return null;
        }
    }
}
