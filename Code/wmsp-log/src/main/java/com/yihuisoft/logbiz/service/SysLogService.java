package com.yihuisoft.logbiz.service;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.system.SysLogDTO;
import com.yihuisoft.logbiz.dto.system.SysLogInDTO;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public interface SysLogService {
    /**
     * 查询列表
     *
     * @param sysLogDTO
     * @param pageMessage
     * @return LOutDTO
     */
    OutDTO findSystemLog(SysLogDTO sysLogDTO, PageMessage pageMessage);

    /**
     * 插入数据
     *
     * @param sysLogInDTO
     * @return OutDTO
     */

    OutDTO insertSystemLog(SysLogInDTO sysLogInDTO);
}
