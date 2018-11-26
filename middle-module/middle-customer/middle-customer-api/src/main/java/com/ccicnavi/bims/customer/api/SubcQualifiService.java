package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方资质接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */

public interface SubcQualifiService {

    /**
     * @Author FanDongSheng
     * @Description //TODO 查询指定分包方下的资质信息
     * @Date 17:54 2018/11/23
     * @Param [subcQuali]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcQualifiDO>
     */
    List<SubcQualifiDO> listSubcQuali(SubcontractorDTO subcontractorDTO) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方资质信息添加
     * @Date 22:05 2018/11/23
     * @Param [subcQuali]
     * @Return java.lang.Integer
     */
    Integer insertSubcQuali(SubcQualifiDO subcQuali) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 删除分包方资质信息
     * @Date 22:25 2018/11/23
     * @Param [subcQuali]
     * @Return java.lang.Integer
     */
    Integer deleteSubcQuali(SubcQualifiDTO subcQualifiDTO, EqlTran eqlTran) ;

    /**修改分包方资质信息*/
    Integer updateSubcQuali(SubcQualifiDO subcQuali) ;

    /**根据主键返回对应的分包方资质信息*/
    SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) ;

}
