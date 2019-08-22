package com.yihuisoft.authoritybiz.service.organization;

import com.yihuisoft.authoritybiz.dto.organization.OrganizationCheckDTO;
import com.yihuisoft.authoritybiz.dto.organization.OrganizationDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.organization.OrganizationDO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 机构管理接口定义
 * @author laijd
 * @version V4.0.0
 * @date 2019/6/28
 */
public interface OrganizationService {

    /**
     * 查询机构信息数据接口
     * @param organizationDTO
     * @return
     */
    OutDTO getOrganization(OrganizationDTO organizationDTO);

    /**
     * 根据机构编码查询单条机构信息,模块内和模块间调用
     * @param organizationCode
     * @return
     * */
    Organization getOrganizationInfo(String organizationCode);

    /**
     * 查询下级机构树接口
     * @param organizationDTO
     * @return
     * @throws ApplicationException
     */
    OutDTO listSubOrganizationsTree(OrganizationDTO organizationDTO) throws ApplicationException;
      /**
     * 根据机构code递归查询子机构及其下级所有机构
     * @param organizationDTO
     * @return
     */
    List<Organization> listSubOrganizations(OrganizationDTO organizationDTO);
    /***
     * 通过机构号查询三级行社  登录调用，客户管理调用
     * @param orgnCode
     * @return
     */
    Map<String, String> listOrgnCodeLv3ByOrgnCode(String orgnCode);
    /***
     * 通过行社号查询客户的查看权限 登录调用，客户管理调用
     * @param orgnCode
     * @return
     */
    String getCustDataAuth(String orgnCode);

    /**
     * 校验机构信息
     * @param organizationCheckDTO
     * orgnCode 根据机构编码检查机构是否可用
     * bankNo 查询行设号是否正确,原有的organizationMapper.selBankNo。终端管理调用
     * @return OutDTO
     */
    OutDTO checkOrganization(OrganizationCheckDTO organizationCheckDTO);
     /**
      * 根据机构ID数组，查询出对应机构信息并返回列表
      * @param organizationIdArray  机构ID数组
      * @return List<Organization>
      */
     OutDTO<OrganizationDO> listBatch(String[] organizationIdArray);
}
