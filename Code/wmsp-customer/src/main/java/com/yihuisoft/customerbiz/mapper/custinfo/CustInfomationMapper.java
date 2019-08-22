package com.yihuisoft.customerbiz.mapper.custinfo;

import com.yihuisoft.customerbiz.entity.custinfo.CustBaseInfomation;
import com.yihuisoft.customerbiz.entity.custinfo.CustInfomation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Mapper
public interface CustInfomationMapper {

    /**
      * 查询客户列表（1.权限查询 2.条件查询 3.排序功能）
      * @author topz
      * @param custInfoMap 传入客户列表查询参数
      * @param authInfoMap 传入对应参权限数
      * @return java.util.List<com.yihuisoft.customerbiz.entity.custinfo.CustInfomation>
      * @date 14:32 2019/8/8
      **/
    List<CustInfomation> list(@Param("custInfoMap") Map custInfoMap, @Param("authInfoMap") Map authInfoMap);

    /**
      * 根据客户id更新客户的：1.最后电访时间 2.最新计划电访时间 3。是否有未执行电访计划信息
      * @author topz
      * @param record xxxxx
      * @return int
      * @date 20:07 2019/8/8
      **/
    int updateCallRecord(CustBaseInfomation record);
}