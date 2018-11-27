package com.ccicnavi.bims.akita.dao;

import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/24 10:59
 * @Version 0.1
 * @Description:
 */
public interface AttaDao {
    /**
     * 新增附件信息表
     * @param attaDO
     * @return
     */
    boolean insertAtta(AttaDO attaDO,AttaTmpDO attaTmpDO);


    List<AttaTmpDTO> listAtta(String... businId);

    boolean deleteAtta(String id);
}
