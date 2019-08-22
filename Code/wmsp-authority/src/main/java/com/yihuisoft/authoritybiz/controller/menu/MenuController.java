package com.yihuisoft.authoritybiz.controller.menu;

import com.yihuisoft.authoritybiz.dto.menu.*;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 菜单管理控制层
 * @author laijd
 * @date 2019/06/24
 * @version V4.0.0
 * */
@RestController
@RequestMapping("/wmsp/authority/menu")
public class MenuController<T> {

    @Autowired
    private MenuService menuService;

    /**
     * 新增菜单信息
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "/save")
    public OutDTO saveMenu(@Validated @RequestBody InVO<MenuSaveDTO> inVO) throws ApplicationException {
        return menuService.saveMenu(inVO.getData());
    }

    /**
     * 修改菜单信息
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "update")
    public OutDTO updateMenu(@RequestBody InVO<MenuUpdateDTO> inVO) throws ApplicationException {
        return menuService.updateMenu(inVO.getData());
    }

    /**
     * 删除菜单信息
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "delete")
    public OutDTO deleteMenu(@Validated @RequestBody InVO<MenuDTO> inVO) throws ApplicationException {
        return menuService.deleteMenu(inVO.getData());
    }

    /**
     *根据id获取菜单信息  getOneMenuById
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get")
    public OutDTO getMenu(@RequestBody InVO<MenuDTO> inVO){
        return menuService.getMenu(inVO.getData());
    }
    /**
     * 查找所有菜单列表
     * @return OutDTO
     */
    @PostMapping(value = "/list")
    public OutDTO listAllMenu(){
        return menuService.listAllMenu();
    }

    /**
     * 菜单树-角色菜单分配，根据roleId查找菜单列表并解析成树  qrySysMenuTree
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "list_by_role")
    public OutDTO listSysMenuTree(@RequestBody InVO<MenuDTO> inVO){
        return menuService.listSysMenuTree(inVO.getData());
    }
    /**
     * 字典模块调用
     * 菜单树
     * 获取根菜单及父级是根菜单的所有菜单
     * @return OutDTO
     */
    @PostMapping(value = "list_menu_tree")
    public OutDTO<T> listMenuTree(){
        return menuService.listMenuTree();
    }


}
