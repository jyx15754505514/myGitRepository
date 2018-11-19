package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.OrganizationDO;
import com.ccicnavi.bims.system.service.api.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDao organizationDao;


    @Override
    public PageBean<OrganizationDO> listOrganization(PageParameter<OrganizationDO> pageParameter) {
        try {
            return organizationDao.listOrganization(pageParameter);
        } catch (Exception e) {
            log.error("组织机构列表获取失败" + e);
            return new PageBean<OrganizationDO>(0,0,0,0,0,new ArrayList<OrganizationDO>());
        }

    }


    @Override
    public Integer insertOrganization(OrganizationDO organizationDO) {
        try {
            return organizationDao.insertOrganization(organizationDO);
        } catch (Exception e) {
            log.error("组织机构对象新增失败" + e);
            return null;
        }
    }

    @Override
    public Integer updateOrganization(OrganizationDO organizationDO) {
        try {
            return organizationDao.updateOrganization(organizationDO);
        } catch (Exception e) {
            log.error("组织机构对象修改失败" + e);
            return null;
        }
    }

    @Override
    public Integer deleteOrganization(OrganizationDO organizationDO) {
        try {
            return organizationDao.deleteOrganization(organizationDO);
        } catch (Exception e) {
            log.error("组织机构对象删除失败" + e);
            return null;
        }
    }

    @Override
    public OrganizationDO getOrganization(OrganizationDO organizationDO) {
        try {
            return organizationDao.getOrganization(organizationDO);
        } catch (Exception e) {
            log.error("组织机构对象获取失败" + e);
            return null;
        }
    }


}
