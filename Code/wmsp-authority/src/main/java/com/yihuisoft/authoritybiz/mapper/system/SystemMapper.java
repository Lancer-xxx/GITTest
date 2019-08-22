package com.yihuisoft.authoritybiz.mapper.system;


import com.yihuisoft.authoritybiz.entity.system.SystemModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统信息dao
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/3 19:39
 */
@Mapper
public interface SystemMapper {

    /**
     * 根据ID删除信息信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入系统信息
     * @param systemModel
     * @return
     */
    int insertSelective(SystemModel systemModel);

    /**
     * 根据ID或系统编码查询系统信息
     * @param systemModel
     * @return
     */
    SystemModel selectByPrimaryKey(SystemModel systemModel);

    /**
     * 根据sysName获得系统信息
     * @param sysName
     * @return
     */
    List<SystemModel> selectByName(String sysName);

    /**
     * 根据ID修改系统信息
     * @param systemModel
     * @return
     */
    int updateByPrimaryKeySelective(SystemModel systemModel);

    /**
     * 查询所有系统信息
     * @return
     */
    List<SystemModel> listAllSystems();

    /**
     * 根据系统名模糊匹配查询系统列表
     * @param systemModel
     * @return
     */
    List<SystemModel> listSystems(SystemModel systemModel);

    /**
     * 根据角色ID查询系统信息
     * @param roleId
     * @return
     */
    List<SystemModel> getSysByRoleId(@Param("roleId") Long roleId);

}