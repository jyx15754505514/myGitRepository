package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.LinkmanService;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户联系人数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class LinkmanServiceImpl implements LinkmanService {

    @Autowired
    LinkmanDao linkmanDao;

    @Override
    public List<LinkmanDO> listLinkman(LinkmanDO linkmanDO) {
        try {
            return linkmanDao.listLinkman(linkmanDO);
        } catch (Exception e) {
            log.error("查询客户联系人信息失败~", e);
            return null;
        }
    }

    @Override
    public int saveLinkman(LinkmanDO linkmanDO) {
        try {
            return linkmanDao.saveLinkman(linkmanDO,null);
        } catch (Exception e) {
            log.error("保存客户联系人信息失败~", e);
            return 0;
        }
    }

    @Override
    public int removeLinkman(LinkmanDO linkmanDO) {
        try {
            return linkmanDao.removeLinkman(linkmanDO,null);
        } catch (Exception e) {
            log.error("删除客户联系人信息失败~", e);
        }
        return 0;
    }

    @Override
    public int updateLinkman(LinkmanDO linkmanDO) {
        try {
            return linkmanDao.updateLinkman(linkmanDO,null);
        } catch (Exception e) {
            log.error("修改客户联系人信息失败~", e);
            return 0;
        }
    }

    @Override
    public LinkmanDO getLinkman(LinkmanDO linkmanDO) {
        try {
            return linkmanDao.getLinkman(linkmanDO);
        } catch (Exception e) {
            log.error("根据主键查询客户联系人信息失败~", e);
            return null;
        }
    }

    @Override
    public PageBean<LinkmanDO> listLinkmanPage(PageParameter<LinkmanDO> pageParameter) {
        try {
            return linkmanDao.listCustomerPage(pageParameter);
        } catch (Exception e) {
            log.error("服务端客户联系人分页查询失败");
            return null;
        }
    }
}
