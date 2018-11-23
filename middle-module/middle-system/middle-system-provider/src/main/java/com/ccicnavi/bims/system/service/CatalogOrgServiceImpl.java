package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.CatalogOrgDao;
import com.ccicnavi.bims.system.pojo.CatalogOrgDO;
import com.ccicnavi.bims.system.pojo.CatalogOrgDTO;
import com.ccicnavi.bims.system.service.api.CatalogOrgService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 11:34
 */
@Service
@Slf4j
public class CatalogOrgServiceImpl implements CatalogOrgService {

    @Autowired
    CatalogOrgDao catalogOrgDao;

    /**
     * @Author guojinxu
     * @Description  产品线与组织机构关系
     * @Date 2018/11/21 11:46
     * @Param [catalogOrgDO]
     * @return java.util.List<com.ccicnavi.bims.product.pojo.CatalogOrgDO>
     **/
    @Override
    public List<CatalogOrgDO> listCatalogOrgDO(CatalogOrgDO catalogOrgDO) {
        try {
            return catalogOrgDao.listCatalogOrgDO(catalogOrgDO);
        } catch (Exception e) {
            log.error("查询产品线与组织机构关系失败",e);
            return null;
        }
    }

    /**
     * @Author guojinxu
     * @Description  更新产品线与组织机构关系
     * @Date 2018/11/21 11:47
     * @Param [catalogOrgDO]
     * @return int
     **/
    @Override
    public int updateCatalogOrgDO(CatalogOrgDTO catalogOrgDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        eqlTran.start();
        try {
            int count = 0;
            CatalogOrgDO catalogOrgDO = new CatalogOrgDO();
            //以组织机构id进行更新
            if(catalogOrgDTO.getOrganizationUuid()!=null && !"".equals(catalogOrgDTO.getOrganizationUuid())){
                catalogOrgDO.setOrganizationUuid(catalogOrgDTO.getOrganizationUuid());
                catalogOrgDao.removeCatalogOrgDO(catalogOrgDO, eqlTran);
                String[] catalogUuidList = catalogOrgDTO.getCatalogUuidList().split(",");
                for(int i = 0;catalogUuidList!=null&&i<catalogUuidList.length;i++){
                    if(StringUtils.isEmpty(catalogUuidList[i])){
                        continue;
                    }
                    CatalogOrgDO catalogOrgDO1 = new CatalogOrgDO();
                    catalogOrgDO1.setAppSysUuid(catalogOrgDTO.getAppSysUuid());
                    catalogOrgDO1.setOrganizationUuid(catalogOrgDTO.getOrganizationUuid());
                    catalogOrgDO1.setProdCatalogUuid(catalogUuidList[i]);
                    count += catalogOrgDao.saveCatalogOrgDO(catalogOrgDO1,eqlTran);
                }
            }
            //以产品线id进行更新
            if(catalogOrgDTO.getProdCatalogUuid()!=null && !"".equals(catalogOrgDTO.getProdCatalogUuid())){
                catalogOrgDO.setProdCatalogUuid(catalogOrgDTO.getProdCatalogUuid());
                catalogOrgDao.removeCatalogOrgDO(catalogOrgDO,eqlTran);
                String[] orgUuidList = catalogOrgDTO.getOrgUuidList().split(",");
                for(int i = 0;orgUuidList!=null&&i<orgUuidList.length;i++){
                    if(StringUtils.isEmpty(orgUuidList[i])){
                        continue;
                    }
                    CatalogOrgDO catalogOrgDO1 = new CatalogOrgDO();
                    catalogOrgDO1.setAppSysUuid(catalogOrgDTO.getAppSysUuid());
                    catalogOrgDO1.setOrganizationUuid(orgUuidList[i]);
                    catalogOrgDO1.setProdCatalogUuid(catalogOrgDTO.getProdCatalogUuid());
                    count += catalogOrgDao.saveCatalogOrgDO(catalogOrgDO1,eqlTran);
                }
            }
            eqlTran.commit();
            return count;
        } catch (Exception e) {
            log.error("更新产品线与组织机构关系失败",e);
            eqlTran.rollback();
            return 0;
        }finally {
            eqlTran.close();
        }
    }

}
