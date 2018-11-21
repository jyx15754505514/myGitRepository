package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.SerialnumDao;
import com.ccicnavi.bims.system.pojo.*;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 17:22
 * @Description:
 */
@Service
public class SerialnumDaoImpl implements SerialnumDao {

    @Override
    public PageBean<SerialnumCfgDO> listSerialnumCfg(PageParameter<SerialnumCfgDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<SerialnumCfgDO> serialnumCfgList = new Eql("DEFAULT").select("listSerialnumCfg").params(pageParameter.getParameter()).returnType(SerialnumCfgDO.class).limit(page).execute();
        if(serialnumCfgList != null){
            return new PageBean<>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), serialnumCfgList);
        }else{
            return null;
        }
    }

    @Override
    public SerialnumCfgDO getSerialnumCfg(SerialQueryDTO serialQueryDTO) {
        Object execute = new Eql("DEFAULT").selectFirst("getSerialnumCfg").params(serialQueryDTO).returnType(SerialnumCfgDO.class).execute();
        return (SerialnumCfgDO) execute;
    }

    @Override
    public Integer insertSerialnumCfg(SerialnumCfgDO serialnumCfgDO) {
        return new Eql("DEFAULT").insert("insertSerialnumCfg").params(serialnumCfgDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateSerialnumCfg(SerialnumCfgDO serialnumCfgDO) {
        return new Eql("DEFAULT").update("updateSerialnumCfg").params(serialnumCfgDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteSerialnumCfg(String sncUuid) {
        return new Eql("DEFAULT").update("deleteSerialnumCfg").params(sncUuid).returnType(Integer.class).execute();
    }

    @Override
    public SerialnumCfgItemDO getSerialnumCfgItem(String sncUuid) {
        return new Eql("DEFAULT").selectFirst("getSerialnumCfgItem").params(sncUuid).returnType(SerialnumCfgItemDO.class).execute();
    }

    @Override
    public Integer insertSerialnumCfgItem(SerialnumCfgItemDO serialnumCfgItemDO) {
        return new Eql("DEFAULT").insert("insertSerialnumCfgItem").params(serialnumCfgItemDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteSerialnumCfgItem(String sncUuid) {
        return new Eql("DEFAULT").update("deleteSerialnumCfgItem").params(sncUuid).returnType(Integer.class).execute();
    }

    @Override
    public List<SerialnumCfgItemDO> getSeriItemList(String sncUuid) {
        return new Eql("DEFAULT").select("getSeriItemList").params(sncUuid).returnType(SerialnumCfgItemDO.class).execute();
    }

    @Override
    public SerialnumDO getSerialnumDO(SerialnumDO serialnumDO) {
        return new Eql("DEFAULT").selectFirst("getSerialnumDO").params(serialnumDO).returnType(SerialnumDO.class).execute();
    }

    @Override
    public Integer insertSerialnum(SerialnumDO serialnumDO){
        return new Eql("DEFAULT").insert("insertSerialnum").params(serialnumDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateSerialnum(SerialnumDO serialnumDO){
        return new Eql("DEFAULT").update("updateSerialnum").params(serialnumDO).returnType(Integer.class).execute();
    }
}
