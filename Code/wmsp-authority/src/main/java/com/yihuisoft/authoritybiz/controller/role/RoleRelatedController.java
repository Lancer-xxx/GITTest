package com.yihuisoft.authoritybiz.controller.role;

import com.yihuisoft.authoritybiz.dto.features.FeaturesDTO;
import com.yihuisoft.authoritybiz.dto.role.*;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.service.role.RoleRelatedService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色信息业务控制层
 * @className RoleRelController
 * @projectName yihuisoft-authority
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
@RestController
@RequestMapping("/wmsp/authority/role")
public class RoleRelatedController{

    private static final Logger logger = LoggerFactory.getLogger(RoleRelatedController.class);

    @Autowired
    private RoleRelatedService roleRelatedService;

    /**
      * 新增角色
      * @author topz
      * @param inVO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 18:00 2019/7/17
      **/
    @PostMapping(value = "/save")
    public OutDTO saveRole(@Validated @RequestBody InVO<RoleInsertDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.saveRole(inVO.getData());
        return  res;
    }

    /**
      * 获取角色列表
      * @author topz
      * @param inVO 分页获取参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 18:01 2019/7/17
      **/
    @PostMapping(value = "/list")
    public OutDTO findRoleList(@Validated @RequestBody PagerVO<RolePageDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.findRoleList(inVO.getData(),inVO.getPageMessage());
        return  res;
    }

    /**
      * 查询角色等级大于当前角色等级的角色列表
      * @author topz
      * @param inVO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 18:01 2019/7/17
      **/
    @PostMapping(value = "/list_by_level")
    public OutDTO findRoleListByLevel(@Validated @RequestBody InVO<RoleSelectedKeyDTO> inVO) throws ApplicationException {

        OutDTO res = roleRelatedService.getRoleDownByRoleId(inVO.getData());
        return  res;
    }

    /**
      * 根据角色id删除角色信息
      * @author topz
      * @param inVO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 18:01 2019/7/17
      **/
    @PostMapping(value = "/delete")
    public OutDTO deleteByPrimaryKey(@Validated @RequestBody InVO<RoleSelectedKeyDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.deleteByPrimaryKey(inVO.getData());
        return  res;
    }


    /**
      * 根据角色id更新角色信息
      * @author topz
      * @param inVO
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 18:02 2019/7/17
      **/
    @PostMapping(value = "/update")
    public OutDTO updateRoleById(@Validated @RequestBody InVO<RoleUpdateDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.updateRoleById(inVO.getData());
        return  res;
    }

    /**
     * 根据角色id禁用/启用角色
     * @param inVO
     * @return
     * @throws ApplicationException
     */
    @PostMapping(value = "/disable")
    public OutDTO disableRoleById(@Validated @RequestBody InVO<RoleDisableDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.disableRoleById(inVO.getData());
        return  res;
    }

    /**
     * 根据角色id获取树状图
     * @param inVO
     * @return
     * @throws ApplicationException
     */
    @PostMapping(value = "/selectRoleMenuFuncTree")
    public OutDTO selectRoleMenuFuncTree(@Validated @RequestBody InVO<FeaturesDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.selectRoleMenuFuncTree(inVO.getData());
        return  res;
    }

    /**
     * 角色菜单的分配
     * @param inVO
     * @return
     * @throws ApplicationException
     */
    @PostMapping(value = "/assign")
    public OutDTO assign(@Validated @RequestBody InVO<RoleMenuFuncDTO> inVO) throws ApplicationException {
        OutDTO res = roleRelatedService.assign(inVO.getData());
        return  res;
    }
}
