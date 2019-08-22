package com.yihuisoft.logbiz.service;


import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.job.JobRunlogFindDTO;
import com.yihuisoft.logbiz.dto.job.JobRunlogInDTO;

/**
 * 接口定义
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */

public interface JobRunlogService {


    /**
     * 查询列表
     *@author zhangsh
     * @param inDTO
     * @return OutDTO
     */
    OutDTO queryPage(InDTO inDTO);

    /**
     * 插入数据
     *@author zhangsh
     * @param inDTO
     * @return OutDTO
     */
    OutDTO insertJobRunLog(JobRunlogInDTO inDTO);

    /**
     * 查询列表
     * @author zhangsh
     * @param pageMessage
     * @param jobRunlogFindDTO
     * @return OutDTO
     */
    OutDTO selectByJobIdAndRunDate(JobRunlogFindDTO jobRunlogFindDTO, PageMessage pageMessage);


}
