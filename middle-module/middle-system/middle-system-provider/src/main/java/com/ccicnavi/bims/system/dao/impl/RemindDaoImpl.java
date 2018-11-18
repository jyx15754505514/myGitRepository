package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RemindDao;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
import org.n3r.eql.Eql;

import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置dao实现类
 * @author: zqq
 * @create: 2018-11-15 09:37
 */
@Service
public class RemindDaoImpl implements RemindDao {

    @Override
    public PageBean<RemindDO> listRemind(PageParameter<RemindDO> PageParameter){
        EqlPage page = new EqlPage(PageParameter.getStartIndex(),PageParameter.getPageRows());
        List<RemindDO> list = new Eql().select("listsysremind").params(PageParameter.getParameter()).returnType(RemindDO.class).limit(page).execute();
        return new PageBean<RemindDO>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),list);
    }

    @Override
    public Integer insertRemind(RemindDO sysremind){
        return new Eql().insert("insertsysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateRemind(RemindDO sysremind){
        return new Eql().insert("updatesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRemind(RemindDO sysremind){
        return new Eql().insert("deletesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public RemindDO getRemind(RemindDO sysremind){
        return new Eql().selectFirst("getsysremind").params(sysremind).returnType(RemindDO.class).execute();
    }

    @Override
    public PageBean<RemindDTO> listRemindOrg(PageParameter<RemindDO> PageParameter){
        EqlPage page = new EqlPage(PageParameter.getStartIndex(),PageParameter.getPageRows());
        List<RemindDTO> list = new Eql().select("listremindorg").params(PageParameter.getParameter()).returnType(RemindDTO.class).limit(page).execute();
        return new PageBean<RemindDTO>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),list);
    }
}
