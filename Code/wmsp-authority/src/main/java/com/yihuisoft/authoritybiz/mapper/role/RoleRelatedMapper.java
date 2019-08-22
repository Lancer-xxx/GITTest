package com.yihuisoft.authoritybiz.mapper.role;

import com.yihuisoft.authoritybiz.entity.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色业务接口层
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
@Repository("roleRelatedMapper")
@Mapper
public interface RoleRelatedMapper{

    /**
      * 获取角色列表
      * @author topz
      * @param indo 角色信息
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.role.Role>
      * @date 17:31 2019/7/12
      **/
    List<Role> findRoleList(Role indo);

    /**
      * 新增角色
      * @author topz
      * @param role 角色信息
      * @return int
      * @date 17:32 2019/7/12
      **/
    int saveRole(Role role);

    /**
      * 查询角色等级大于当前角色等级的角色列表
      * @author topz
      * @param role 角色信息
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.role.Role>
      * @date 17:32 2019/7/12
      **/
    List<Role> getRoleDownByRoleId(Role role);

    /**
      * 删除角色
      * @author topz
      * @param role 角色信息
      * @return int
      * @date 17:32 2019/7/12
      **/
    int deleterRoleById(Role role);

    /**
      * 查询角色信息
      * @author topz
      * @param role 角色信息
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.role.Role>
      * @date 17:33 2019/7/12
      **/
    List<Role> findRole(Role role);

    /**
      * 查重
      * @author topz
      * @param role
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.role.Role>
      * @date 17:33 2019/7/12
      **/
    Long findRoleByName(Role role);

    /**
      * 更新角色信息
      * @author topz
      * @param role 角色信息
      * @return com.yihuisoft.authoritybiz.entity.role.Role
      * @date 17:34 2019/7/12
      **/
    Role updateRole(Role role);

    /**
      * 通过id更新角色信息
      * @author topz
      * @param role 角色信息
      * @return int
      * @date 17:34 2019/7/12
      **/
    int updateRoleById(Role role);

    /**
      * 通过角色id获取角色信息
      * @author topz
      * @param roleId 角色信息
      * @return com.yihuisoft.authoritybiz.entity.role.Role
      * @date 17:34 2019/7/12
      **/
    Role findRoleById(@Param("roleId")Long roleId);

    /**
     * 禁用/启用角色
     * @param role
     */
    void disableRoleById(Role role);
}
