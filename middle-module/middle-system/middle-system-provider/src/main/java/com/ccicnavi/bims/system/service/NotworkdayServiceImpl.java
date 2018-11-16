package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.dao.RoleDao;
import com.ccicnavi.bims.system.dao.impl.NotworkdayDaoImpl;
import com.ccicnavi.bims.system.dao.impl.RoleDaoImpl;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 非工作日api实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
public class NotworkdayServiceImpl implements NotworkdayService {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayDaoImpl.class);

    @Autowired
    private NotworkdayDao notworkdayDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.listNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) {
        EqlTran tran = new Eql("DEFAULT").newTran();
        try {
            return notworkdayDao.insertNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.updateNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.deleteNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.getNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }



    public Integer test(NotworkdayDO notworkday) {
        EqlTran tran = new Eql("DEFAULT").newTran();
        NotworkdayDaoImpl dao = new NotworkdayDaoImpl();
        RoleDaoImpl roled = new RoleDaoImpl();
        try {
            tran.start();
            Integer test = dao.test(notworkday, tran);
            RoleDO role = new RoleDO();
            role.setAppSysUuid("Test1");
            //role.setBusinessLine("Test1");
            role.setOrgUuid("1Test11");
            role.setRoleUuid("1Test1111");
            role.setRoleCode("Test1111");
            role.setIsSystem("Y");
            role.setRoleName("Testrole");
            role.setIsEnabled("Y");
            roled.test(role, tran);;
            tran.commit();
            return test;
        } catch (Exception e) {
            log.error("create service number bind info error: ", e);
            tran.rollback();
            return null;
        } finally {
            Closes.closeQuietly(tran);
        }
    }
}
