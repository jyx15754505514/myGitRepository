package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WangYingLing
 * @Description 分包方资质信息DaoImpl
 * @Date 16:48 2018/11/14
 */

@Service
public class SubcQualifiDaoImpl implements SubcQualifiDao {

    /** *
     * @Author WangYingLing
     * @Description 查询所有分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [subcuQuali]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcQualifiDO>
     */
    @Override
    public List<SubcQualifiDO> listSubcuQuali(SubcontractorDTO subcontractorDTO) {
        return new Eql().select("listSubcuQuali").params(subcontractorDTO).returnType(SubcontractorDTO.class).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [subcuQuali]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().insert("insertSubcuQuali").params(subcuQuali).returnType(Integer.class).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteSubcuQuali(SubcQualifiDTO subcQualifiDTO, EqlTran eqlTran) {
        return new Eql().update("deleteSubcuQuali").params(subcQualifiDTO).returnType(Integer.class).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [subcuQuali]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().update("updateSubcuQuali").params(subcuQuali).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 查询分包方资质信息（根据主键获取）
     * @Date 16:48 2018/11/14
     * @Param [subcQuali]
     * @Return com.ccicnavi.bims.customer.pojo.SubcQualifiDO
     */
    @Override
    public SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) {
        return new Eql().selectFirst("getSubcQuali").params(subcQuali).returnType(SubcQualifiDO.class).execute();
    }

}
