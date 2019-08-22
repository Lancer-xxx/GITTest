package com.yihuisoft.authoritybiz.controller.permission;

import com.yihuisoft.authoritybiz.dto.permission.RoleDataPermissionSelectDTO;
import com.yihuisoft.authoritybiz.entity.permission.DataPermission;
import com.yihuisoft.authoritybiz.entity.permission.RoleDataPermission;
import com.yihuisoft.authoritybiz.service.permission.DataPermissionService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据权限
 */
@RestController
@RequestMapping("/wmsp/authority/permission")
public class DataPersionController {
    @Autowired
    private DataPermissionService dataPersionService;

    /**
     * 获取数据权限
     * @param inVO
     * @return
     */
    @PostMapping(value = "/list_by_role_id")
    public OutDTO<RoleDataPermission> getList(@Validated @RequestBody InVO<RoleDataPermissionSelectDTO> inVO){
        return dataPersionService.selectDataPersionByRoleId(inVO.getData());
    }

    /**
     * 获取数据权限详情
     * @param inVO
     * @return
     */
    @PostMapping(value = "/data_by_role_id")
    public OutDTO<DataPermission> getDataPersion(@Validated @RequestBody InVO<RoleDataPermissionSelectDTO> inVO){
        return dataPersionService.getDataPersion(inVO.getData());
    }
}
