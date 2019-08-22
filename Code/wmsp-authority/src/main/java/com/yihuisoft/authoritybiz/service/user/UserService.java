package com.yihuisoft.authoritybiz.service.user;

import com.yihuisoft.authoritybiz.dto.user.*;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.PageMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户信息管理服务层接口
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/26 18:21
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    OutDTO getUser(Long id);

    /**
     * 查询用户信息列表
     * @param userGetDTO
     * @param pageMessage 分页信息
     * @return
     */
    OutDTO listUsers(UserListDTO userGetDTO, PageMessage pageMessage);

    /**
     * 重置用户密码
     * @param userResetDTO
     * @return
     * @throws ApplicationException
     */
    OutDTO resetUserPassword(UserResetDTO userResetDTO);

    /**
     * 新增用户信息
     * @param userInsertDTO
     * @return
     */
    OutDTO saveUser(UserInsertDTO userInsertDTO);

    /**
     * 导出用户信息
     * @param userListDTO
     * @return
     */
    List<User> getUserByItem(UserListDTO userListDTO);

    /**
     * 更新用户信息
     * @param userUpdateDTO
     * @return
     */
    OutDTO updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * 检查用户是否存在
     * @param userCheckDTO
     * @return
     */
    OutDTO checkUserExist(UserCheckDTO userCheckDTO);

    /**
     * 据用户代码查找用户机构代码
     * @param userGetInfoDTO
     * @return
     */
    OutDTO getUserOrganization(UserGetInfoDTO userGetInfoDTO);

    /**
     * 根据usercode查找用户数据权限
     * @param userGetInfoDTO
     * @return
     */
    OutDTO getUserInfoRoleInfoByParam(UserGetInfoDTO userGetInfoDTO);

    /**
      * 返回人员状态参数
      * @author topz
      * @param dictTypeCode xxxxx
      * @return java.util.Map<java.lang.String,java.lang.Object>
      * @date 16:08 2019/7/26
      **/
    Map<String,Object> getUserState(String dictTypeCode);

    /**
     * 根据机构查询当前机构下的用户信息
     * @author topz
     * @param user 机构编码
     * @return java.util.List<com.yihuisoft.authoritybiz.entity.user.User>
     * @date 16:40 2019/7/26
     **/
    OutDTO getUserByOrgn(UserListDTO user);

    /**
     * 获取请求中的用户信息
     * @return
     */
    User getContextUser();

    /**
      * 数据权限（机构和角色相关）下查询人员信息
      * @author topz
      * @param dataAuthUserDTO 当前用户的数据权限信息
      * @param dataAuthMap 传入数据权限map
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.user.User>
      * @date 18:29 2019/8/17
      **/
    List<User> getUsersByDataAuthority(@Param("userInfo") DataAuthUserDTO dataAuthUserDTO,@Param("dataAuthMap") Map<String,String> dataAuthMap);
}
