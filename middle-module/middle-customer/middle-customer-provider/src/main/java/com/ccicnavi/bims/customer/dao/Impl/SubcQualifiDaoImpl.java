package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import org.n3r.eql.Eql;
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
    public List<SubcQualifiDO> listSubcuQuali() {
        return new Eql().select("listSubcuQuali").execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [subcuQuali]
     * @Return java.lang.Integer
     */
    @Override
    public int saveSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().insert("saveSubcuQuali").params(subcuQuali).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public int removeSubcuQuali(String subcQualifiUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcQualifiUuid.split(","));
        return new Eql().update("removeSubcuQuali").params(data).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方资质信息
     * @Date 16:48 2018/11/14
     * @Param [subcuQuali]
     * @Return java.lang.Integer
     */
    @Override
    public int updateSubcuQuali(SubcQualifiDO subcuQuali) {
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
