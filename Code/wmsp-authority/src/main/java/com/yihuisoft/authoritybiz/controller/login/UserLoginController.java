package com.yihuisoft.authoritybiz.controller.login;

import com.yihuisoft.authoritybiz.dto.login.LoginDTO;
import com.yihuisoft.authoritybiz.dto.login.LogoutDTO;
import com.yihuisoft.authoritybiz.service.login.UserLoginService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录接口层
 * @author laijd
 * @date 2019/06/24
 * @version V4.0.0
 * */
@RestController
@RequestMapping("/wmsp/authority/user/")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
    /**
     * 系统登录接口
     * @param inVO
     * @return OutDTO
     * @throws ApplicationException
     */
    @PostMapping(value = "/login")
    public OutDTO login(@Validated  @RequestBody InVO<LoginDTO> inVO)throws Exception{
        return userLoginService.userLogin(inVO.getData()) ;
    } 
    /**
     * 系统登出接口
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/logout")
    public OutDTO logout(@Validated @RequestBody InVO<LogoutDTO> inVO){
        return userLoginService.signOut(inVO.getData());
    }

}
