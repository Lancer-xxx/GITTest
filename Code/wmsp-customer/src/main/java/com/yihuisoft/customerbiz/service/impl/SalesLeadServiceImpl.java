package com.yihuisoft.customerbiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.dto.permission.RoleDataPermissionSelectDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.permission.DataPermission;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.authoritybiz.service.permission.DataPermissionService;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.constant.CommonConstants;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.StringUtil;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.constant.ErrorResultEnum;
import com.yihuisoft.customerbiz.constant.SalesLeadConstant;
import com.yihuisoft.customerbiz.constant.SalesLeadRecordConstant;
import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanDTO;
import com.yihuisoft.customerbiz.dto.saleslead.BatchSalesLeadDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadDetailDTO;
import com.yihuisoft.customerbiz.dto.saleslead.SalesLeadListDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;
import com.yihuisoft.customerbiz.entity.SalesLeadOwnership;
import com.yihuisoft.customerbiz.entity.SalesLeadRecord;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;
import com.yihuisoft.customerbiz.mapper.saleslead.SalesLeadMapper;
import com.yihuisoft.customerbiz.service.SalesLeadOwnershipService;
import com.yihuisoft.customerbiz.service.SalesLeadRecordService;
import com.yihuisoft.customerbiz.service.SalesLeadService;
import com.yihuisoft.customerbiz.service.contactplan.ContactPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import java.time.Instant;
import java.util.*;

/**
 * 线索客户的服务
 * @author dim
 * @version V4.0.0
 * @date 2019/7/25
 */
@Service
public class SalesLeadServiceImpl implements SalesLeadService {

    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_LOG);
    protected Logger errorLogger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);
    @Autowired
    SalesLeadMapper salesLeadMapper;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserService userService;

    @Autowired
    SalesLeadRecordService salesLeadRecordService;

    @Autowired
    SalesLeadOwnershipService salesLeadOwnershipService;

    @Autowired
    DataPermissionService dataPermissionService;

    @Autowired
    ContactPlanService contactPlanService;

    /**
     * 新增线索客户
     * @param salesLead
     * @return
     */
    @Override
    public OutDTO<SalesLead> save(@Valid  SalesLead salesLead) {

        // 校验保存重复的id号码
        validateSavingRepeatedIdNumber(salesLead);
        // 校验备注太长

        // 客户状态
        salesLead.setSaleStatus(SalesLeadConstant.SALE_STATUS_SALES_LEAD);
        // 分配状态
        salesLead.setAssignStatus(SalesLeadConstant.ASSIGN_STATUS_UNASSIGNED);

        int result = salesLeadMapper.insert(salesLead);

        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();
        salesLeadRecord.setOperateType("创建");
        //id
        salesLeadRecord.setOperatorName(salesLead.getUserName());
        // role
        salesLeadRecord.setOperationDesc("新增线索" + salesLead.getUserName());
        salesLeadRecordService.save(salesLeadRecord);

        return result > 0 ? OutDTOFactory.getSucceedOutDTO().setStatus(OutDTOFactory.STATUS_FAIL): OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 新增销售线索
     * @param salesLead
     * @param user
     * @return
     */
    @Override
    public OutDTO<SalesLead> save(@Valid  SalesLead salesLead, User user) {
        addCreateOperationInfo(salesLead,user);

        // 存储数据 事务
        salesLead = this.saveAndGet(salesLead);

        SalesLeadOwnership salesLeadOwnership = SalesLeadOwnership.initSalesLeadOwnership(salesLead,user);
        salesLeadOwnershipService.save(salesLeadOwnership);

        SalesLeadRecord salesLeadRecord = SalesLeadRecord.initSalesLeadRecord(salesLead,user, SalesLeadRecordConstant.OPERATE_TYPE_SAVE);
        salesLeadRecordService.save(salesLeadRecord);

        return OutDTOFactory.getSucceedOutDTO();
    }

    public void addCreateOperationInfo(SalesLead salesLead,User loginedUser){
        salesLead.setCreateTime(Date.from(Instant.now()));
        if(loginedUser != null){
            salesLead.setCreatorUserId(Long.toString(loginedUser.getId()));
        }

        // 销售线索的组织机构信息
        salesLead.setOwnerOrganizationName(loginedUser.getOrgnName());
        salesLead.setOwnerOrganizationCode(loginedUser.getOrgnCode());
    }

    public void addUpdateOperationInfo(SalesLead salesLead,Long logonUserId){
        User user =  (User) userService.getUser(logonUserId).getInfoData();

        salesLead.setUpdateTime(Date.from(Instant.now()));
        if(user != null){
            salesLead.setUpdateUserId(Long.toString(user.getId()));
        }
    }

    public void validateSavingRepeatedIdNumber(SalesLead salesLead) throws ApplicationException {
        // 身份证号码 不为空，则校验 身份证唯一性
        if(salesLead.getIdType() == null || salesLead.getIdType().isEmpty() || salesLead.getIdNumber() == null || salesLead.getIdNumber().isEmpty()) {
            return;
        }

        Example IdSearchExample = new Example(SalesLead.class);
        IdSearchExample.createCriteria()
                .andEqualTo("idType",salesLead.getIdType())
                .andEqualTo("idNumber",salesLead.getIdNumber());

        List<SalesLead> salesLeads = salesLeadMapper.selectByExample(IdSearchExample);
        if (!salesLeads.isEmpty()){
            throw new ApplicationException(ErrorResultEnum.ERROR_SAVE_REPEATED_ID);
        }
    }

    public void validatePersistingRepeatedIdNumber(SalesLead salesLead) throws ApplicationException {
        // 身份证号码 不为空，则校验 身份证唯一性
        if(salesLead.getIdType() == null || salesLead.getIdType().isEmpty() || salesLead.getIdNumber() == null || salesLead.getIdNumber().isEmpty()) {
            return;
        }
        Example IdSearchExample = new Example(SalesLead.class);

        IdSearchExample.createCriteria()
                .andEqualTo("idType",salesLead.getIdType())
                .andEqualTo("idNumber",salesLead.getIdNumber())
                .andNotEqualTo("id",salesLead.getId());;

        List<SalesLead> salesLeads = salesLeadMapper.selectByExample(IdSearchExample);
        if (!salesLeads.isEmpty()){
            throw new ApplicationException(ErrorResultEnum.ERROR_SAVE_REPEATED_ID);
        }
    }

    public SalesLead saveAndGet(SalesLead salesLead) {
        // 校验保存重复的id号码
        validateSavingRepeatedIdNumber(salesLead);
        // 校验备注太长
        // 客户状态
        salesLead.setSaleStatus(SalesLeadConstant.SALE_STATUS_SALES_LEAD);
        // 分配状态
        assignState(salesLead);
        int result = salesLeadMapper.insert(salesLead);

        return salesLead;
    }

    static void assignState(SalesLead salesLead){
        if(salesLead != null && salesLead.getCustomerManager() != null){
            // 设置已经分配状态
            salesLead.setAssignStatus(SalesLeadConstant.ASSIGN_STATUS_ASSIGNED);
        }else{
            salesLead.setAssignStatus(SalesLeadConstant.ASSIGN_STATUS_UNASSIGNED);
        }
    }

    static void customerLinkState(SalesLead salesLead){
        if(salesLead != null && salesLead.getLinkedCustomerNo() != null){
            // 设置已经分配状态
            salesLead.setSaleStatus(SalesLeadConstant.SALE_STATUS_CUSTOMER);
        }
    }

    @Override
    public OutDTO<SalesLead> saveAndSelfAssign(SalesLead salesLead) {
        SalesLead salesLeadSaved = this.saveAndGet(salesLead);

        // 客户经理id 无法关联
        salesLead.getCustomerManager();

        String organizationCode = salesLead.getOwnerOrganizationCode();
        Organization org = organizationService.getOrganizationInfo(organizationCode);

        // 设置已分配状态
        assignState(salesLead);

        // 客户状态
        salesLead.setSaleStatus(SalesLeadConstant.SALE_STATUS_ALL);
        // 分配状态
        salesLead.setAssignStatus(SalesLeadConstant.ASSIGN_STATUS_ASSIGNED);
        salesLead.setCreateTime(Date.from(Instant.now()));
        // 检查存在性
        int result = salesLeadMapper.insert(salesLead);

        // 保存ownership
        SalesLeadOwnership salesLeadOwnership = new SalesLeadOwnership();

        salesLeadOwnership.setSalesLeadId(salesLeadSaved.getId());

        // 组织机构编码不能为空
        if(org != null){
            salesLeadOwnership.setOrganizationCode(org.getOrgnCode());
            salesLeadOwnership.setOrganizationId(org.getId());
        }

        salesLeadOwnershipService.save(salesLeadOwnership);

        // 保存操作记录
        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();
        salesLeadRecord.setOperateType("创建并自分配");
        //id
        salesLeadRecord.setOperatorName(salesLead.getUserName());
        // role
        salesLeadRecord.setOperationDesc("创建并自分配线索" + salesLead.getUserName());

        salesLeadRecordService.save(salesLeadRecord);
        return result > 0 ? OutDTOFactory.getSucceedOutDTO().setStatus(OutDTOFactory.STATUS_FAIL): OutDTOFactory.getSucceedOutDTO();

    }

    public void addAssignInfo(SalesLead salesLead,User user){
        salesLead.setAssignStatus(SalesLeadConstant.ASSIGN_STATUS_ASSIGNED);
        if(user != null){
            salesLead.setCustomerManager(user.getUserName());
            salesLead.setCustomerManagerWorkNo(user.getWorkNo());
            salesLead.setOwnerOrganizationCode(user.getOrgnCode());
            salesLead.setOwnerOrganizationName(user.getOrgnName());
        }
        salesLead.setUpdateTime(Date.from(Instant.now()));
        salesLead.setUpdateUserId(Long.toString(user.getId()));
    }

    @Override
    public OutDTO<SalesLead> saveAndSelfAssign(@Valid  SalesLead salesLead, User user) {
        addCreateOperationInfo(salesLead,user);
        addAssignInfo(salesLead,user);
        // 存储数据 事务
        salesLead = this.saveAndGet(salesLead);

        SalesLeadOwnership salesLeadOwnership = SalesLeadOwnership.selfAssignSalesLeadOwnership(salesLead,user);
        salesLeadOwnershipService.save(salesLeadOwnership);

        SalesLeadRecord salesLeadRecord = SalesLeadRecord.initSalesLeadRecord(salesLead,user, SalesLeadRecordConstant.OPERATE_TYPE_SAVE_AND_SELF_ASSIGN);
        salesLeadRecordService.save(salesLeadRecord);

        return OutDTOFactory.getSucceedOutDTO();
    }


    public static final int defaultPageNo = 1;

    public static final int defaultPageSize = 10;


    @Override
    public OutDTO<SalesLeadDetailDTO> list(PagerVO<SalesLeadListDTO> pagerVO) {
        List<SalesLeadDetailDTO> list;
        PageInfo<SalesLeadDetailDTO> page;
        User user = null;
        try {
            // 登录的用户信息
            //获取用户信息
            user=userService.getContextUser();
            if(user==null){
                return OutDTOFactory.getFailOutDTO(ErrorResultEnum.ERROR_NO_USER);
            }
            Long roleId = user.getRoleId();
            //查询机构序列
            String orgnInheritSign = organizationService.getOrganizationInfo(user.getOrgnCode()).getOrgnInheritSign();

            RoleDataPermissionSelectDTO roleDataPersionSelectDTO = new RoleDataPermissionSelectDTO();
            roleDataPersionSelectDTO.setRoleId(roleId);
            roleDataPersionSelectDTO.setType(CommonConstants.DATA_TYPE_ORGN_USER);
            //获取权限
            DataPermission dataPermission= dataPermissionService.getDataPersion(roleDataPersionSelectDTO).getInfoData();
            String dataAuth=null;
            if (!ObjectUtils.isEmpty(dataPermission)){
                dataAuth=dataPermission.getSubType();
                if (!StringUtil.isEmpty(dataAuth)){
                    logger.info("用户id"+user.getId()+"数据权限获取成功！");
                }else {
                    return OutDTOFactory.getFailOutDTO(ErrorResultEnum.ERROR_NO_USER_PERMISSION);
                }
            }
            SalesLeadListDTO salesLeadListDTO = pagerVO.getData();
            //userId
            salesLeadListDTO.setOwnerUserId(Long.toString(user.getId()));
            //数据权限
            salesLeadListDTO.setDataId(Integer.parseInt(dataAuth));
            //所属机构
            salesLeadListDTO.setOrgnCode(user.getOrgnCode());
            //机构序列
            salesLeadListDTO.setOrgnInheritSign(orgnInheritSign);

            // 分页查询，默认返回第一页，一页返回10条
            PageMessage pageMessage = PageMessage.check(pagerVO.getPageMessage());
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

            try {
                list = salesLeadMapper.listByDTO(pagerVO.getData());
                logger.info("线索列表数据查询成功！");
            } catch (Exception e) {
                errorLogger.error("列表查询失败!",e);
                throw new ApplicationException("列表查询失败",e);
            }

            // 用PageInfo对结果进行包装
            page = new PageInfo<>(list);
        } catch (Exception e) {
            errorLogger.error("列表查询出错",e);
            throw new ApplicationException("列表查询失败！",e);
        }

        // 封装返回信息
        return OutDTOFactory.getSucceedOutDTO()
                .putList(list)
                .setSumCount(page.getTotal());
    }

    @Override
    public OutDTO<SalesLead> updateCustomerManager(SalesLead salesLead) {
        // 保存操作记录
        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();
        salesLeadRecord.setOperateType("关联客户");
        //id
        salesLeadRecord.setOperatorName(salesLead.getUserName());
        // role
        salesLeadRecord.setOperationDesc("关联客户线索" + salesLead.getUserName());

        salesLeadRecordService.save(salesLeadRecord);

        // 线索状态
        customerLinkState(salesLead);
        salesLead.setUpdateTime(Date.from(Instant.now()));
        return CheckUtils.checkUpdate(salesLeadMapper.updateByPrimaryKey(salesLead)) ;
    }

    public void addUpdateInfo(SalesLead salesLead,User user){
        if(user != null){
            salesLead.setUpdateUserId(Long.toString(user.getId()));
        }
        salesLead.setUpdateTime(Date.from(Instant.now()));
    }

    @Override
    public OutDTO<SalesLead> update(SalesLead salesLead){
        // 需要更新 所属关系
        // 保存操作记录
        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();
        salesLeadRecord.setOperateType("更新");
        //id
        salesLeadRecord.setOperatorName(salesLead.getUserName());
        // role
        salesLeadRecord.setOperationDesc("更新客户线索" + salesLead.getUserName());
        salesLeadRecordService.save(salesLeadRecord);

        salesLead.setUpdateTime(Date.from(Instant.now()));

        return CheckUtils.checkUpdate(salesLeadMapper.updateByPrimaryKeySelective(salesLead));
    }

    @Override
    public OutDTO<SalesLead> update(SalesLead salesLead, User user) {
        addUpdateInfo(salesLead,user);

        validatePersistingRepeatedIdNumber(salesLead);
        // 由于线索变更，联络计划也变更
        if(!ObjectUtils.isEmpty(salesLead.getUserName()) || !ObjectUtils.isEmpty(salesLead.getPhone())){
            ContactPlan contactPlan = new ContactPlan();

            contactPlan.setPhone(salesLead.getPhone());
            contactPlan.setCustomerName(salesLead.getUserName());

            contactPlanService.updateByContactInfoChange(contactPlan);
        }

        return CheckUtils.checkUpdate(salesLeadMapper.updateByPrimaryKeySelective(salesLead));
    }


    /**
     * 批量分配
     * @param batchSalesLeadDTO
     * @param user
     * @param assigner
     * @return
     */
    @Override
    public OutDTO<SalesLead> assignBatch(BatchSalesLeadDTO batchSalesLeadDTO,User user,User assigner) {

        Example example = new Example(SalesLead.class);
        example.createCriteria().andIn("id",batchSalesLeadDTO.getSalesLeadList());

        // 更新分配状态
        SalesLead salesLead = new SalesLead();
        addAssignInfo(salesLead,user);
        salesLeadMapper.updateByExampleSelective(salesLead ,example);

        //更新分配权限
        salesLeadOwnershipService.assignBatchSalesLead(batchSalesLeadDTO.getSalesLeadList(),user);

        // 保存操作记录
        batchSalesLeadDTO.getSalesLeadList().forEach(

            salesLeadId -> {
                salesLead.setId(salesLeadId);
                salesLeadRecordService.save(SalesLeadRecord
                        .initSalesLeadRecord(salesLead,user,SalesLeadRecordConstant.OPERATE_TYPE_ASSIGN,batchSalesLeadDTO.getOperationDesc())
                        .addAssignerInfo(assigner)
                );
            }
        );

        // 分配的时候，取消电访计划
        cancelContactPlans(batchSalesLeadDTO);
        return OutDTOFactory.getSucceedOutDTO();
    }


    public OutDTO cancelContactPlans(BatchSalesLeadDTO batchSalesLeadDTO){
        // 取消对应的电访信息
        BatchContactPlanDTO batchContactPlanDTO = new BatchContactPlanDTO();
        batchContactPlanDTO.setCustomerType(ContactPlanConstant.TYPE_SALES_LEAD);
        Set<Long> idSet = new HashSet<>();
        idSet.addAll(batchSalesLeadDTO.getSalesLeadList());
        batchContactPlanDTO.setIdSet(idSet);

        return contactPlanService.updateBatchContactInfo(contactPlanService.getContactInfo(batchContactPlanDTO));
    }

    @Override
    public OutDTO<SalesLead> assign(SalesLead salesLead) {
        // 保存操作记录
        SalesLeadRecord salesLeadRecord = new SalesLeadRecord();
        salesLeadRecord.setOperateType("分配");
        //id
        salesLeadRecord.setOperatorName(salesLead.getUserName());
        // role
        salesLeadRecord.setOperationDesc("分配客户线索" + salesLead.getUserName());
        salesLeadRecordService.save(salesLeadRecord);

        assignState(salesLead);
        return this.update(salesLead);
    }

    @Override
    public OutDTO<SalesLead> delete(SalesLead salesLead) {
        int delete = salesLeadMapper.delete(salesLead);

        // 删除的时候，也对电访计划进行取消
        BatchSalesLeadDTO batchSalesLeadDTO = new BatchSalesLeadDTO();
        Set<Long> idSet = new HashSet<>();
        idSet.add(salesLead.getId());
        batchSalesLeadDTO.setSalesLeadList(idSet);
        this.cancelContactPlans(batchSalesLeadDTO);
        return CheckUtils.checkDelete(delete);
    }

    @Override
    public OutDTO<SalesLead> delete(SalesLead salesLead,User user){
        try{
            validateUserHasDataOwnership(salesLead,user);
        }catch (ApplicationException e){
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg(e.getErrMsg()) ;
        }
        return this.delete(salesLead);
    }

    public void validateUserHasDataOwnership(SalesLead salesLead,User user) throws ApplicationException{
        if(salesLead == null){
            return;
        }

        SalesLeadOwnership ownerOfSalesLead;
        try{
            ownerOfSalesLead  = salesLeadOwnershipService.getOwnerOfSalesLead(salesLead);
        }catch (Exception e){
            throw new ApplicationException("查询线索所属者信息失败！",e);
        }

        // 判断是否拥有线索信息的数据权限
        if(ownerOfSalesLead == null ||ownerOfSalesLead.getCustomerManagerId() == null
                || !user.getId().equals(ownerOfSalesLead.getCustomerManagerId()) ){
            throw new ApplicationException(ErrorResultEnum.ERROR_HAS_NO_DATA_ACCESS_PREVILLEGE);
        }
    }

    @Override
    public OutDTO<SalesLead> get(SalesLead salesLead) {
        SalesLead salesLeadData = salesLeadMapper.selectByPrimaryKey(salesLead.getId());
        return OutDTOFactory.getSucceedOutDTO()
                .putInfo(salesLeadData);
    }

    @Override
    public OutDTO<SalesLeadDetailDTO> getDetail(SalesLeadDetailDTO salesLeadDetailDTO) {
        if(salesLeadDetailDTO == null || salesLeadDetailDTO.getId() == null){
            return OutDTOFactory.getSucceedOutDTO()
                    .putInfo(null);
        }

        SalesLeadDetailDTO salesLeadDetailData = salesLeadMapper.getDetail(salesLeadDetailDTO);
        return OutDTOFactory.getSucceedOutDTO()
                .putInfo(salesLeadDetailData);
    }


}
