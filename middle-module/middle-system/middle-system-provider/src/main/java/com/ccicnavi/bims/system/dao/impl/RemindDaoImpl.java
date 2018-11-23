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
    public PageBean<RemindDTO> listRemind(PageParameter<RemindDTO> PageParameter){
        EqlPage page = new EqlPage(PageParameter.getStartIndex(),PageParameter.getPageRows());
        List<RemindDTO> list = new Eql().select("listsysremind").params(PageParameter.getParameter()).returnType(RemindDTO.class).limit(page).execute();
        return new PageBean<RemindDTO>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),list);
    }

    @Override
    public Integer insertRemind(RemindDTO sysremind,EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertsysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateRemind(RemindDTO sysremind,EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("updatesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRemind(RemindDTO sysremind,EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("deletesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public RemindDTO getRemind(RemindDTO sysremind){
        return new Eql().selectFirst("getsysremind").params(sysremind).returnType(RemindDTO.class).execute();
    }

    @Override
    public PageBean<RemindDTO> listRemindOrg(PageParameter<RemindDTO> PageParameter){
        EqlPage page = new EqlPage(PageParameter.getStartIndex(),PageParameter.getPageRows());
        List<RemindDTO> list = new Eql().select("listremindorg").params(PageParameter.getParameter()).returnType(RemindDTO.class).limit(page).execute();
        return new PageBean<RemindDTO>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),list);
    }

    @Override
    public List<RemindDTO> listRemindList(RemindDTO remind) {
        List<RemindDTO> list = new Eql().select("listsysremind").params(remind).returnType(RemindDTO.class).execute();
        return list;
    }
}
