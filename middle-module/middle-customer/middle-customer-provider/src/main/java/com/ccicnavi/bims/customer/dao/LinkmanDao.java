package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import org.n3r.eql.EqlTran;

import java.util.List;

public interface LinkmanDao {
    List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) throws Exception;

    int saveLinkman(LinkmanDO linkmanDO, EqlTran tran) throws Exception;

    int removeLinkman(LinkmanDO linkmanDO,EqlTran tran) throws Exception;

    int updateLinkman(LinkmanDO linkmanDO,EqlTran tran) throws Exception;

    LinkmanDO getLinkman(LinkmanDO linkmanDO) throws Exception;

    PageBean<LinkmanDO> listCustomerPage(PageParameter<LinkmanDO> pageParameter) throws Exception;
}
