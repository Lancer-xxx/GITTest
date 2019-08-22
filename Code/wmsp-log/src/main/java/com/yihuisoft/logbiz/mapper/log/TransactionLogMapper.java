package com.yihuisoft.logbiz.mapper.log;

import com.yihuisoft.logbiz.entity.log.TransactionLog;
import org.apache.ibatis.annotations.Mapper;

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
public interface TransactionLogMapper {
    /**
     * 插入
     *
     * @param transactionLog
     * @return int
     */
    int insertTransactionLog(TransactionLog transactionLog);

    /**
     * 查询列表
     *
     * @param map
     * @return List<TransactionLog>
     */
    List<TransactionLog> getTransactionLogList(Map<String, Object> map);
}
