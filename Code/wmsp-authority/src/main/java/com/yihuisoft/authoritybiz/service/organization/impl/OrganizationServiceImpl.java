package com.yihuisoft.authoritybiz.service.organization.impl;

import com.yihuisoft.authoritybiz.dto.organization.OrganizationCheckDTO;
import com.yihuisoft.authoritybiz.dto.organization.OrganizationDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.organization.OrganizationDO;
import com.yihuisoft.authoritybiz.entity.organization.OrganizationTree;
import com.yihuisoft.authoritybiz.mapper.organization.OrganizationMapper;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.StringUtil;
import com.yihuisoft.common.util.app.OutDTOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 机构管理实现类
 * @author laijd
 * @version V4.0.0
 * @date 2019/7/3
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    OrganizationMapper organizationMapper;
    /**
     * 查询机构信息数据接口
     * @param organizationDTO
     * @return
     */
    @Override
    public OutDTO<Organization> getOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        CopyUtils.copy(organizationDTO,organization);
        Organization responseOrganization = organizationMapper.getOrganization(organization);
        return OutDTOFactory.getSucceedOutDTO().putInfo(responseOrganization);
    }

    /**
     * 根据机构编码查询单条机构信息,模块内和模块间调用
     * @param organizationCode
     * @return
     */
    @Override
    public Organization getOrganizationInfo(String organizationCode) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setOrgnCode(organizationCode);
        return (Organization) this.getOrganization(organizationDTO).get(OutDTO.RESULT_INFO);
    }

    /**
     * 查询下级机构树接口
     * @param organizationDTO
     * @return
     */
    @Override
    public OutDTO listSubOrganizationsTree(OrganizationDTO organizationDTO) throws ApplicationException {
        Organization organization = new Organization();
        CopyUtils.copy(organizationDTO,organization);
        Organization o = organizationMapper.getOrganization(organization);
        OrganizationTree organizationTree = new OrganizationTree();
        if(o == null){
            throw  new ApplicationException(ResultEnum.ERROR_AUTHORITY_ORGANIZATION_LIST);
        }else{
            List<OrganizationTree> organizationTrees = new ArrayList<>();
            organizationTree.setId(o.getOrgnCode());
            organizationTree.setTitle(o.getOrgnName()+" || "+o.getOrgnCode());
            List<Organization> list = organizationMapper.getChildrenByCode(o.getOrgnCode());
            for (Organization org : list) {
                OrganizationTree organizationTree1 = new OrganizationTree();
                organizationTree1.setId(org.getOrgnCode());
                organizationTree1.setTitle(org.getOrgnName()+" || "+org.getOrgnCode());
                organizationTrees.add(organizationTree1);
            }
            organizationTree.setChildren(organizationTrees);
        }
        return OutDTOFactory.getSucceedOutDTO().putInfo(organizationTree);
    }
    /**
     * 前端展示 DlfrFlag == 1 判断为多法人机构
     *                 != 1 判断为非多法人机构，
     * 如果等于null，则无法判断，
     * 而机构信息一般通过初始化和跑批的形式新增，在此处增加 null转为0 的逻辑
     * @param source 要修改的数据
     * @return
     */
    private String setDlfrFlagNotNUll(String source){
        if(StringUtil.isEmpty(source)){
            source = "0";
        }
        return source;
    }
    /**
     * 根据机构code递归查询子机构及其下级所有机构
     * @param organizationDTO
     * @return
     */
    @Override
    public List<Organization> listSubOrganizations(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        CopyUtils.copy(organizationDTO,organization);
        return organizationMapper.listSubOrganizations(organization);
    }

    /***
     * 通过机构号查询三级行社  登录调用，客户管理调用
     * @param orgnCode 机构编码
     * @return
     */
    @Override
    public Map<String, String> listOrgnCodeLv3ByOrgnCode(String orgnCode) {
        return organizationMapper.listOrgnCodeLv3ByOrgnCode(orgnCode);
    }

    /***
     * 通过行社号查询客户的查看权限 登录调用，客户管理调用
     * @param orgnCode 机构编码
     * @return
     */
    @Override
    public String getCustDataAuth(String orgnCode) {
        return organizationMapper.getCustDataAuth(orgnCode);
    }

    /**
     * 校验机构信息
     * @param organizationCheckDTO
     * @return OutDTO
     */
    @Override
    public OutDTO checkOrganization(OrganizationCheckDTO organizationCheckDTO) {
        Organization organization = new Organization();
        CopyUtils.copy(organizationCheckDTO,organization);
        int count = organizationMapper.checkOrganization(organization);
        if(count == 0){
            return OutDTOFactory.getSuccessOutDTONotExist().setErrorMsg("机构不存在");
        }
        return OutDTOFactory.getSuccessOutDTOExist().setErrorMsg("机构存在");
    }

    /**
     * 根据机构ID数组，查询出对应机构信息并返回列表
     *
     * @param organizationIdArray 机构ID数组，不可为空
     * @return OutDTO
     */
    @Override
    public OutDTO<OrganizationDO> listBatch(String[] organizationIdArray) {
        List<OrganizationDO> organizationDOList;
        try{
            if(ObjectUtils.isEmpty(organizationIdArray)){
                logger.info("listBatch:"+ResultEnum.ERROR_AUTHORITY_NOT_NULL_ORGANISATION_ID.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_NOT_NULL_ORGANISATION_ID);
            }
            organizationDOList = organizationMapper.listBatch(organizationIdArray);
            return OutDTOFactory.getSucceedOutDTO().putList(organizationDOList);
        }catch (Exception e){
            logger.error("listBatch："+e.getMessage());
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_SYSTEM_REQUEST);
        }
    }
}
