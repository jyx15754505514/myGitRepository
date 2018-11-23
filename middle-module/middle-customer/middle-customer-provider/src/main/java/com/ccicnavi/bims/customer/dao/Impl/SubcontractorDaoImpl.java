package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方分页查询添加
     * @Date 16:21 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public PageBean<SubcontractorDO> listSubcontractor(PageParameter<SubcontractorDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SubcontractorDO> subcontractorList = new Eql().select("listSubcontractor").params(pageParameter.getParameter()).returnType(SubcontractorDO.class).limit(page).execute();
        if(subcontractorList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),subcontractorList);
        }else {
            return null;
        }
    }
    /** *
     * @Author WangYingLing
     * @Description 新增分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().insert("insertSubcontractor").params(subcontractor).returnType(Integer.class).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public Integer removeSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().update("removeSubcontractor").params(subcontractor).returnType(Integer.class).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 修改分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubcontractor(SubcontractorDO subcontractor) {
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

    

