package com.ccicnavi.bims.akita.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.akita.api.AkitaService;
import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;
import com.ccicnavi.bims.akita.dao.AttaDao;
import com.ccicnavi.bims.akita.utils.FileUtils;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Auther: husky
 * @Date: 2018/11/20 17:56
 * @Version 0.1
 * @Description:
 */
@Service
@Slf4j
public class AkitaServiceImpl implements AkitaService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private TrackerClient trackerClient;

//    @Reference(url = "dubbo://192.168.125.12:20880")
    @Reference
    IdWorkerService idWorkerService;

    @Autowired
    AttaDao attaDao;

    @Override
    public boolean upload(EnclosureVO enclosureVO) {
        String attaId = idWorkerService.getId(new Date());
        String attaTmpId = idWorkerService.getId(new Date());
        try {
            InputStream inputStream = FileUtils.byte2Input(enclosureVO.getFile());
            StorePath storePath = fastFileStorageClient.uploadFile(inputStream, enclosureVO.getLength(), FilenameUtils.getExtension(enclosureVO.getFileOldName()), null);
            AttaDO attaDO = new AttaDO(attaId, storePath.getFullPath(), enclosureVO.getFileOldName(), enclosureVO.getExt(), "", storePath.getGroup(), enclosureVO.getCreateBy(), enclosureVO.getRemark());
            AttaTmpDO attaTmpDO = new AttaTmpDO(attaTmpId, enclosureVO.getBusinId(), attaId, enclosureVO.getRemark());
            boolean insertAtta = attaDao.insertAtta(attaDO, attaTmpDO);
            if (insertAtta) {
                return true;
            }
        } catch (Exception e) {
            log.error("",e);
        } finally {

        }
        return false;
    }

    @Override
    public List<AttaTmpDTO> listAtta(String... businId) {
        List<AttaTmpDTO> attaDOS = attaDao.listAtta(businId);
        return attaDOS;
    }

    @Override
    public void delete(AttaDO attaDO) {
        fastFileStorageClient.deleteFile(attaDO.getFileNewName());
        attaDao.deleteAtta(attaDO.getId());
    }


}
