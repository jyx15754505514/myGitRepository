package com.ccicnavi.bims.akita.dao.impl;

import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;
import com.ccicnavi.bims.akita.dao.AttaDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

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
    public boolean insertAtta(AttaDO attaDO, AttaTmpDO attaTmpDO) {
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
    public List<AttaTmpDTO> listAtta(String... businId) {
        List<AttaTmpDTO> attaDOList = null;
        try {
            Map<String,Object> stringStringMap=new HashMap<>();
            stringStringMap.put("list", businId);
            attaDOList = new Eql().select("listAttaTmp").params(stringStringMap).returnType(AttaTmpDTO.class).execute();
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
        return attaDOList;
    }

    @Override
    public boolean deleteAtta(String id) {
        EqlTran eqlTran = new Eql().newTran();
        int execAttaCount = 0;
        int execAttaTmpCount = 0;
        try {
            execAttaCount = new Eql().useTran(eqlTran).delete("deleteAtta").returnType(Integer.class).params(id).execute();
            execAttaTmpCount = new Eql().useTran(eqlTran).delete("deleteAttaTmp").returnType(Integer.class).params(id).execute();
            eqlTran.commit();
        } catch (Exception e) {
            log.error("", e);
            eqlTran.rollback();
            return false;
        }finally {
            Closes.closeQuietly(eqlTran);
        }
        return (execAttaCount > 0 && execAttaTmpCount > 0);
    }
}
