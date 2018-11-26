package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 分包方资质信息dao接口
 *@author: WangYingLing
 *@create: 2018-11-14 23:33
 */

public interface SubcQualifiDao {

    /**
     *@Description: 查询全部分包方资质信息
     *@Param: [subcuQuali]
     *@return: List<SubcQualifiDO>
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    List<SubcQualifiDO> listSubcuQuali(SubcontractorDTO subcontractorDTO) throws Exception;

    /**
     *@Description: 新增分包方资质信息
     *@Param: [subcuQuali]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    Integer insertSubcuQuali(SubcQualifiDO subcuQuali) throws Exception;

    /**
     *@Description: 删除分包方资质信息
     *@Param: [subcQualifiUuid]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    Integer deleteSubcuQuali(SubcQualifiDTO subcQualifiDTO, EqlTran eqlTran) throws Exception;

    /**
     *@Description: 修改分包方资质信息
     *@Param: [subcuQuali]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    Integer updateSubcuQuali(SubcQualifiDO subcuQuali) throws Exception;

    /**
     *@Description: 查询分包方资质信息（根据主键获取）
     *@Param: [subcQuali]
     *@return: SubcQualifiDO
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) throws Exception;

}
