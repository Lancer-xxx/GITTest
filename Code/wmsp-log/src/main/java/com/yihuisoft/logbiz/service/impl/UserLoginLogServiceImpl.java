package com.yihuisoft.logbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.EntityUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogModifyInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogQueryDTO;
import com.yihuisoft.logbiz.entity.login.LoginLog;
import com.yihuisoft.logbiz.mapper.login.LoginMapper;
import com.yihuisoft.logbiz.service.UserLoginLogService;
import org.apache.commons.lang3.StringUtils;
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
public class UserLoginLogServiceImpl implements UserLoginLogService {

    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);


    @Autowired
    private LoginMapper loginMapper;


    /**
     * 增加登录记录
     *
     * @param userLoginLogInDTO
     * @return OutDTO
     */
    @Override
    public OutDTO addLoginRecord(UserLoginLogInDTO userLoginLogInDTO) {


        try {
            userLoginLogInDTO.setId(SnowFlakeIdWorker.generateId());
            Map<String, Object> data = EntityUtils.entityToMap(userLoginLogInDTO);
            Long result = loginMapper.insertSelective(data);
            if (result == 1) {
                logger.info("登陆日志写入成功！");
            } else {
                logger.info("登陆日志写入失败！");
            }
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }


    /**
     * 查询列表
     *
     * @param userLoginLogQueryDTO,pageMessage
     * @return OutDTO
     */
    @Override
    public OutDTO qryLoginLog(UserLoginLogQueryDTO userLoginLogQueryDTO, PageMessage pageMessage) {

        OutDTO outDTO = new OutDTO();
        try {
            // 检查分页信息
            pageMessage = PageMessage.check(pageMessage);
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
            LoginLog loginLog = new LoginLog();
            CopyUtils.copy(userLoginLogQueryDTO, loginLog);
            List<LoginLog> list = loginMapper.getLoginLogs(loginLog);

            // 用PageInfo对结果进行包装
            PageInfo<LoginLog> page = new PageInfo<>(list);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
            throw new ApplicationException(ResultEnum.ERROR_SYSTEM_BUSY);
        }

        return outDTO;
    }

    /**
     * 登出
     *
     * @param userLoginLogModifyInDTO
     * @return OutDTO
     */
    @Override
    public OutDTO signOut(UserLoginLogModifyInDTO userLoginLogModifyInDTO) {
        int result = 0;
        String logId = "";
        try {
            if (!StringUtils.isEmpty(userLoginLogModifyInDTO.getLogId())) {
                logId = userLoginLogModifyInDTO.getLogId();
            }
            result = loginMapper.signOut(Long.parseLong(logId));
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return CheckUtils.checkUpdate(result);
    }

    /**
     * 查询是否是第一次登录
     *
     * @param inDTO
     * @return OutDTO
     */
    @Override
    public OutDTO selectLoginFirst(InDTO inDTO) {
        OutDTO outDTO = new OutDTO();
        try {
            //人员表ID
            String userCode = inDTO.get("userCode").toString();
            int i = loginMapper.selectLoginFirst(userCode);
            if (i > 0) {
                OutDTOFactory.getSucceedOutDTO().put("i", i);
                OutDTOFactory.getSucceedOutDTO().put("message", "不是第一次登陆");

            } else {
                OutDTOFactory.getSucceedOutDTO().put("i", i);
                OutDTOFactory.getSucceedOutDTO().put("message", "第一次登陆");


            }
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }
        return outDTO;
    }

}
