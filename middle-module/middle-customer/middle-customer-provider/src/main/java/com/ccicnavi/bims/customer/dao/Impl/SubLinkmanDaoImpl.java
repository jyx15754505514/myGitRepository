package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.LinkmanDao;
import com.ccicnavi.bims.customer.dao.SubLinkmanDao;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方联系人
 * @author: fandongsheng
 * @create: 2018-11-23 15:29
 */
@Service
public class SubLinkmanDaoImpl implements SubLinkmanDao {
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方联系人信息
     * @Date 15:29 2018/11/23
     * @Param [subLinkmanDO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    @Override
    public List<SubLinkmanDO> listSubLinkman(SubLinkmanDO subLinkmanDO) {
        return new Eql().select("listSubLinkman").params(subLinkmanDO).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 保存分包方联系人信息
     * @Date 15:31 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer saveSubLinkman(SubLinkmanDO subLinkmanDO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 删除分包方联系人信息
     * @Date 15:31 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer removeSubLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 更新分包方联系人信息
     * @Date 15:32 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateSubLinkman").params(subLinkmanDO).returnType(Integer.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 得到指定分包方联系人详细信息
     * @Date 15:32 2018/11/23
     * @Param [subLinkmanDO]
     * @Return com.ccicnavi.bims.customer.pojo.SubLinkmanDO
     */
    @Override
    public SubLinkmanDO getSubLinkman(SubLinkmanDO subLinkmanDO) {
        return new Eql().selectFirst("getSubLinkman").params(subLinkmanDO).returnType(SubLinkmanDO.class).execute();
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方联系人分页查询
     * @Date 15:33 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    @Override
    public PageBean<SubLinkmanDO> listSubLinkmanPage(PageParameter<SubLinkmanDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SubLinkmanDO> linkmanList = new Eql().select("listSubLinkman").params(pageParameter.getParameter()).returnType(SubLinkmanDO.class).limit(page).execute();
        if(linkmanList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),linkmanList);
        }else {
            return null;
        }
    }


}
