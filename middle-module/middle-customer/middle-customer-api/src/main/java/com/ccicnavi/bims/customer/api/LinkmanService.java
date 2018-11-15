package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户联系人接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface LinkmanService {

    /**查询全部客户联系人信息*/
    List<LinkmanDO> listLinkman(LinkmanDO linkmanDO);

    /**新增客户联系人信息*/
    int saveLinkman(LinkmanDO linkmanDO);

    /**删除客户联系人信息*/
    int removeLinkman(String uuids);

    /**修改客户联系人信息*/
    int updateLinkman(LinkmanDO linkmanDO);

    /**根据主键获取对应信息*/
    LinkmanDO getLinkman(LinkmanDO linkmanDO);

}
