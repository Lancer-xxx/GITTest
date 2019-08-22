package com.yihuisoft.authoritybiz.mapper.features;

import com.yihuisoft.authoritybiz.entity.features.Features;
import com.yihuisoft.authoritybiz.entity.features.RoleFeatures;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能管理mapper
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/3
 */
public interface FeaturesMapper {

    /**
     * 查找功能信息列表
     * @param features 功能实体
     * @return List<Features>
     */
    List<Features> list(Features features);
    /**
     * 根据RoleID和menuId删除角色功能关系表记录
     * @param roleId 角色ID
     * @param menuId 菜单ID
     * @return 返回执行结果，1删除成功
     */
    int deleteRoleFuncByMenuId(@Param("roleId") Long roleId,@Param("funcId")Long menuId);

}
