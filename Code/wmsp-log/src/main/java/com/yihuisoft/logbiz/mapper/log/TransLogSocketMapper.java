package com.yihuisoft.logbiz.mapper.log;

import com.yihuisoft.logbiz.entity.log.TransLogSocket;
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
public interface TransLogSocketMapper {
    /**
     * 查询列表
     *
     * @param map
     * @return List<TransLogSocket>
     */
    List<TransLogSocket> queryTransLogSocket(Map<String, Object> map);

    /**
     * 插入
     *
     * @param transLogSocket
     * @return int
     */
    long insertSocket(TransLogSocket transLogSocket);

}
