package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.LinkmanService;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Slf4j
public class LinkmanServiceImpl implements LinkmanService {

    @Autowired
    LinkmanDao linkmanDao;

    @Override
    public List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) {
        List<LinkmanDO> linkmanList=null;
        try {
            linkmanList=linkmanDao.listLinkman(linkmanDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户联系人信息失败~",e);
        }
        return linkmanList;
    }

    @Override
    public int saveLinkman(LinkmanDO linkmanDO) {
        Integer count=0;
        try {
            count=linkmanDao.saveLinkman(linkmanDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户联系人信息失败~",e);
        }
        return count;
    }

    @Override
    public int removeLinkman(String uuids) {
        Integer count=0;
        try {
            count=linkmanDao.removeLinkman(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户联系人信息失败~",e);
        }
        return count;
    }

    @Override
    public int updateLinkman(LinkmanDO linkmanDO) {
        Integer count=0;
        try {
            count=linkmanDao.updateLinkman(linkmanDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户联系人信息失败~",e);
        }
        return count;
    }

    @Override
    public LinkmanDO getLinkman(LinkmanDO linkmanDO) {
        LinkmanDO linkman=null;
        try {
            linkman=linkmanDao.getLinkman(linkmanDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户联系人信息失败~",e);
        }
        return linkman;
    }
}
