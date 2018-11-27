package com.ccicnavi.bims.akita.api;

import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;

import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/20 11:26
 * @Version 0.1
 * @Description:
 */
public interface AkitaService {

    /**
     * 上传文件
     *
     * @param enclosureVO
     * @return true=上传成功,false=上传失败
     */
    boolean upload(EnclosureVO enclosureVO);

    /**
     * 根据业务ID查询关联文件
     * @param businId 业务ID,可多个
     * @return
     */
    List<AttaTmpDTO> listAtta(String... businId);

    /**
     * 删除文件
     *
     */
    void delete(AttaDO attaDO);
}
