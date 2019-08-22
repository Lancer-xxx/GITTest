package com.yihuisoft.authoritybiz.service.permission;

import com.yihuisoft.authoritybiz.dto.permission.RoleDataPermissionSelectDTO;
import com.yihuisoft.authoritybiz.entity.permission.DataPermission;
import com.yihuisoft.authoritybiz.entity.permission.RoleDataPermission;
import com.yihuisoft.common.dto.OutDTO;
/**
 * 数据权限业务接口
 * @author mengfanbang
 * @date 2019/8/17
 * @version V4.0.2
 */
public interface DataPermissionService {
    /**
     * 获取数据权限
     * @param dto
     * @return
     */
    OutDTO<RoleDataPermission> selectDataPersionByRoleId(RoleDataPermissionSelectDTO dto);

    /**
     * 获取数据权限详情
     * @param dto
     * @return
     */
    OutDTO<DataPermission> getDataPersion(RoleDataPermissionSelectDTO dto);
}
