package com.yihuisoft.logbiz.service;

import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogModifyInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogQueryDTO;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public interface UserLoginLogService {


    /**
     * 增加登录记录
     *
     * @param userLoginLogInDTO
     * @return OutDTO
     */
    OutDTO addLoginRecord(UserLoginLogInDTO userLoginLogInDTO);

    /**
     * 查询列表
     *
     * @param pageMessage
     * @param userLoginLogQueryDTO
     * @return OutDTO
     */
    OutDTO qryLoginLog(UserLoginLogQueryDTO userLoginLogQueryDTO, PageMessage pageMessage);

    /**
     * 登出
     *
     * @param userLoginLogModifyInDTO
     * @return OutDTO
     */
    OutDTO signOut(UserLoginLogModifyInDTO userLoginLogModifyInDTO);


    /**
     * 查询是否是第一次登录
     *
     * @param inDTO
     * @return OutDTO
     */
    OutDTO selectLoginFirst(InDTO inDTO);


}
