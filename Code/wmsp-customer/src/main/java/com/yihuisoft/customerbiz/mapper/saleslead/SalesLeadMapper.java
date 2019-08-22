package com.yihuisoft.customerbiz.mapper.saleslead;

import com.yihuisoft.common.base.CommonMapper;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadDetailDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadListDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 销售线索的映射对象
 * @author dim
 * @date 2019/7/25
 */
@Repository
public interface SalesLeadMapper extends CommonMapper<SalesLead> {

    /**
     * 查询销售线索的分页列表
     * @param salesLeadListDTO
     * @return
     */
    List<SalesLeadDetailDTO> listByDTO(SalesLeadListDTO salesLeadListDTO);

    /**
     * 查询销售线索的明细
     * @param salesLeadDetailDTO
     * @return
     */
    SalesLeadDetailDTO getDetail(SalesLeadDetailDTO salesLeadDetailDTO);
}
