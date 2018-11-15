package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;

import java.util.List;

public interface PageDemoDao {

    public PageBean<RoleDO> testPage(PageParameter<RoleDO> pageParameter);

}
