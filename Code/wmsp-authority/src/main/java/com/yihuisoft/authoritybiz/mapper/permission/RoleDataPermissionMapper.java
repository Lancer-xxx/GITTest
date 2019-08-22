package com.yihuisoft.authoritybiz.mapper.permission;

import com.yihuisoft.authoritybiz.dto.permission.RoleDataPermissionSelectDTO;
import com.yihuisoft.authoritybiz.entity.permission.DataPermission;
import com.yihuisoft.authoritybiz.entity.permission.RoleDataPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理mapper
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/1
 */
@Repository("roleDataPersionMapper")
@Mapper
public interface RoleDataPermissionMapper {

    /**
     * 添加数据权限
     * @param roleDataPersion
     */
    void saveRoleDataPersion(RoleDataPermission roleDataPersion);

    /**
     * 删除数据权限
     * @param roleId
     */
    void deleteByRoleId(@Param("roleId") Long roleId);

    /**
     * 获取数据权限
     * @param roleId
     * @return
     */
    List<RoleDataPermission> selectDataPersionByRoleId(@Param("roleId") Long roleId);

    /**
     * 获取数据权限详情
     * @param dataPersion
     * @return
     */
    DataPermission getDataPersion(RoleDataPermissionSelectDTO dataPersion);
}
