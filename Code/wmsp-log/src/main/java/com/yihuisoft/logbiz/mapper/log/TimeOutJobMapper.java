package com.yihuisoft.logbiz.mapper.log;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 操作数据库mapper
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Mapper
public interface TimeOutJobMapper {

    /**
     * 插入
     *
     * @param map
     * @return xxx，封装功能list
     */
    int insertTimeOutJob(Map map);

}
