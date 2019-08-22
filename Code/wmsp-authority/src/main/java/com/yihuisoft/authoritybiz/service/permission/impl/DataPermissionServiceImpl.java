package com.yihuisoft.authoritybiz.service.permission.impl;

import com.yihuisoft.authoritybiz.dto.permission.RoleDataPermissionSelectDTO;
import com.yihuisoft.authoritybiz.entity.permission.DataPermission;
import com.yihuisoft.authoritybiz.entity.permission.RoleDataPermission;
import com.yihuisoft.authoritybiz.mapper.permission.RoleDataPermissionMapper;
import com.yihuisoft.authoritybiz.service.permission.DataPermissionService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 数据权限业务实现类
 * @author mengfanbang
 * @date 2019/8/17
 * @version V4.0.2
 */
@Service
public class DataPermissionServiceImpl implements DataPermissionService {

    @Autowired
    private RoleDataPermissionMapper roleDataPermissionMapper;

    /**
     * 获取数据权限
     * @param dto
     * @return
     */
    @Override
    public OutDTO<RoleDataPermission> selectDataPersionByRoleId(RoleDataPermissionSelectDTO dto) {
        List<RoleDataPermission> roleDataPermissionList =  roleDataPermissionMapper.selectDataPersionByRoleId(dto.getRoleId());
        return OutDTOFactory.getSucceedOutDTO().putList(roleDataPermissionList);
    }

    /**
     * 获取数据权限详情
     * @param dto
     * @return
     */
    @Override
    public OutDTO<DataPermission> getDataPersion(RoleDataPermissionSelectDTO dto) {
        DataPermission dataPermission =  roleDataPermissionMapper.getDataPersion(dto);
        return OutDTOFactory.getSucceedOutDTO().putInfo(dataPermission);
    }
}
