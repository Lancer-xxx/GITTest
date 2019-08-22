package com.yihuisoft.authoritybiz.service.features.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.dto.features.*;
import com.yihuisoft.authoritybiz.entity.features.Features;
import com.yihuisoft.authoritybiz.entity.features.RoleFeatures;
import com.yihuisoft.authoritybiz.entity.features.RoleFeaturesDO;
import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenu;
import com.yihuisoft.authoritybiz.entity.menu.TreeMenuTwo;
import com.yihuisoft.authoritybiz.entity.system.SystemModel;
import com.yihuisoft.authoritybiz.mapper.features.FeaturesMapper;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.system.SystemMapper;
import com.yihuisoft.authoritybiz.service.features.FeaturesService;
import com.yihuisoft.authoritybiz.service.role.RoleRelatedService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * 功能管理实现类
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/3
 */
@Service
public class FeaturesServiceImpl implements FeaturesService {
    public static final Logger logger = LoggerFactory.getLogger(FeaturesService.class);

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleRelatedService roleRelatedService;

    /**
     * 查询功能列表
     * @param featuresListDTO
     * @return
     */
    @Override
    public OutDTO listFeatures(FeaturesListDTO featuresListDTO, PageMessage pageMessage) {
        Menu menu = new Menu();
        CopyUtils.copy(featuresListDTO,menu);
        OutDTO res = new OutDTO();
        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
        // 获取所有功能列表
        List<Menu> menuList = menuMapper.getList(menu);
        if (!ObjectUtils.isEmpty(menuList)) {
            menuList.forEach(menu1 -> {
                // 根据parentId获取归属菜单
                Menu m = menuMapper.getParentMenuById(menu1.getParentId());
                if (!ObjectUtils.isEmpty(m)) {
                    if ("3".equals(m.getMenuType())){ // 父级是功能
                        menu1.setParentFeature(m.getMenuName());
                        Menu menu2 = menuMapper.getParentMenuById(m.getParentId());
                        menu1.setParentName(menu2.getMenuName());
                    } else {
                        menu1.setParentName(m.getMenuName());
                    }
                }
            });
        }
        PageInfo<Menu> page = new PageInfo<>(menuList);
        // 获取树状图
        OutDTO outDTO = roleRelatedService.getListByRoleId();
        res = OutDTOFactory.getSucceedOutDTO().putList(menuList);
        res.setSumCount(page.getTotal());
        res.getData().put("treeList", outDTO.getData().get("list"));
        return res;
    }

    /**
     * 新增功能信息
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public OutDTO saveFeatures(FeaturesSaveDTO dto) throws ApplicationException {
        Menu menu = new Menu();
        CopyUtils.copy(dto, menu);
        int result;
        try{
            Long count = menuMapper.getFuncCountByMenuName(menu);
            if (count > 0) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_FEATURES_EXIST);
            }
            // 插入
            menu.setMenuStatus("1");
            menu.setId(SnowFlakeIdWorker.generateId());
            menu.setUpdateUserid(menu.getCreateUserid());
            result = menuMapper.saveMenu(menu);
            // 分配系统管理员权限
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(SnowFlakeIdWorker.generateId());
            roleMenu.setRoleId(CommonConstants.ADMINISTRATOR);
            roleMenu.setMenuId(menu.getId());
            roleMenu.setStatus("1");
            roleMenu.setCreateUserid(menu.getCreateUserid());
//            roleMenu.setUpdateUserid(menu.getCreateUserid());
            menuMapper.saveRoleMenu(roleMenu);
        }catch(Exception e){
            logger.error(ResultEnum.ERROR_INSERT.getMessage()+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_INSERT);
        }
        if (result == 1) {
            return OutDTOFactory.getSucceedOutDTO();
        } else {
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
        }
    }

    /**
     * 修改功能信息
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public OutDTO updateFeatures(FeaturesUpdateDTO dto) throws ApplicationException {
        Menu menu = new Menu();
        CopyUtils.copy(dto,menu);
        int result;
        try{
            Long count = menuMapper.getFuncCountByMenuName(menu);
            if (count > 0) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_FEATURES_EXIST);
            }
            // 修改
            result = menuMapper.updateMenu(menu);
        }catch(Exception e){
            logger.error(ResultEnum.ERROR_UPDATE.getMessage()+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_UPDATE);
        }
        return  CheckUtils.checkUpdate(result);
    }
    /**
     * 删除功能信息
     * @param featuresDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public OutDTO deleteFeatures(FeaturesDTO featuresDTO) throws ApplicationException {
        Menu menu = new Menu();
        CopyUtils.copy(featuresDTO,menu);
        int result;
        try{
            //判断功能是否被使用，被使用无法删除
//            List<RoleMenu> roleMenuList = menuMapper.listRoleMenuByMenuId(menu.getId());
//            if (!ObjectUtils.isEmpty(roleMenuList)) {
//                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_FEATURES_USED);
//            }
            // 判断功能是否有子功能
            Menu menu1 = new Menu();
            menu1.setParentId(menu.getId());
            List<Menu> menuList = menuMapper.listMenu(menu1);
            if (!ObjectUtils.isEmpty(menuList)) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_FEATURES_PARENT);
            }
            // 逻辑删除
            menu.setIsDeleted("1");
            result = menuMapper.deleteMenu(menu.getId());
            // 删除中间表数据
            menuMapper.deleteByMenuId(menu.getId());
        }catch(Exception e){
            logger.error(ResultEnum.ERROR_DELETE.getMessage()+e.getMessage(),e);
            throw new ApplicationException(ResultEnum.ERROR_DELETE);
        }
        return CheckUtils.checkDelete(result);
    }

}
