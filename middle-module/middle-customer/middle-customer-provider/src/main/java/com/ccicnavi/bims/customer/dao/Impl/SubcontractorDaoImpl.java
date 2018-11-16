package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WangYingLing
 * @Description 分包方信息DaoImpl
 * @Date 16:48 2018/11/14
 */

@Service
public class SubcontractorDaoImpl implements SubcontractorDao {

    /** *
     * @Author WangYingLing
     * @Description 查询所有分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public List<SubcontractorDO> listSubcontractor() {
        
        return new Eql().select("listSubcontractor").execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().insert("saveSubcontractor").params(subcontractor).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcontractorUuid.split(","));
        return new Eql().update("removeSubcontractor").params(data).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 修改分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().update("updateSubcontractor").params(subcontractor).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 查询分包方信息（根据主键获取）
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return com.ccicnavi.bims.customer.pojo.SubcontractorDO
     */
    @Override
    public SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().selectFirst("getSubcontractor").params(subcontractor).returnType(SubcontractorDO.class).execute();

    }

}

    

