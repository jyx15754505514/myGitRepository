package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 22:35
 * @Description:
 */
public interface SubcBankService {

    /**
     * @Author FanDongSheng
     * @Description //TODO 查询指定分包方下的银行信息
     * @Date 17:54 2018/11/23
     * @Param [subBank]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubBankDO>
     */
    List<SubBankDO> listSubcBank(SubcontractorDTO subcontractorDTO);

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行信息添加
     * @Date 22:03 2018/11/23
     * @Param [subBank]
     * @Return java.lang.Integer
     */
    Integer insertSubcBank(SubBankDO subBank);

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行删除 支持批量删除操作
     * @Date 22:18 2018/11/23
     * @Param [subBankDTO]
     * @Return java.lang.Integer
     */
    Integer deleteSubcBank(SubBankDTO subBankDTO) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 分包方银行修改
     * @Date 22:18 2018/11/23
     * @Param [subBank]
     * @Return java.lang.Integer
     */
    Integer updateSubcBank(SubBankDO subBank) ;

    /**
     * @Author FanDongSheng
     * @Description //TODO 根据分包方信息查看指定得银行信息
     * @Date 22:18 2018/11/23
     * @Param [subBank]
     * @Return com.ccicnavi.bims.customer.pojo.SubBankDO
     */
    SubBankDO getSubcBank(SubBankDO subBank) ;
}

