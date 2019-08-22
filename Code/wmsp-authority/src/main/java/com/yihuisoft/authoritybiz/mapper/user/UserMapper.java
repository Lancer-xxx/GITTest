package com.yihuisoft.authoritybiz.mapper.user;


import com.yihuisoft.authoritybiz.dto.user.DataAuthUserDTO;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.mapper.AbstractMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户信息dao
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/3 19:39
 */
@Mapper
public interface UserMapper extends AbstractMapper<User> {

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    int insertSelective(User user);

    /**
     * 重置密码
     * @param user
     * @return
     */
    int resetPassWord(User user);

    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User selectByPrimaryKey(Long id);

    /**
     * 根据用户代码查询用户信息
     * @param userCode
     * @return
     */
    User selectByUserCode(String userCode);

    /**
     * 根据用户代码查询机构代码
     * @param userCode
     * @return
     */
    User getOrgCodeByUserCode(String userCode);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 根据用户代码查询用户信息
     * @param userCode
     * @return
     */
    User getBankUserLogin(String userCode);

    /**
     * 根据角色ID查询用户数
     * @param roleId
     * @return
     */
    List<User> getCountByRoleId(Long roleId);

    /**
     * 查询用户信息列表
     * @param map
     * @return
     */
    List<User> getUserList(Map<String,Object> map);

    /**
     * 检查用户是否存在
     * @param user
     * @return
     */
    List<User> getUserExist(User user);

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    List<User> getUserByItem(User user);

    /**
     * 批量查询用户信息
     * @param list
     * @return
     */
    List<User> findBatchUser(@Param("list") List<String> list);

    /**
      * 根据机构查询当前机构下的用户信息
      * @author topz
      * @param orgnCode 机构编码
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.user.User>
      * @date 16:43 2019/7/26
      **/
    List<User>  getUserByOrgn(@Param("orgnCode")String orgnCode);

    /**
      * 数据权限（机构和角色相关）下查询人员信息
      * @author topz
      * @param dataAuthUserDTO 传入当前用户信息
      * @param map 传入数据权限相关数据
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.user.User>
      * @date 18:26 2019/8/17
      **/
    List<User>  getUsersByDataAuthority(@Param("userInfo")DataAuthUserDTO dataAuthUserDTO, @Param("dataAuthMap")Map map);

}