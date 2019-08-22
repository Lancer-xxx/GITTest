package com.yihuisoft.logbiz.mapper.login;


import com.yihuisoft.logbiz.entity.login.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 操作数据库mapper
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Mapper
public interface LoginMapper {
    /**
     * 插入
     *
     * @param data
     * @return long
     */
    Long insertSelective(@Param("data") Map data);

    /**
     * 获取
     *
     * @param loginLog
     * @return List<LoginLog>
     */
    List<LoginLog> getLoginLogs(LoginLog loginLog);

    /**
     * 登出
     *
     * @param logId
     * @return int
     */
    int signOut(Long logId);

    /**
     * 查询
     *
     * @param userCode
     * @return int
     */
    int selectLoginFirst(String userCode);

    /**
     * 查询列表
     *
     * @param userCode
     * @return List<LoginLog>
     */
    List<LoginLog> showLogin(String userCode);
}