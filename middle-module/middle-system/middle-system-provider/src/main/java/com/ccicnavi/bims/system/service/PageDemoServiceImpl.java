package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.PageDemoDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.service.api.PageDemoService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlPage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PageDemoServiceImpl implements PageDemoService {

    @Autowired
    PageDemoDao pageDemoDao;

    @Override
    /**
     * 入参格式如下：
     * {
     * 	"pageRows": 2,
     * 	"parameter": {
     * 		"roleCode": "2"
     *        },
     * 	"startIndex": 0,
     * 	"startPage": 1
     * }
     *
     *
     * 出参格式如下：
     * {
     * 	"pageNumber": 1,
     * 	"pageSize": 2,
     * 	"products": [{
     * 		"appSysUuid": "",
     * 		"businessLine": "",
     * 		"isDeleted": "N",
     * 		"isEnabled": "Y",
     * 		"isSystem": "N",
     * 		"orgUuid": "",
     * 		"roleCode": "2",
     * 		"roleName": "王二麻子",
     * 		"roleUuid": "3",
     * 		"updatedTime": 1542258619000
     *        }, {
     * 		"appSysUuid": "",
     * 		"businessLine": "",
     * 		"isDeleted": "N",
     * 		"isEnabled": "Y",
     * 		"isSystem": "N",
     * 		"orgUuid": "",
     * 		"roleCode": "2",
     * 		"roleName": "赵五",
     * 		"roleUuid": "4",
     * 		"updatedTime": 1542258621000
     *    }],
     * 	"startIndex": 0,
     * 	"total": 2,
     * 	"totalPage": 1
     * }
     */
    public PageBean<RoleDO> testPage(PageParameter<RoleDO> pageParameter) {
        try {
            return pageDemoDao.testPage(pageParameter);
        } catch (Exception e) {
            log.error("{}",e);
            return new PageBean<RoleDO>(0,0,0,0,0,new ArrayList<RoleDO>());
        }
    }
}
