package com.yihuisoft.logbiz.mapper.log;

import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.logbiz.entity.log.SysTransactionLog;

import java.util.List;
import java.util.Map;

/**
 * 操作数据库mapper
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
public interface SysTransactionLogMapper {
    /**
     * 根据excepCode 删除
     *
     * @param excepCode
     * @return int
     */
    int deleteByPrimaryKey(String excepCode);

    /**
     * 插入
     *
     * @param map
     * @return int
     */
    int insertSelective(Map map);

    /**
     * 查询
     *
     * @param excepCode
     * @return SysTransactionLog
     */
    SysTransactionLog selectByPrimaryKey(String excepCode);

    /**
     * 更新
     *
     * @param sysTransactionLog
     * @return int
     */
    int updateByPrimaryKeySelective(SysTransactionLog sysTransactionLog);

    /**
     * 列表
     *
     * @param inDTO
     * @return List<SysTransactionLog>
     */
    List<SysTransactionLog> getSysTransactionLogList(InDTO inDTO);

}
