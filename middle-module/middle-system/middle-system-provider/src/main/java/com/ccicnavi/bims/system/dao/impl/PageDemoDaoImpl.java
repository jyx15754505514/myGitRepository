package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.PageDemoDao;
import com.ccicnavi.bims.system.pojo.LogDetailDO;
import com.ccicnavi.bims.system.pojo.RoleDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PageDemoDaoImpl implements PageDemoDao {

    public PageBean<RoleDO> testPage(PageParameter<RoleDO> pageParameter){
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<RoleDO> roleDOS = EqlUtils.getInstance("DEFAULT").id("testPage").params(pageParameter.getParameter()).returnType(RoleDO.class).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),roleDOS);
    }


}
