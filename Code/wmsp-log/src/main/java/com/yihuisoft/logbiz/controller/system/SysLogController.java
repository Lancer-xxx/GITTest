package com.yihuisoft.logbiz.controller.system;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.logbiz.dto.system.SysLogDTO;
import com.yihuisoft.logbiz.dto.system.SysLogInDTO;
import com.yihuisoft.logbiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    /**
     * 查找功能列表，可条件查询
     *
     * @param inVO
     * @return OutDTO，封装功能list
     */
    @PostMapping("/system/list")
    public OutDTO findSystemLog(@RequestBody PagerVO<SysLogDTO> inVO) {
        return sysLogService.findSystemLog(inVO.getData(), inVO.getPageMessage());
    }

    /**
     * 保存
     *
     * @param inVO
     * @return OutDTO，封装功能list
     */
    @PostMapping("/system/save")
    public OutDTO saveSystemLog(@RequestBody InVO<SysLogInDTO> inVO) {
        return sysLogService.insertSystemLog(inVO.getData());
    }


}
