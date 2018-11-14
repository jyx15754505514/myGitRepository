package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.LinkmanDO;

import java.util.List;

public interface LinkmanDao {
    List<LinkmanDO> listLinkman(LinkmanDO linkmanDO);

    int saveLinkman(LinkmanDO linkmanDO);

    int removeLinkman(String uuids);

    int updateLinkman(LinkmanDO linkmanDO);

    LinkmanDO getLinkman(LinkmanDO linkmanDO);
}
