package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户特殊需求信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */

public interface SpecialNeedService {

    /**查询全部客户特殊需求信息*/
    List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed);

    /**新增客户特殊需求信息*/
    int saveSpecialNeed(SpecialNeedDO specialNeed);

    /**删除客户特殊需求信息*/
    int removeSpecialNeed(String needUuid);

    /**修改客户特殊需求信息*/
    int updateSpecialNeed(SpecialNeedDO specialNeed);

    /**根据主键返回对应的客户特殊需求信息*/
    SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed);

    /**
     * 功能描述: 分页获取客户特殊需求
     * @param: pageParameter
     * @return: PageBean
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    PageBean<SpecialNeedDO> getSpecialNeedPage(PageParameter<SpecialNeedDO> pageParameter);

}
