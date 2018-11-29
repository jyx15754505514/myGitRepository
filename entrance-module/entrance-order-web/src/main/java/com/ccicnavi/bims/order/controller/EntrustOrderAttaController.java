package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.akita.api.AkitaService;
import com.ccicnavi.bims.akita.common.pojo.EnclosureVO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaDO;
import com.ccicnavi.bims.akita.common.pojo.domain.AttaTmpDTO;
import com.ccicnavi.bims.akita.utils.FileUtils;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/EntrustOrderAtta")
public class EntrustOrderAttaController {

    @Reference(timeout = 30000)
    private AkitaService akitaService;

    /**
     * 上传委托单附件信息
     * @Author lvqiru
     * @Date  2018/11/28 20:00
     * @Param file 文件流 businId 业务编码 createBy 上传人 createTime 上传时间
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "/uploadAttachmentInfo", method = RequestMethod.POST)
    public ResultT updateAttachmentInfo(@RequestParam(value = "file") MultipartFile file, String businId, String createBy, String createTime) {
        log.info("开始上传附件信息 Param: " + "业务编号:" + businId + " 上传人:" + createBy + " 上传时间: " + createTime  + " Time: " + new Date());
        try {
            if (null == file) {
                log.error("上传文件获取异常");
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            if (StringUtils.isEmpty(createBy) || StringUtils.isEmpty(businId)) {
                log.error("入参为空");
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }

            EnclosureVO enclosure = new EnclosureVO();
            enclosure.setRemark("委托单上传附件");
            enclosure.setFileOldName(file.getOriginalFilename());
            enclosure.setBusinId(businId);
            enclosure.setLength(file.getSize());
            enclosure.setFile(FileUtils.input2byte(file.getInputStream()));
            System.out.println(file.getOriginalFilename());
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            enclosure.setExt(ext);
            boolean flag = akitaService.upload(enclosure);
            if (flag) {
                log.info("附件上传成功 文件名: " + file.getOriginalFilename());
                return ResultT.success("附件上传成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.error("附件上传异常");
        return ResultT.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }

    /**
     * 委托单附件信息列表
     * @Author lvqiru
     * @Date  2018/11/28 20:00
     * @Param businId 业务编码
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "/listAttachmentInfo", method = RequestMethod.POST)
    public ResultT listAttachmentInfo(String businId) {
        log.info("开始查询附件信息列表 Param: " + "业务编号:" + businId + " Time: " + new Date());
        try {
            if (StringUtils.isEmpty(businId)) {
                log.error("业务编码为空");
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }

            List<AttaTmpDTO> attaTmpDTOS = akitaService.listAtta(businId);
            if (attaTmpDTOS != null) {
                log.info("查询附件信息列表结果: " + JSON.toJSONString(attaTmpDTOS));
                return ResultT.success(attaTmpDTOS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.error("查询附件信息列表异常");
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 移除委托单附件信息
     * @Author lvqiru
     * @Date  2018/11/28 20:00
     * @Param attachId 附件编码 attachNp path编码
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "/removeAttachmentInfo", method = RequestMethod.POST)
    public ResultT removeAttachmentInfo(String attachId, String attachNp) {
        log.info("开始移除附件信息 Param: " + "附件编码:" + attachId + " Time: " + new Date());
        try {
            if (StringUtils.isEmpty(attachId) || StringUtils.isEmpty(attachNp)) {
                log.error("参数为空");
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            AttaDO attaDO = new AttaDO();
            attaDO.setId(attachId);
            attaDO.setFileNewName(attachNp);
            akitaService.delete(attaDO);
            log.info("移除附件信息成功");
            return ResultT.success("移除附件信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.error("移除附件信息异常");
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }
}
