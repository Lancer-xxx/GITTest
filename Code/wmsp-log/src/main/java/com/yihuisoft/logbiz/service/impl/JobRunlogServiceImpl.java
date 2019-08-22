package com.yihuisoft.logbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.logbiz.dto.job.JobRunlogFindDTO;
import com.yihuisoft.logbiz.dto.job.JobRunlogInDTO;
import com.yihuisoft.logbiz.entity.log.JobRunlog;
import com.yihuisoft.logbiz.mapper.log.JobRunlogMapper;
import com.yihuisoft.logbiz.service.JobRunlogService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;

/**
 * 接口定义的实现
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Service
public class JobRunlogServiceImpl implements JobRunlogService {

    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);


    @Autowired
    private JobRunlogMapper jobRunlogMapper;

    /**
     * 查询列表
     *
     * @param inDTO
     * @return OutDTO
     */
    @Override
    public OutDTO queryPage(InDTO inDTO) {
        OutDTO outDTO = new OutDTO();

        try {

            List<JobRunlog> jobRunlogList = jobRunlogMapper.selectJobLogList(inDTO);
            outDTO = OutDTOFactory.getSucceedOutDTO().putList(jobRunlogList);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }

        return outDTO;
    }

    /**
     * 插入数据
     *
     * @param jobRunlogInDto
     * @return OutDTO
     */

    @Override
    public OutDTO insertJobRunLog(JobRunlogInDTO jobRunlogInDto) {


        try {

            JobRunlog jobRunlog = new JobRunlog();
            CopyUtils.copy(jobRunlogInDto, jobRunlog);
            jobRunlogMapper.insert(jobRunlog);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }


        return OutDTOFactory.getSucceedOutDTO();
    }


    /**
     * 查询列表
     *
     * @param jobRunlogFindDTO，pageMessage
     * @return OutDTO
     */

    @Override
    public OutDTO selectByJobIdAndRunDate(JobRunlogFindDTO jobRunlogFindDTO, PageMessage pageMessage) {

        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

        JobRunlog jobRunlog = new JobRunlog();
        CopyUtils.copy(jobRunlogFindDTO, jobRunlog);

        List<JobRunlog> list = null;
        try {
            
            list = jobRunlogMapper.selectByJobIdAndRunDate(jobRunlogFindDTO);
        } catch (Exception e) {
            errorLogger.error(e.getMessage(), e);
        }
        // 用PageInfo对结果进行包装
        PageInfo<JobRunlog> page = new PageInfo(list);

        //封装返回信息
        return OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
    }


}
