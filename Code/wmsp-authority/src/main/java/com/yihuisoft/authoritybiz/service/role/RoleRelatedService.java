package com.yihuisoft.authoritybiz.service.role;

import com.yihuisoft.authoritybiz.dto.features.FeaturesDTO;
import com.yihuisoft.authoritybiz.dto.role.*;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.PageMessage;

/**
 * 角色模块相关业务接口
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
public interface RoleRelatedService {

    /**
      * 插入角色信息
      * @author topz
      * @param roleInsertDTO 角色插入实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 13:41 2019/7/12
      **/
    OutDTO saveRole(RoleInsertDTO roleInsertDTO) throws ApplicationException;

    /**
      * 角色信息分页查询
      * @author topz
      * @param rolePageDTO 角色信息分页实体类
      * @param pageMessage 分页信息
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 13:42 2019/7/12
      **/
    OutDTO findRoleList(RolePageDTO rolePageDTO, PageMessage pageMessage);

    /**
      * 查询角色等级大于当前角色等级的角色列表
      * @author topz
      * @param roleSelectedKeyDTO 角色信息查询信息实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 13:43 2019/7/12
      **/
    OutDTO getRoleDownByRoleId(RoleSelectedKeyDTO roleSelectedKeyDTO);

    /**
      * 根据角色id更新角色信息
      * @author topz
      * @param roleUpdateDTO 角色更新信息
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 17:19 2019/7/12
      **/
    OutDTO updateRoleById(RoleUpdateDTO roleUpdateDTO)  ;

    /**
      * 根据主键删除角色信息
      * @author topz
      * @param roleSelectedKeyDTO 角色删除传入信息
      * @return com.yihuisoft.common.dto.OutDTO
      * @exception  ApplicationException 业务异常
      * @date 17:19 2019/7/12
      **/
    OutDTO deleteByPrimaryKey(RoleSelectedKeyDTO roleSelectedKeyDTO) throws ApplicationException;

    /**
     * 根据主键禁用/启用角色
     * @param dto
     * @return
     */
    OutDTO disableRoleById(RoleDisableDTO dto);

    OutDTO selectRoleMenuFuncTree(FeaturesDTO dto);

    OutDTO assign(RoleMenuFuncDTO dto);

    OutDTO getListByRoleId();
}
