package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @program: bims-backend
 * @description: 分包方信息controller
 * @author: WangYingLing
 * @create: 2018-11-16 09:39
 */

@RestController
@RequestMapping("/Subcontractor")
public class SubcontractorController {

    private final static Logger log= LoggerFactory.getLogger(SubcontractorController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20883")
    SubcontractorService subcontractorService;

    /**
     * @author: WangYingLing
     * @description: 查询分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        ResultT resultT=new ResultT();
        List<SubcontractorDO> subcontractorDOS=null;
        try {
            subcontractorDOS=subcontractorService.listSubcontractor(subcontractorDO);
        } catch (Exception e) {
            log.error("查询分包方信息失败",e);
            e.printStackTrace();
        }
        resultT.success(subcontractorDOS);
        return resultT;
    }

    /**
     * @author: WangYingLing
     * @description: 新增分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/saveSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        ResultT resultT=new ResultT();
        int count=0;
        try {
            count=subcontractorService.saveSubcontractor(subcontractorDO);
        } catch (Exception e) {
            log.error("新增分包方信息失败",e);
            e.printStackTrace();
        }
        return resultT;
    }

}
