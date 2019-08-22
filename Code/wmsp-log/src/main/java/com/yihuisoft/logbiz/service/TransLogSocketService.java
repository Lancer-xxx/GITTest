package com.yihuisoft.logbiz.service;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.message.TransLogSocketInDTO;
import com.yihuisoft.logbiz.dto.message.TransLogSocketQueryDTO;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public interface TransLogSocketService {


    /**
     * 查询列表
     *
     * @param pageMessage
     * @param transLogSocketQueryDTO
     * @return OutDTO
     */
    OutDTO queryTransLogSocket(TransLogSocketQueryDTO transLogSocketQueryDTO, PageMessage pageMessage);

    /**
     * 插入数据
     *
     * @param transLogSocketInDTO
     * @return OutDTO
     */
    OutDTO insertSocket(TransLogSocketInDTO transLogSocketInDTO);

}
