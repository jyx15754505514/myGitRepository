package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.MinItemDO;
import com.ccicnavi.bims.product.pojo.MinItemDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项接口定义
 * @author: LiJie
 * @create: 2018-11-19 21:25
 */
public interface MinItemDao {
    List<MinItemDO> listMinItem(MinItemDTO minItemDTO) throws Exception;

    int saveMinItem(MinItemDO minItem) throws Exception;

    int removeMinItem(MinItemDTO minItemDTO) throws Exception;

    int updateMinItem(MinItemDO minItem) throws Exception;

    MinItemDO getMinItem(MinItemDO minItem) throws Exception;

    PageBean<MinItemDO> listMinItemPage(PageParameter<MinItemDTO> pageParameter) throws Exception;
}
