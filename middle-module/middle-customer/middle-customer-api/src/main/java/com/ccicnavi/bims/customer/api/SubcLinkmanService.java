package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 14:38
 * @Description: 分包方联系人
 */
public interface SubcLinkmanService {

    /**
     * @Author FanDongSheng
     * @Description //TODO 查询指定分包方下的联系人信息
     * @Date 17:54 2018/11/23
     * @Param [subLinkman]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    List<SubLinkmanDO> listSubcLinkman(SubcontractorDTO subcontractorDTO);

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方联系人信息添加
     * @Date 22:03 2018/11/23
     * @Param [subLinkman]
     * @Return java.lang.Integer
     */
    Integer insertSubcLinkman(SubLinkmanDO subLinkman);

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方联系人删除 支持批量删除操作
     * @Date 22:18 2018/11/23
     * @Param [subLinkmanDTO]
     * @Return java.lang.Integer
     */
    Integer deleteSubcLinkman(SubLinkmanDTO subLinkmanDTO) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方联系人修改
     * @Date 22:18 2018/11/23
     * @Param [subLinkman]
     * @Return java.lang.Integer
     */
    Integer updateSubcLinkman(SubLinkmanDO subLinkman) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 根据分包方信息查看指定得联系人信息
     * @Date 22:18 2018/11/23
     * @Param [subLinkman]
     * @Return com.ccicnavi.bims.customer.pojo.SubLinkmanDO
     */
    SubLinkmanDO getSubcLinkman(SubLinkmanDO subLinkman) ;

}
