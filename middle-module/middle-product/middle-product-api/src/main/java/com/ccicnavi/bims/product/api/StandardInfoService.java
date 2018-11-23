package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线标准信息接口定义
 * @author: lvqiru
 * @create: 2018-11-21 20:00
 */
public interface StandardInfoService {

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
    Integer deleteStandarInfo(StandardInfoDTO psiDto);

    /**
     *@Description: 修改产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    Integer updateStandarInfo(StandardInfoDTO psiDto);

    /**
     *@Description: 查询产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    StandardInfoDO getStandardInfo(StandardInfoDTO psiDto);

    /**
     *@Description: 查询产品标准信息列表
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    List<StandardInfoDO> listStandardInfo(StandardInfoDTO psiDto);

    /**
     *@Description: 分页查询产品标准信息
     *@Param: ProductStandardInfoDo
     *@return: Integer
     *@Author: lvqiru
     *@date: 2018/11/21
     */
    PageBean<StandardInfoDO> listStandardInfoPage(PageParameter<StandardInfoDTO> pageParameter);


}
