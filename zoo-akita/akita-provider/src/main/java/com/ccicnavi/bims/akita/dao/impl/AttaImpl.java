package com.ccicnavi.bims.akita.dao.impl;

import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDO;
import com.ccicnavi.bims.akita.dao.AttaDao;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/24 14:14
 * @Version 0.1
 * @Description:
 */
@Service
@Slf4j
public class AttaImpl implements AttaDao {

    @Override
    public boolean insertAtta(AttaDO attaDO,AttaTmpDO attaTmpDO) {
        EqlTran eqlTran = new Eql().newTran();
        int execAttaCount = 0;
        int execAttaTmpCount = 0;
        try {
            execAttaCount = new Eql().useTran(eqlTran).insert("insertAtta").returnType(Integer.class).params(attaDO).execute();
            execAttaTmpCount = new Eql().useTran(eqlTran).insert("insertAttaTmp").returnType(Integer.class).params(attaTmpDO).execute();
            eqlTran.commit();
        } catch (Exception e) {
            log.error("", e);
            eqlTran.rollback();
            return false;
        } finally {
            Closes.closeQuietly(eqlTran);
        }
        return (execAttaCount > 0 && execAttaTmpCount > 0);
    }

    @Override
    public List<AttaDO> listAtta(String... businId) {
        List<AttaDO> attaDOList = null;
        try {
            attaDOList = new Eql().select("").returnType(AttaDO.class).execute();
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
        return attaDOList;
    }
}
