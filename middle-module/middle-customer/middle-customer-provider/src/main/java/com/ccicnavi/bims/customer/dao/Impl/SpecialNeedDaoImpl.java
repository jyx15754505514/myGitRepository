package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WangYingLing
 * @Description 客户特殊需求信息DaoImpl
 * @Date 16:48 2018/11/14
 */

@Service
public class SpecialNeedDaoImpl implements SpecialNeedDao {

    /** *
     * @Author WangYingLing
     * @Description 查询所有客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SpecialNeedDO>
     */
    @Override
    public List<SpecialNeedDO> listSpecialNeed() {
        return new Eql().select("listSpecialNeed").execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.lang.Integer
     */
    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        System.out.println(specialNeed);
        return new Eql().insert("saveSpecialNeed").params(specialNeed).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public int removeSpecialNeed(String needUuid) {
        Map<String, Object> data = new HashMap<>();
        data.put("ids", needUuid.split(","));
        return new Eql().update("removeSpecialNeed").params(data).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 修改客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.lang.Integer
     */
    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        return new Eql().update("updateSpecialNeed").params(specialNeed).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 查询客户特殊需求信息（根据主键获取）
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return com.ccicnavi.bims.customer.pojo.SpecialNeedDO
     */
    @Override
    public SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed) {
        return new Eql().select("getSpecialNeed").params(specialNeed).execute();
    }

}
