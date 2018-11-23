package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 15:25
 * @Description: 分包方银行信息
 */
public interface SubBankDao {
    /**
     * @Author FanDongSheng
     * @Description 分包方银行查询
     * @Date 15:10 2018/11/23
     * @Param [linkmanDO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    List<SubBankDO> listSubBank(SubcontractorDTO subcontractorDTO) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 保存分包方银行信息
     * @Date 15:10 2018/11/23
     * @Param [subBankDO, tran]
     * @Return int
     */
    Integer insertSubBank(SubBankDO subBankDO, EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 删除分包方银行
     * @Date 15:10 2018/11/23
     * @Param [subBankDO, tran]
     * @Return int
     */
    Integer deleteSubBank(SubBankDTO subBankDTO, EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description 更新银行信息
     * @Date 15:11 2018/11/23
     * @Param [subBankDO, tran]
     * @Return int
     */
    Integer updateSubBank(SubBankDO subBankDO,EqlTran tran) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description //TODO 得到单条银行信息
     * @Date 15:11 2018/11/23
     * @Param [subBankDO]
     * @Return com.ccicnavi.bims.customer.pojo.SubBankDO
     */
    SubBankDO getSubBank(SubBankDO subBankDO) throws Exception;
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方银行信息
     * @Date 15:11 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    PageBean<SubBankDO> listSubBankPage(PageParameter<SubBankDO> pageParameter) throws Exception;
}
