package com.yihuisoft.maintenancebiz.mapper.param;

import com.yihuisoft.common.mapper.AbstractMapper;
import com.yihuisoft.maintenancebiz.entity.param.SystemParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description: 系统参数的映射
 * @date 2019/6/25
 */
@Repository("systemParamMapper")
@Mapper
public interface SystemParamMapper extends AbstractMapper<SystemParam> {

}
