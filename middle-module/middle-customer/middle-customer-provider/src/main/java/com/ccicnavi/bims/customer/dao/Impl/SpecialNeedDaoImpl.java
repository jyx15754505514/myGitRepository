package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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
        return new Eql().selectFirst("getSpecialNeed").params(specialNeed).returnType(SpecialNeedDO.class).execute();
    }

    /**
     *@Description: 分页查询客户特殊需求信息
     *@Param: PageBean
     *@return: SpecialNeedDO
     *@Author: congzhiyuan
     *@date: 2018/11/27
     */
    @Override
    public PageBean<SpecialNeedDO> getSpecialNeedPage(PageParameter<SpecialNeedDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SpecialNeedDO> custList = new Eql().select("getSpecialNeed").params(pageParameter.getParameter()).returnType(SpecialNeedDO.class).limit(page).execute();
        if(custList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custList);
        }else {
            return null;
        }
    }
}
