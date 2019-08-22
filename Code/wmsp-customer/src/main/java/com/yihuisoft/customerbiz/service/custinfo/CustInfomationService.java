package com.yihuisoft.customerbiz.service.custinfo;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.customerbiz.dto.custinfo.CustInfomationListDTO;
import com.yihuisoft.customerbiz.entity.custinfo.CustInfomation;

/**
  * 客户信息服务接口层
  * @author topz
  * @date 2019/8/8 14:41
  * @version V4.0.0
  **/
public interface CustInfomationService {

    /**
     * 查询客户列表（1.权限查询 2.条件查询 3.排序功能）
     * @author topz
     * @param paramdto 分页条件传参
     * @param pageMessage 分页信息
     * @return com.yihuisoft.common.dto.OutDTO<com.yihuisoft.customerbiz.entity.custinfo.CustInfomation>
     * @date 16:55 2019/8/8
     **/
    OutDTO<CustInfomation> list(CustInfomationListDTO paramdto, PageMessage pageMessage);
}
