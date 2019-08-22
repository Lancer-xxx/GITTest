package com.yihuisoft.logbiz.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.DataUtil;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.message.TransLogSocketInDTO;
import com.yihuisoft.logbiz.dto.message.TransLogSocketQueryDTO;
import com.yihuisoft.logbiz.entity.log.TransLogSocket;
import com.yihuisoft.logbiz.mapper.log.TransLogSocketMapper;
import com.yihuisoft.logbiz.service.TransLogSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TransLogSocketServiceImpl implements TransLogSocketService {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);

    @Resource
    private TransLogSocketMapper transLogSocketMapper;



    /**
     * 查询列表
     *
     * @param transLogSocketQueryDTO,pageMessage
     * @return OutDTO
     */
    @Override
    public OutDTO queryTransLogSocket(TransLogSocketQueryDTO transLogSocketQueryDTO, PageMessage pageMessage) {
        OutDTO outDTO = new OutDTO();
        try {
            // 检查分页信息
            pageMessage = PageMessage.check(pageMessage);
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
            Map<String, Object> map = DataUtil.Object2Map(transLogSocketQueryDTO);
            List<TransLogSocket> list = transLogSocketMapper.queryTransLogSocket(map);
            // 用PageInfo对结果进行包装
            PageInfo<TransLogSocket> page = new PageInfo<>(list);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return outDTO;
    }


    /**
     * 插入数据
     *
     * @param transLogSocketInDTO
     * @return OutDTO
     */
    @Override
    public OutDTO insertSocket(TransLogSocketInDTO transLogSocketInDTO) {
        try {

            TransLogSocket transLogSocket = new TransLogSocket();
            CopyUtils.copy(transLogSocketInDTO, transLogSocket);
            transLogSocketMapper.insertSocket(transLogSocket);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }

}
