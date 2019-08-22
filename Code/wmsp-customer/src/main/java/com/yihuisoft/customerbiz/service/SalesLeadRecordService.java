package com.yihuisoft.customerbiz.service;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.entity.SalesLeadRecord;

/**
 * 销售线索记录的服务
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
public interface SalesLeadRecordService {

    /**
     * 销售线索记录的保存
     * @param salesLeadRecord
     * @return
     */
    public OutDTO<SalesLeadRecord> save(SalesLeadRecord salesLeadRecord);

    /**
     * 销售线索的记录查询
     * @param pagerVO
     * @return
     */
    public OutDTO<SalesLeadRecord> list(PagerVO<SalesLeadRecord> pagerVO);

}
