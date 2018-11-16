package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.RemindDao;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
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
    public List<RemindDO> listRemind(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").select("listsysremind").params(sysremind).returnType(RemindDO.class).execute();
    }

    @Override
    public Integer insertRemind(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertsysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateRemind(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("updatesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRemind(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("deletesysremind").params(sysremind).returnType(Integer.class).execute();
    }

    @Override
    public RemindDO getRemind(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getsysremind").params(sysremind).returnType(RemindDO.class).execute();
    }

    @Override
    public List<RemindDTO> listRemindOrg(RemindDO sysremind) throws Exception {
        return EqlUtils.getInstance("DEFAULT").select("listremindorg").params(sysremind).returnType(RemindDTO.class).execute();

    }
}
