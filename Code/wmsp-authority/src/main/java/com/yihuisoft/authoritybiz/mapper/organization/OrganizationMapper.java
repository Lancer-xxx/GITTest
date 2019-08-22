package com.yihuisoft.authoritybiz.mapper.organization;

import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.organization.OrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 机构信息mapper
 * @author laijd
 * @version V4.0.0
 * @date 2019/6/28
 */
@Mapper
@Repository
public interface OrganizationMapper {
    /**
     * 查询机构信息
     * @param organization 机构实体
     * @return
     */
    Organization getOrganization(Organization organization);
    /**
     * 根据当前机构code查询下一级机构集合
     * @param organizationCode 机构编码
     * @return List<Organization>
     */
    List<Organization> getChildrenByCode(String organizationCode);

    /**
     * 根据机构code递归查询子机构及其下级所有机构
     * @param organization 机构实体
     * @return List<Organization>
     */
    List<Organization> listSubOrganizations(Organization organization);


    /***
     * 通过机构号查询三级行社  登录调用，客户管理调用
     * @param orgnCode 机构编码
     * @return Map<String, String>
     */
    Map<String, String> listOrgnCodeLv3ByOrgnCode(@Param("orgnCode")String orgnCode);

    /***
     * 通过行社号查询客户的查看权限 登录调用，客户管理调用
     * @param orgnCode 机构编码
     * @return String
     */
    String getCustDataAuth(@Param("orgnCode")String orgnCode);
    /***
     * 根据条件查询机构条数
     * @param organization
     * @return int
     */
    int checkOrganization(Organization organization);
     /**
      * 根据机构ID数组查找对应的机构信息列表
      * @param organizationIdArray 机构ID数组
      * @return List<OrganizationDO> 返回机构信息列表
      */
    List<OrganizationDO> listBatch(@Param("organizationIdArray") String[] organizationIdArray);

    List<Long> listChildrensOrgnIds(@Param("orgnInheritSign") String orgnInheritSign);
}
