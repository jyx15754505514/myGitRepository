package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.SerialQueryDTO;
import com.ccicnavi.bims.system.pojo.SerialnumCfgDO;
import com.ccicnavi.bims.system.pojo.SerialnumCfgDTO;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 17:52
 * @Description:
 */
public interface SerialnumService {
    /**查询所有的地区*/
    PageBean<SerialnumCfgDO> listSerialnumCfg(PageParameter<SerialnumCfgDO> pageParameter) throws Exception;
    /**获取编号规则配置信息*/
    SerialnumCfgDO getSerialnumCfg(SerialQueryDTO serialQueryDTO) throws Exception;
    /**新增编号规则配置信息*/
    void addSerialnumCfg(SerialnumCfgDTO serialnumCfgDTO) throws Exception;
    /**更新编号规则配置信息*/
    Integer updateSerialnumCfg(SerialnumCfgDTO serialnumCfgDTO) throws Exception;
    /**删除编号规则配置信息*/
    Integer deleteSerialnumCfg(String sncUuid) throws Exception;
    /**
     * 根据业务规则uuid生成业务编号
     * */
    String getBusSerialnumNo(String sncUuid) throws Exception;
    /**
     * 特殊情况需原业务编号生成业务编号
     * 如证书修改、作废生成新证书编号等
     * */
    String getBusSerialnumNo(String sncUuid, String busUuid) throws Exception;
}
