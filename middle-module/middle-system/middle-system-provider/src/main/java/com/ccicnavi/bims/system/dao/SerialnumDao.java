package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.*;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 17:22
 * @Description:
 */
public interface SerialnumDao {
    /**查询所有的地区*/
    PageBean<SerialnumCfgDO> listSerialnumCfg(PageParameter<SerialnumCfgDO> pageParameter);
    /**获取编号规则配置信息*/
    SerialnumCfgDO getSerialnumCfg(SerialQueryDTO serialQueryDTO);
    /**新增编号规则配置信息*/
    Integer insertSerialnumCfg(SerialnumCfgDO serialnumCfgDO);
    /**更新编号规则配置信息*/
    Integer updateSerialnumCfg(SerialnumCfgDO serialnumCfgDO);
    /**删除编号规则配置信息*/
    Integer deleteSerialnumCfg(String sncUuid);

    /**获取编号规则配置项信息*/
    SerialnumCfgItemDO getSerialnumCfgItem(String itemUuid);
    /**新增编号规则配置项信息*/
    Integer insertSerialnumCfgItem(SerialnumCfgItemDO serialnumCfgItemDO);
    /**删除编号规则配置项信息*/
    Integer deleteSerialnumCfgItem(String itemUuid);

    /**
     *
     * 功能描述: 根据规则uuid查询规则项，并排序
     *
     * @param: serialnumUuid
     * @return: List<SerialnumCfgItemDO>
     * @date:  2018/11/20 17:22
     * @auther: CongZhiYuan
     */
    List<SerialnumCfgItemDO> getSeriItemList(String sncUuid);
    /**
     * 根据业务编号、机构编号、原业务编号查询编号信息。包括当前序号
     */
    SerialnumDO getSerialnumDO(SerialnumDO serialnumDO);

    /**新增规则编号信息*/
    Integer insertSerialnum(SerialnumDO serialnumDO);
    /**修改规则编号信息*/
    Integer updateSerialnum(SerialnumDO serialnumDO);
}
