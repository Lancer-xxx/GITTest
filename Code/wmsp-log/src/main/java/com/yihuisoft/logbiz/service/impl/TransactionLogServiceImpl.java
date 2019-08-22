package com.yihuisoft.logbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.DataUtil;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.deal.SysTransactionLogDTO;
import com.yihuisoft.logbiz.dto.deal.TransactionLogQueryDTO;
import com.yihuisoft.logbiz.entity.log.TransactionLog;
import com.yihuisoft.logbiz.mapper.log.TransactionLogMapper;
import com.yihuisoft.logbiz.service.TransactionLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Service
public class TransactionLogServiceImpl implements TransactionLogService {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);

    @Autowired
    private TransactionLogMapper transactionLogMapper;


    /**
     * 查询列表
     *
     * @param transactionLogQueryDTO，pageMessage
     * @return OutDTO
     */
    @Override
    public OutDTO getTransactionLogList(TransactionLogQueryDTO transactionLogQueryDTO, PageMessage pageMessage) {

        OutDTO outDTO = new OutDTO();
        try {
            // 检查分页信息
            pageMessage = PageMessage.check(pageMessage);
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
            Map<String, Object> map = DataUtil.Object2Map(transactionLogQueryDTO);
            List<TransactionLog> list = transactionLogMapper.getTransactionLogList(map);
            // 用PageInfo对结果进行包装
            PageInfo<TransactionLog> page = new PageInfo<>(list);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return outDTO;
    }

    /**
     * 查询列表
     *
     * @param sysTransactionLogDTO
     * @return LOutDTO
     */
    @Override
    public OutDTO insertTimeOutJob(SysTransactionLogDTO sysTransactionLogDTO) {

        try {

            TransactionLog transactionLog = new TransactionLog();
            CopyUtils.copy(sysTransactionLogDTO, transactionLog);
            transactionLogMapper.insertTransactionLog(transactionLog);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return OutDTOFactory.getSucceedOutDTO();

    }
}
