package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 15:08
 * @Description: 分包方联系人DAO
 */
public interface SubLinkmanDao {
    /**
     * @Author FanDongSheng
     * @Description 分包方联系人查询
     * @Date 15:10 2018/11/23
     * @Param [linkmanDO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    List<SubLinkmanDO> listLinkman(SubLinkmanDO subLinkmanDO) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 保存分包方联系人信息
     * @Date 15:10 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return int
     */
    Integer saveLinkman(SubLinkmanDO subLinkmanDO, EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 删除分包方联系人
     * @Date 15:10 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return int
     */
    Integer removeLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 更新联系人信息
     * @Date 15:11 2018/11/23
     * @Param [subLinkmanDO, tran]
     * @Return int
     */
    Integer updateLinkman(SubLinkmanDO subLinkmanDO,EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description //TODO 得到单条联系人信息
     * @Date 15:11 2018/11/23
     * @Param [subLinkmanDO]
     * @Return com.ccicnavi.bims.customer.pojo.SubLinkmanDO
     */
    SubLinkmanDO getLinkman(SubLinkmanDO subLinkmanDO) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方联系人信息
     * @Date 15:11 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    PageBean<SubLinkmanDO> listCustomerPage(PageParameter<SubLinkmanDO> pageParameter) throws Exception;
}
