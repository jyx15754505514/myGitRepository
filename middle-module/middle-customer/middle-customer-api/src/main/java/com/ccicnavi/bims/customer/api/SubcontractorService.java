package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */

public interface SubcontractorService {
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方信息
     * @Date 15:59 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    PageBean<SubcontractorDO> listSubcontractorPage(PageParameter<SubcontractorDO> pageParameter);

    /**
     * @Author FanDongSheng
     * @Description //TODO 新增分包方信息
     * @Date 16:15 2018/11/23
     * @Param [subcontractor]
     * @Return int
     */
    Integer insertSubcontractor(SubcontractorDO subcontractor) ;
    /**
     * @Author FanDongSheng
     * @Description //TODO 根据分包方信息查询分包方包含的所有的信息（资质、联系人、银行信息）
     * @Date 18:21 2018/11/23
     * @Param [subcontractorDTO]
     * @Return com.ccicnavi.bims.customer.pojo.SubcontractorDTO
     */
    SubcontractorDTO getSubcontractorList(SubcontractorDTO subcontractorDTO);




    /**删除分包方信息*/
    Integer removeSubcontractor(SubcontractorDTO subcontractorDTO) ;

    /**修改分包方信息*/
    Integer updateSubcontractor(SubcontractorDO subcontractor) ;

    /**根据主键返回对应的分包方信息*/
   SubcontractorDTO getSubcontractorOne(SubcontractorDTO subcontractorDTO) ;

}
