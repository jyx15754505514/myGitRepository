package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuDO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import com.ccicnavi.bims.system.service.api.MenuButtonService;
import com.ccicnavi.bims.system.service.api.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
//    @Reference(url = "dubbo://127.0.0.1:20881", timeout = 5000)
    @Reference
    private MenuService menuService;


//    @Reference(url = "dubbo://127.0.0.1:20881", timeout = 5000)
    @Reference
    private MenuButtonService menuButtonService;
    /**
     * 功能描述: 根据条件查询菜单
     * @param: emnu
     * @return: ResultT
     * @auther: fandongsheng
     * @date: 2018/11/15 23:14
     */
    @RequestMapping(value = "/listMenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listMenu(@RequestBody MenuDO emnu) {
        try {
            ResultT listMenu =  menuService.listMenu(emnu);
            //请求成功返回并设置返回数据
            return listMenu;
        }catch (Exception e) {
            log.error("根据条件查询菜单失败", e);
            //请求失败返回并设置错误信息
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
    /**
     *@Description: 首页查询菜单
     *@Param: menuDTO
     *@return: MenuDTO
     *@Author: zqq
     *@date: 2018/11/22
     */
    @RequestMapping(value = "/listMenuRoleUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listMenuRoleUuid(@RequestBody MenuDTO menuDTO) {
        if(StringUtils.isEmpty(menuDTO.getRoleUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            List<MenuDTO> list = menuService.listMenuWithBtn(menuDTO);
            return ResultT.success(list);
        }catch (Exception e) {
            log.error("根据用户角色查询菜单失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     *@Description: 根据大宗线查询菜单
     *@Param: menuDTO
     *@return: List<MenuDTO>
     *@Author: zqq
     *@date: 2018/11/20
     */

    @RequestMapping(value = "/listMenuProdCatalogUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listMenuProdCatalogUuid(@RequestBody MenuDTO menuDTO) {
        if(StringUtils.isEmpty(menuDTO.getRoleUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        if(StringUtils.isEmpty(menuDTO.getProdCatalogUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            List<MenuDTO> list = menuService.listMenuByProdCatalogUuid(menuDTO);
            return ResultT.success(list);
        }catch (Exception e) {
            log.error("根据用户角色查询菜单失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
