package com.yihuisoft.logbiz.mapper.log;

/**
 * 操作数据库mapper
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

import org.apache.ibatis.annotations.Mapper;

import com.yihuisoft.logbiz.entity.log.SysLog;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysLogMapper {
    /**
     * 根据excepCode删除
     * @param excepCode
     * @return int
     */
    int deleteByPrimaryKey(String excepCode);

    /**
     * 插入
     * @param sysLog
     * @return xint
     *
     */
    int insertSelective(SysLog sysLog);

    /**
     * 根据excepCode查询
     * @param excepCode
     * @return SysLog
     */
    SysLog selectByPrimaryKey(String excepCode);

    /**
     * 更新
     * @param sysLog
     * @return int
     */
    int updateByPrimaryKeySelective(SysLog sysLog);

    /**
     * 查询列表
     * @param map
     * @return List<SysLog>
     */
    List<SysLog> getSysLogList(Map<String, Object> map);


}