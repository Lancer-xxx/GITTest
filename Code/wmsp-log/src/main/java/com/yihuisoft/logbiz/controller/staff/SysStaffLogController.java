package com.yihuisoft.logbiz.controller.staff;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogModifyInDTO;
import com.yihuisoft.logbiz.dto.satff.UserLoginLogQueryDTO;
import com.yihuisoft.logbiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定义前端传输公共字段
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@RequestMapping("/wmsp/log")
@RestController
public class SysStaffLogController {


    @Autowired
    private UserLoginLogService userLoginLogService;


    /**
     * 新增
     *
     * @param inVO
     * @return OutDTO，封装功能list
     */
    @PostMapping("/user/save")
    public OutDTO staffSave(@Validated @RequestBody InVO<UserLoginLogInDTO> inVO) {
        return userLoginLogService.addLoginRecord(inVO.getData());
    }

    /**
     * 更新
     *
     * @param inVO
     * @return OutDTO
     */
    @PostMapping("/user/update")
    public OutDTO staffModify(@Validated @RequestBody InVO<UserLoginLogModifyInDTO> inVO) {
        return userLoginLogService.signOut(inVO.getData());
    }

    /**
     * 查找功能列表，可条件查询
     *
     * @param inVO
     * @return OutDTO，封装功能list
     */
    @PostMapping("/user/list")
    public OutDTO staffQuery(@RequestBody PagerVO<UserLoginLogQueryDTO> inVO) {

        return userLoginLogService.qryLoginLog(inVO.getData(), inVO.getPageMessage());

    }


}
