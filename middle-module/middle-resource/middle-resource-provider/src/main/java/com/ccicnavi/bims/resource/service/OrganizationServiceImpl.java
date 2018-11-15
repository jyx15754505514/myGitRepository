package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.OrganizationService;
import com.ccicnavi.bims.resource.dao.OrganizationDao;
import com.ccicnavi.bims.resource.pojo.OrganizationDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    
    @Autowired
    OrganizationDao organizationDao;


    @Override
    public List<OrganizationDO> listOrganizationDO(OrganizationDO organizationDO) {
        List<OrganizationDO> organizationDOList = null;
        try {
            organizationDOList = organizationDao.listOrganizationDO(organizationDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("组织机构列表获取失败" + e);
        }
        return organizationDOList;
    }

    @Override
    public Integer insertOrganizationDO(OrganizationDO organizationDO) {
        Integer num = 0;
        try {
            num = organizationDao.insertOrganizationDO(organizationDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("组织机构对象新增失败" + e);
        }
        return num;
    }

    @Override
    public Integer updateOrganizationDO(OrganizationDO organizationDO) {
        Integer num = null;
        try {
            num = organizationDao.updateOrganizationDO(organizationDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("组织机构对象修改失败" + e);
        }
        return num;
    }

    @Override
    public Integer deleteOrganizationDO(OrganizationDO organizationDO) {
        Integer num = null;
        try {
            num = organizationDao.deleteOrganizationDO(organizationDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("组织机构对象删除失败" + e);
        }
        return num;
    }

    @Override
    public OrganizationDO getOrganizationDO(OrganizationDO organizationDO) {
        OrganizationDO organization = new OrganizationDO();
        try {
            return organizationDao.getOrganizationDO(organizationDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("组织机构对象获取失败" + e);
        }
        return organization;
    }


}
