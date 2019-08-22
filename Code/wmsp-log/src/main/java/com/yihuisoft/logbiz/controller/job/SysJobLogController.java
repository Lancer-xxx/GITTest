package com.yihuisoft.logbiz.controller.job;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.logbiz.dto.job.JobRunlogFindDTO;
import com.yihuisoft.logbiz.dto.job.JobRunlogInDTO;
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
public class SysJobLogController {


    @Autowired
    private JobRunlogService jobRunlogService;


    /**
     * 保存
     * * @param inVO
     *
     * @return OutDTO，封装功能list
     */
    @PostMapping("/job/save")
    public OutDTO taskSave(@RequestBody InVO<JobRunlogInDTO> inVO) {

        return jobRunlogService.insertJobRunLog(inVO.getData());
    }

    /**
     * 查找功能列表，可条件查询
     *
     * @param inVO
     * @return OutDTO，封装功能list
     */
    @PostMapping("/job/get")
    public OutDTO taskFind(@RequestBody PagerVO<JobRunlogFindDTO> inVO) {

        return jobRunlogService.selectByJobIdAndRunDate(inVO.getData(), inVO.getPageMessage());
    }
}
