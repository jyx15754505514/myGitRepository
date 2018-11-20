package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.MinItemDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface MinItemService {

    /**查询全部最小服务项信息*/
    List<MinItemDO> listMinItem(MinItemDO minItem);

    /**新增最小服务项信息*/
    int saveMinItem(MinItemDO minItem);

    /**删除最小服务项信息*/
    int removeMinItem(MinItemDO minItem);

    /**修改最小服务项信息*/
    int updateMinItem(MinItemDO minItem);

    /**根据主键返回对应最小服务项信息*/
    MinItemDO getMinItem(MinItemDO minItem);

    /**分页查询最小服务项信息*/
    PageBean<MinItemDO> listMinItemPage(PageParameter<MinItemDO> pageParameter);

}
