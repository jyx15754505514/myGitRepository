package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;

import java.util.List;

public interface LinkmanDao {
    List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) throws Exception;

    int saveLinkman(LinkmanDO linkmanDO) throws Exception;

    int removeLinkman(LinkmanDO linkmanDO) throws Exception;

    int updateLinkman(LinkmanDO linkmanDO) throws Exception;

    LinkmanDO getLinkman(LinkmanDO linkmanDO) throws Exception;

    PageBean<LinkmanDO> listCustomerPage(PageParameter<LinkmanDO> pageParameter) throws Exception;
}
