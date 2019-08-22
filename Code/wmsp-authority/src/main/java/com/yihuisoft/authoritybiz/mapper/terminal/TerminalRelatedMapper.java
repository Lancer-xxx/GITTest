package com.yihuisoft.authoritybiz.mapper.terminal;

import com.yihuisoft.authoritybiz.entity.terminal.Terminal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 终端维护业务接口层
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
@Repository("terminalRelatedMapper")
@Mapper
public interface TerminalRelatedMapper {

    /**
      * 获取设备信息分页列表
      * @author topz
      * @param indo 设备信息实体
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.terminal.Terminal>
      * @date 10:52 2019/7/12
      **/
    List<Terminal> listTerminals(Terminal indo);

    /**
      * 新增设备
      * @author topz
      * @param terminal 设备信息实体
      * @return int
      * @date 10:53 2019/7/12
      **/
    int saveTerminal(Terminal terminal);

    /**
      * 根据id获取设备信息
      * @author topz
      * @param logDeviceId 设备标识
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.terminal.Terminal>
      * @date 10:53 2019/7/12
      **/
    List<Terminal> getTerminalById(String logDeviceId);

    /**
      * 更新设备信息
      * @author topz
      * @param terminal 设备信息实体
      * @return int
      * @date 10:54 2019/7/12
      **/
    int updateTerminal(Terminal terminal);

    /**
      * 查询相同机构下相同ip的设备信息集合
      * @author topz
      * @param terminal 设备信息实体
      * @return java.util.List<com.yihuisoft.authoritybiz.entity.terminal.Terminal>
      * @date 10:55 2019/7/12
      **/
    List<Terminal> findOrgnCodeByIp(Terminal terminal);
}
