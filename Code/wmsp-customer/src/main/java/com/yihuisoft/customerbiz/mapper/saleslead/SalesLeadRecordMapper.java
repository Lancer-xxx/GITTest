package com.yihuisoft.customerbiz.mapper.saleslead;

import com.yihuisoft.customerbiz.entity.SalesLeadRecord;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 销售线索记录的数据库映射对象
 * @author dim
 * @date 2019/7/25
 */
@Repository
public interface SalesLeadRecordMapper extends Mapper<SalesLeadRecord> {

}
