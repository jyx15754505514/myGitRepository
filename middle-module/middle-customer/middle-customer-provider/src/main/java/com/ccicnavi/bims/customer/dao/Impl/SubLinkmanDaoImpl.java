package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.dao.SubLinkmanDao;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户联系人数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class SubLinkmanDaoImpl implements SubLinkmanDao {

    @Override
    public List<SubLinkmanDO> listLinkman(SubLinkmanDO subLinkmanDO) {
        return new Eql().select("listSubLinkman").params(subLinkmanDO).execute();
    }

    @Override
    public Integer saveLinkman(SubLinkmanDO subLinkmanDO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer removeLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }

    @Override
    public SubLinkmanDO getLinkman(SubLinkmanDO subLinkmanDO) {
        return new Eql().selectFirst("getSubLinkman").params(subLinkmanDO).returnType(SubLinkmanDO.class).execute();
    }

    @Override
    public PageBean<SubLinkmanDO> listCustomerPage(PageParameter<SubLinkmanDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SubLinkmanDO> linkmanList = new Eql().select("listSubLinkman").params(pageParameter.getParameter()).returnType(SubLinkmanDO.class).limit(page).execute();
        if(linkmanList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),linkmanList);
        }else {
            return null;
        }
    }


}
