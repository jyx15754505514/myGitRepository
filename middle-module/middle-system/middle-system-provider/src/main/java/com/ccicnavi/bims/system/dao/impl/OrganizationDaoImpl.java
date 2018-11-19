package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.OrganizationDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationDaoImpl implements OrganizationDao {
    /**
     * 列表查询（组织机构）
     */
    @Override
    public PageBean<OrganizationDO> listOrganization(PageParameter<OrganizationDO> pageParameter) throws Exception{
        EqlPage page = new EqlPage(pageParameter.getStartIndex(),pageParameter.getPageRows());
        List<OrganizationDO> OrganizationDOs = new Eql("DEFAULT").select("listOrganization").params(pageParameter.getParameter()).returnType(OrganizationDO.class).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),OrganizationDOs);
    }

    /**
     * 新增（组织机构）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer insertOrganization(OrganizationDO organizationDO) throws  Exception {
        Integer num = 0;
        EqlTran tran = new Eql("DEFAULT").newTran();
        try {
            tran.start();
            num = new Eql("DEFAULT").useTran(tran).useSqlFile("OrganizationDaoImpl.eql").select("insertOrganization").params(organizationDO).returnType(Integer.class).execute();
            tran.commit();
        }
        catch (Exception e) {
            //异常抛到service层处理
            tran.rollback();
            throw e;
        }
        finally {
            Closes.closeQuietly(tran);
        }

        return num;
    }

    /**
     * 更新（组织机构）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer updateOrganization(OrganizationDO organizationDO) throws  Exception {
        return new Eql().update("updateOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 删除（组织机构）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer deleteOrganization(OrganizationDO organizationDO) throws  Exception  {
        return new Eql().delete("deleteOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键或者名称获取（组织机构）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public OrganizationDO getOrganization(OrganizationDO organizationDO) throws  Exception {
        return new Eql().selectFirst("getOrganization").params(organizationDO).returnType(OrganizationDO.class).execute();
    }


}
