package com.yihuisoft.authoritybiz.service.login;

import com.yihuisoft.authoritybiz.dto.login.LoginDTO;
import com.yihuisoft.authoritybiz.dto.login.LogoutDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;

/**
 * 人员登录接口定义
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/5
 */
public interface UserLoginService {

    /**
     *系统登录接口
     * @param loginDTO
     * @return
     * @throws Exception
     */
    OutDTO userLogin(LoginDTO loginDTO) throws Exception;
    /**
     * 系统登出接口
     * @param logoutDTO
     * @return
     */
    OutDTO signOut(LogoutDTO logoutDTO);
}
