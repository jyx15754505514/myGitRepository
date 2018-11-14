package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.LinkmanService;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class LinkmanServiceImpl implements LinkmanService {

    @Resource
    LinkmanDao linkmanDao;

    @Override
    public List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) {
        return linkmanDao.listLinkman(linkmanDO);
    }

    @Override
    public int saveLinkman(LinkmanDO linkmanDO) {
        return linkmanDao.saveLinkman(linkmanDO);
    }

    @Override
    public int removeLinkman(String uuids) {
        return linkmanDao.removeLinkman(uuids);
    }

    @Override
    public int updateLinkman(LinkmanDO linkmanDO) {
        return linkmanDao.updateLinkman(linkmanDO);
    }

    @Override
    public LinkmanDO getLinkman(LinkmanDO linkmanDO) {
        return linkmanDao.getLinkman(linkmanDO);
    }
}
