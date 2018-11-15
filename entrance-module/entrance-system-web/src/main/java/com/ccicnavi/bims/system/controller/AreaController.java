package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.service.api.AreaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Reference(url = "dubbo://127.0.0.1:20881")
    AreaService areaService;

    /* *
     * @Author MengZiJie
     * @Description 查询地区
     * @Date 21:46 2018/11/15
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping("listArea")
    public ResultT listArea(@RequestBody AreaDO areaDO){
        ResultT resultT = new ResultT();
        List<AreaDO> areaDOS = areaService.listArea(areaDO);
        resultT.success(areaDOS);
        return resultT;
    }

}
