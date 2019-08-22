package com.yihuisoft.logbiz.mapper.log;

import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.logbiz.dto.job.JobRunlogFindDTO;
import com.yihuisoft.logbiz.entity.log.JobRunlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库mapper
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/15 9:55
 */
@Mapper
public interface JobRunlogMapper {
    /**
     * 根据主键删除
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 定时任务插入
     *
     * @param jobRunlog
     * @return int
     */
    int insert(JobRunlog jobRunlog);

    /**
     * 定时任务选择插入
     *
     * @param jobRunlog
     * @return int
     */
    int insertSelective(JobRunlog jobRunlog);

    /**
     * 根据主键查询对象实体
     *
     * @param id
     * @return JobRunLog
     */
    JobRunlog selectByPrimaryKey(Long id);

    /**
     * 根据主键查询对象实体
     *
     * @param jobRunlog
     * @return JobRunLog
     * return int
     */
    int updateByPrimaryKeySelective(JobRunlog jobRunlog);

    /**
     * 查询列表
     *
     * @param inDTO
     * @return List<JobRunLog>
     */
    List<JobRunlog> selectJobLogList(InDTO inDTO);

    /**
     * 查询列表
     *
     * @param jobRunlog
     * @return List<JobRunLog>
     */
    List<JobRunlog> queryList(JobRunlogFindDTO jobRunlog);

    /**
     * 查询列表
     *
     * @param jobRunlog
     * @return List<JobRunLog>
     */
    List<JobRunlog> selectByJobIdAndRunDate(JobRunlogFindDTO jobRunlog);
}