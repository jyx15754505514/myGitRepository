package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;

public interface PageDemoService {

    public PageBean<RoleDO> testPage(PageParameter<RoleDO> pageParameter);
}
