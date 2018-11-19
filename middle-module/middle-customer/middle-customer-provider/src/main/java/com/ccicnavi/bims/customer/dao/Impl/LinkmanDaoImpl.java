package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户联系人数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class LinkmanDaoImpl implements LinkmanDao {

    @Override
    public List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) {
        return new Eql().select("listLinkman").params(linkmanDO).execute();
    }

    @Override
    public int saveLinkman(LinkmanDO linkmanDO) {
        return new Eql().insert("insertLinkman").params(linkmanDO).returnType(int.class).execute();
    }

    @Override
    public int removeLinkman(LinkmanDO linkmanDO) {
        return new Eql().update("deleteLinkman").params(linkmanDO).returnType(int.class).execute();
    }

    @Override
    public int updateLinkman(LinkmanDO linkmanDO) {
        return new Eql().update("updateLinkman").params(linkmanDO).returnType(int.class).execute();
    }

    @Override
    public LinkmanDO getLinkman(LinkmanDO linkmanDO) {
        return new Eql().selectFirst("getLinkman").params(linkmanDO).returnType(LinkmanDO.class).execute();
    }

    @Override
    public PageBean<LinkmanDO> listCustomerPage(PageParameter<LinkmanDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<LinkmanDO> linkmanList = new Eql().select("listLinkman").params(pageParameter.getParameter()).returnType(LinkmanDO.class).limit(page).execute();
        if(linkmanList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),linkmanList);
        }else {
            return null;
        }
    }


}
