package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;

import java.util.List;

public interface StandardInfoDao {

    /**
     *@Description: 新增产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    Integer insertStandardInfo(StandardInfoDTO psiDto) throws Exception;

    /**
     *@Description: 删除产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    Integer deleteStandarInfo(StandardInfoDTO psiDto) throws Exception;

    /**
     *@Description: 修改产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    Integer updateStandarInfo(StandardInfoDTO psiDto) throws Exception;

    /**
     *@Description: 查询产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    StandardInfoDO getStandardInfo(StandardInfoDTO psiDto) throws Exception;

    /**
     *@Description: 查询产品标准信息列表
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    List<StandardInfoDO> listStandardInfo(StandardInfoDTO psiDto) throws Exception;

    /**
     *@Description: 分页查询产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    PageBean<StandardInfoDO> listStandardInfoPage(PageParameter<StandardInfoDTO> pageParameter) throws Exception;
}
