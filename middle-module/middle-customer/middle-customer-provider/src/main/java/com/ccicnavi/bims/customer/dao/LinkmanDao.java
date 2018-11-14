package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.LinkmanDO;

import java.util.List;

public interface LinkmanDao {
    List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) throws Exception;

    int saveLinkman(LinkmanDO linkmanDO) throws Exception;

    int removeLinkman(String uuids) throws Exception;

    int updateLinkman(LinkmanDO linkmanDO) throws Exception;

    LinkmanDO getLinkman(LinkmanDO linkmanDO) throws Exception;
}
