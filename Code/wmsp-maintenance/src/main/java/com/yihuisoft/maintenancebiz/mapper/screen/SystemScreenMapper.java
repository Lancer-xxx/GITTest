package com.yihuisoft.maintenancebiz.mapper.screen;

import com.yihuisoft.common.mapper.AbstractMapper;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.dto.SystemScreenDTO;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/6/25
 */
@Repository
@Mapper
public interface SystemScreenMapper extends AbstractMapper<SystemScreen> {

    /**
     * 查询系统屏保的分页信息
     * @param pagerVO
     * @return
     */
    List<SystemScreen> search(PagerVO<SystemScreenDTO> pagerVO);
}
