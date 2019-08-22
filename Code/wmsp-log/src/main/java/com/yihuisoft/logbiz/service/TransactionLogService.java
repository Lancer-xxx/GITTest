package com.yihuisoft.logbiz.service;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.deal.SysTransactionLogDTO;
import com.yihuisoft.logbiz.dto.deal.TransactionLogQueryDTO;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public interface TransactionLogService {

    /**
     * 查询列表
     *
     * @param pageMessage
     * @param transactionLogQueryDTO
     * @return OutDTO
     */
    OutDTO getTransactionLogList(TransactionLogQueryDTO transactionLogQueryDTO, PageMessage pageMessage);

    /**
     * 查询列表
     *
     * @param sysTransactionLogDTO
     * @return LOutDTO
     */
    OutDTO insertTimeOutJob(SysTransactionLogDTO sysTransactionLogDTO);
}
