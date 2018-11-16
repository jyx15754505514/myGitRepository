package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.MenuDO;
import com.ccicnavi.bims.system.service.api.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/15 22:33
 * @Description:
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    //url 指定dubbo的地址
    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private MenuService menuService;

    /**
     * 功能描述: 根据条件查询菜单
     * @param: emnu
     * @return: ResultT
     * @auther: fandongsheng
     * @date: 2018/11/15 23:14
     */
    @RequestMapping(value = "/listMenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT ListMenu(@RequestBody MenuDO emnu) {
        try {
            List<MenuDO> emnuList = menuService.listMenu(emnu);
            //请求成功返回并设置返回数据
            return ResultT.success(emnuList);
        }catch (Exception e) {
            log.error("根据条件查询菜单失败", e);
            //请求失败返回并设置错误信息
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
