package com.yihuisoft.customerbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.entity.SalesLeadRecord;
import com.yihuisoft.customerbiz.mapper.saleslead.SalesLeadRecordMapper;
import com.yihuisoft.customerbiz.service.SalesLeadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * 销售线索的记录服务
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
@Service
public class SalesLeadRecordServiceImpl implements SalesLeadRecordService {

    @Autowired
    SalesLeadRecordMapper salesLeadRecordMapper;

    @Autowired
    OrganizationService organizationService;

    /**
     * 销售线索的记录的保存
     * @param salesLeadRecord
     * @return
     */
    @Override
    public OutDTO<SalesLeadRecord> save(SalesLeadRecord salesLeadRecord) {
        salesLeadRecord.setOperateTime(Date.from(Instant.now()));
        int result = salesLeadRecordMapper.insert(salesLeadRecord);
        return result > 0 ? new OutDTO<>().setStatus(OutDTOFactory.STATUS_SUCCESS) : new OutDTO<>().setStatus("1");
    }

    /**
     * 分页查询销售线索的记录
     * @param pagerVO
     * @return
     */
    @Override
    public OutDTO<SalesLeadRecord> list(PagerVO<SalesLeadRecord> pagerVO) {
        // 检查分页信息
        PageMessage pageMessage = PageMessage.check(pagerVO.getPageMessage());
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
        Example salesLeadRecordExample = new Example(SalesLeadRecord.class);
        salesLeadRecordExample.createCriteria()
                .andEqualTo("salesLeadId",pagerVO.getData().getSalesLeadId());
        List<SalesLeadRecord> list = salesLeadRecordMapper.selectByExample(salesLeadRecordExample);

        // 用PageInfo对结果进行包装
        PageInfo<SalesLeadRecord> page = new PageInfo<SalesLeadRecord>(list);

        // 封装返回信息
        return OutDTOFactory.getSucceedOutDTO()
                .putList(list)
                .setSumCount(page.getTotal());
    }


}
