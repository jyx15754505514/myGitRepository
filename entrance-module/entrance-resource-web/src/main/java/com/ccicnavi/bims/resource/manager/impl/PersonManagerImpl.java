package com.ccicnavi.bims.resource.manager.impl;

import com.ccicnavi.bims.resource.manager.PersonManager;
import com.ccicnavi.bims.resource.pojo.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

@Slf4j
public class PersonManagerImpl implements PersonManager {



    @Override
    public Integer insertPersonAndPersonTeach(PersonDTO personDTO) {

        EqlTran tran = new Eql("matrix").newTran();
        try {
            tran.start();
            new Eql("matrix").useTran(tran).useSqlFile("").insert("").params("").execute();
            new Eql("matrix").useTran(tran).useSqlFile("").insert("").params("").execute();
            tran.commit();
        } catch (Exception e) {
            log.error("",e);
            tran.rollback();
        }
        return null;
    }
}
