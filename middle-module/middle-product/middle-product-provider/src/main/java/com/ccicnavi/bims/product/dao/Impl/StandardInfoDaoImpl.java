package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.StandardInfoDao;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品标准信息
 * @author: lvqiru
 * @create: 2018-11-21 20:00
 */
@Service
public class StandardInfoDaoImpl implements StandardInfoDao {

    @Override
    public Integer insertStandardInfo(StandardInfoDTO psiDto) {
        return new Eql("DEFAULT").insert("insertStandardInfo").params(psiDto).execute();
    }

    @Override
    public Integer deleteStandarInfo(StandardInfoDTO psiDto) {
        return new Eql("DEFAULT").delete("deleteStandarInfo").params(psiDto).execute();
    }

    @Override
    public Integer updateStandarInfo(StandardInfoDTO psiDto) {
        return new Eql("DEFAULT").update("updateStandarInfo").params(psiDto).execute();
    }

    @Override
    public StandardInfoDO getStandardInfo(StandardInfoDTO psiDto) {
        return new Eql("DEFAULT").selectFirst("getStandardInfo").params(psiDto).returnType(StandardInfoDO.class).execute();
    }

    @Override
    public List<StandardInfoDO> listStandardInfo(StandardInfoDTO psiDto) {
        return new Eql("DEFAULT").select("listStandardInfo").params(psiDto).returnType(StandardInfoDO.class).execute();
    }

    @Override
    public PageBean<StandardInfoDO> listStandardInfoPage(PageParameter<StandardInfoDTO> pageParameter) {
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<StandardInfoDO> contractList = new Eql("DEFAULT").select("listStandardInfo").params(pageParameter.getParameter()).returnType(StandardInfoDO.class).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),contractList);
    }
}
