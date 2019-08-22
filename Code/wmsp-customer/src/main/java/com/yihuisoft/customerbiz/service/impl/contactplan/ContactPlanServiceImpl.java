package com.yihuisoft.customerbiz.service.impl.contactplan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.customerbiz.constant.ErrorResultEnum;
import com.yihuisoft.customerbiz.constant.contactplan.ContactPlanConstant;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanDTO;
import com.yihuisoft.customerbiz.dto.contactplan.BatchContactPlanSaveDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanAggregationDTO;
import com.yihuisoft.customerbiz.dto.contactplan.ContactPlanListDTO;
import com.yihuisoft.customerbiz.entity.SalesLead;
import com.yihuisoft.customerbiz.entity.SalesLeadContact;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlan;
import com.yihuisoft.customerbiz.entity.contactplan.ContactPlanOwnership;
import com.yihuisoft.customerbiz.entity.custinfo.CustBaseInfomation;
import com.yihuisoft.customerbiz.entity.custinfo.CustomerOwner;
import com.yihuisoft.customerbiz.mapper.contactplan.ContactPlanMapper;
import com.yihuisoft.customerbiz.mapper.contactplan.ContactPlanOwnershipMapper;
import com.yihuisoft.customerbiz.mapper.custinfo.CustomerBaseInfoMapper;
import com.yihuisoft.customerbiz.mapper.custinfo.CustomerOwnerMapper;
import com.yihuisoft.customerbiz.mapper.saleslead.SalesLeadContactMapper;
import com.yihuisoft.customerbiz.service.SalesLeadOwnershipService;
import com.yihuisoft.customerbiz.service.contactplan.ContactPlanService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * 联络计划的接口服务类
 * @author dim
 * @date 2019/8/9
 */
@Service
public class ContactPlanServiceImpl/* extends CommonServiceImpl<ContactPlan>*/ implements ContactPlanService {

    @Autowired
    ContactPlanMapper contactPlanMapper;

    @Autowired
    ContactPlanOwnershipMapper contactPlanOwnershipMapper;

    @Autowired
    SalesLeadOwnershipService salesLeadOwnershipService;

    @Autowired
    CustomerOwnerMapper customerOwnerMapper;

    @Autowired
    UserService userService;
    /**
     * 通过客户 制定联络计划
     * @param contactPlan
     * @param user
     * @return
     */
    @Override
    public OutDTO saveWithCustomer(ContactPlan contactPlan,User user) {
        validateUserHasResourcePermission(user,contactPlan);

        contactPlan.setCustomerType(ContactPlanConstant.TYPE_CUSTOMER);

        // 保存 联络计划的数据
        this.saveContactPlan(contactPlan);

        // 更新维护 客户的联络信息
        updateContactInfo(contactPlan);
        return OutDTOFactory.getSucceedOutDTO();
    }

    // 校验时间
    public void validateUserHasResourcePermission(User user,ContactPlan contactPlan){

        boolean userHasDataPermission = true;
       /* // 客户资源
        if (contactPlan.isCustomerResource() ){

        }

        // 线索资源
        if(contactPlan.isSalesLeadResource()){

        }

        if(!userHasDataPermission){
            throw new ApplicationException(ContactPlanError);
        }*/
    }

    /**
     * 通过销售线索制定联络计划
     * @param contactPlan
     * @param user
     * @return
     */
    @Override
    public OutDTO saveWithSalesLead(ContactPlan contactPlan,User user) {
        // 校验用户是否有数据权限
        validateUserHasResourcePermission(user,contactPlan);

        contactPlan.setContactType(ContactPlanConstant.TYPE_SALES_LEAD);

        // 保存联络计划 数据对象
        this.saveContactPlan(contactPlan);

        // 更新维护 线索的联络信息
        updateContactInfo(contactPlan);
        return OutDTOFactory.getSucceedOutDTO();
    }


    /**
     * 保存联络计划的数据
     * @param contactPlan
     * @return
     */
    public OutDTO saveContactPlan(ContactPlan contactPlan){
        // 校验手机号码
        validatePhone(contactPlan);
        // 校验电访时间
        validatePlanTime(contactPlan.getPlanTime());

        contactPlan.setPlanStatus(ContactPlanConstant.STATUS_UN_EXECUTED);
        contactPlan.setCreateTime(Date.from(Instant.now()));

        if (contactPlan.getContactResourceId() == null){
            throw  new ApplicationException(ErrorResultEnum.ERROR_SAVING_EMPTY_CONTACT);
        }

       contactPlanMapper.insert(contactPlan);

        // 保存联络计划的 所属信息
        this.saveContactPlanOwnership(contactPlan);

        return OutDTOFactory.getSucceedOutDTO();
    }

    public Long getCustomerOwnerId(ContactPlan contactPlan){
        boolean isCutomerResource =  isCustomerResource(contactPlan.getCustomerType());

        boolean isSalesLeadResource = isSalesLeadResource(contactPlan.getCustomerType());

        if(isCutomerResource){
            Example example = new Example(CustomerOwner.class);
            example.createCriteria()
                    .andEqualTo("custId",contactPlan.getContactResourceId());
            CustomerOwner customerOwner = customerOwnerMapper.selectOneByExample(example);

            return  customerOwner.getCustId();
        }

        if(isSalesLeadResource){
            SalesLead salesLead = new SalesLead();
            salesLead.setId(contactPlan.getContactResourceId());

            return salesLeadOwnershipService.getOwnerOfSalesLead(salesLead).getCustomerManagerId();
        }

        return null;
    };

    public OutDTO saveContactPlanOwnership(ContactPlan contactPlan){

        Long customerOwnerId = getCustomerOwnerId(contactPlan);

        ContactPlanOwnership contactPlanOwnership = ContactPlanOwnership.getContactPlanOwnership(contactPlan,userService.getContextUser());
        contactPlanOwnership.setCustomerOwnerId(customerOwnerId);
        contactPlanOwnership.setCustomerType(contactPlan.getCustomerType());

        contactPlanOwnershipMapper.insert(contactPlanOwnership);
        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 校验电访计划时间 必须在当前时间，一分钟之后
     * @param planTime
     */
    private void validatePlanTime(Date planTime) {
        if(planTime == null){
            throw new ApplicationException(ErrorResultEnum.NO_PLAN_TIME_ERROR);
        }

        Date now = Date.from(Instant.now());

        if(DateUtils.addMinutes(planTime,1).before(now)){
            throw  new ApplicationException(ErrorResultEnum.PLAN_TIME_INVALID_ERROR);
        }
    }

    /**
     * 校验手机 必须是符合手机号码的
     * @param contactPlan
     */
    private void validatePhone(ContactPlan contactPlan) {

        boolean isValidPhone = false;

        final String phoneRegex  = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        isValidPhone = contactPlan.getPhone().matches(phoneRegex);

        if (!isValidPhone){
            switch (contactPlan.getCustomerType()){
                case ContactPlanConstant
                        .TYPE_CUSTOMER      : throw new ApplicationException(ErrorResultEnum.SAVING_INVALID_CUSTOMER_PHONE_ERROR);
                case ContactPlanConstant
                        .TYPE_SALES_LEAD    : throw new ApplicationException(ErrorResultEnum.SAVING_INVALID_SALESLEAD_PHONE_ERROR);
            }
        }
    }


    /**
     * 批量制定联络计划
     * @param batchContactPlanSaveDTO
     * @return
     */
    @Override
    public OutDTO<ContactPlan> saveBatch(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {

        boolean isCutomerResource =  isCustomerResource(batchContactPlanSaveDTO.getCustomerType());

        boolean isSalesLeadResource = isSalesLeadResource(batchContactPlanSaveDTO.getCustomerType());

        if(isCutomerResource){
            return this.saveBulkPlanWithCustomer(batchContactPlanSaveDTO);
        }

        if(isSalesLeadResource){
            return this.saveBulkPlanWithSalesLead(batchContactPlanSaveDTO);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 判断是否是客户资源
     * @param customerType
     * @return
     */
    public boolean isCustomerResource(String customerType) {
        return ContactPlanConstant.TYPE_CUSTOMER.equals(customerType);
    }

    /**
     * 判断是否是线索线索的客户资源
     * @param customerType
     * @return
     */
    public boolean isSalesLeadResource(String customerType) {
        return ContactPlanConstant.TYPE_SALES_LEAD.equals(customerType);
    }

    /**
     * 保存客户的批量联络计划
     * @param batchContactPlanSaveDTO
     * @return
     */
    private OutDTO<ContactPlan> saveBulkPlanWithCustomer(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {
        List<ContactPlan> contactPlans = ContactPlan.getContactPlansWithCustomers(batchContactPlanSaveDTO);
        // 保存批量对象
        this.saveBulkPlans(contactPlans);

        // 维护批量的客户的电访联络信息
        updateContactsInfo(batchContactPlanSaveDTO);
        return OutDTOFactory.getSucceedOutDTO();

    }


    /**
     * 保存线索的批量联络计划
     * @param batchContactPlanSaveDTO
     * @return
     */
    private OutDTO<ContactPlan> saveBulkPlanWithSalesLead(BatchContactPlanSaveDTO batchContactPlanSaveDTO) {
        List<ContactPlan> contactPlans = ContactPlan.getContactPlansWithSalesLeads(batchContactPlanSaveDTO);
        this.saveBulkPlans(contactPlans);

        // 维护批量的电访联络信息
        updateContactsInfo(batchContactPlanSaveDTO);
        return OutDTOFactory.getSucceedOutDTO();
    }

    private List<ContactPlan> saveBulkPlans(List<ContactPlan> contactPlans){
        final AtomicBoolean hasError = new AtomicBoolean(false);
        contactPlans.forEach(
                contactPlan -> {
                    try {
                        this.saveContactPlan(contactPlan);
                    }catch (Exception e) {
                        hasError.set(true);
                    }
                }

        );

        return contactPlans;
    }

    /**
     * 批量更新
     * @param batchContactPlanDTO
     * @return
     */
    @Override
    public OutDTO<ContactPlan> updateBatch(BatchContactPlanDTO batchContactPlanDTO) {
        ContactPlan contactPlan2Persist = ContactPlan.getUpdateContactPlan(batchContactPlanDTO);

        Example example = new Example(ContactPlan.class);
        example.createCriteria()
                .andIn("id",batchContactPlanDTO.getIdSet());

        // 完成的时候
        Date now = Date.from(Instant.now());

        // 未执行的修改
        if (ContactPlanConstant.STATUS_UN_EXECUTED.equals(contactPlan2Persist.getPlanStatus())){
            validatePlanTime(contactPlan2Persist.getPlanTime());
        }
        if(ContactPlanConstant.STATUS_COMPLETED.equals(contactPlan2Persist.getPlanStatus())){
            contactPlan2Persist.setContactTime(now);
        }
        contactPlan2Persist.setUpdateTime(now);

        contactPlanMapper.updateByExampleSelective(contactPlan2Persist,example);

        // 更新电访联络信息
        updateBatchContactInfo(getContactInfo(batchContactPlanDTO));

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 批量取消联络计划
     * @param batchContactPlanDTO
     * @return
     */
    @Override
    public OutDTO<ContactPlan> cancelBatchContactPlan(BatchContactPlanDTO batchContactPlanDTO) {
        Example example = new Example(ContactPlan.class);
        example.createCriteria()
                .andIn("id",batchContactPlanDTO.getIdSet());

        ContactPlan contactPlan = new ContactPlan();
        contactPlan.setPlanStatus(ContactPlanConstant.STATUS_CANCELED);

        contactPlanMapper.updateByExampleSelective(contactPlan,example);

        // 更新电访联络信息
        updateBatchContactInfo(getContactInfo(batchContactPlanDTO));

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 查询联络计划列表
     * @param pagerVO
     * @return
     */
    @Override
    public OutDTO<ContactPlan> listPagerByDTO(PagerVO<ContactPlanListDTO> pagerVO) {

        // 检查分页信息
        PageMessage pageMessage = PageMessage.check(pagerVO.getPageMessage());
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

        List<ContactPlan> contactPlans = contactPlanMapper.listByDTO(pagerVO.getData());

        List<ContactPlan> contactPlanList = contactPlans.stream().map(contactPlan -> {
            if(isCustomerResource(contactPlan.getCustomerType())){
                contactPlan.setCustomerId(contactPlan.getContactResourceId());
            }

            if(isSalesLeadResource(contactPlan.getCustomerType())){
                contactPlan.setSalesLeadId(contactPlan.getContactResourceId());
            }

            return contactPlan;
        }).collect(Collectors.toList());

        // 用PageInfo对结果进行包装
        PageInfo<ContactPlan> page = new PageInfo(contactPlans);
        return OutDTOFactory.getSucceedOutDTO().putList(contactPlanList).setSumCount(page.getTotal());
    }

    /**
     * 联络计划的修改
     * @param contactPlan
     * @return
     */
    @Override
    public OutDTO update(ContactPlan contactPlan) {
        Example example = new Example(ContactPlan.class);
        example.createCriteria()
                .andEqualTo("id",contactPlan.getId());

        ContactPlan contactPlan2Persist = new ContactPlan();

        contactPlan2Persist.setPlanStatus(contactPlan.getPlanStatus());
        contactPlan2Persist.setPlanTime(contactPlan.getPlanTime());
        contactPlan2Persist.setContactType(contactPlan.getContactType());
        contactPlan2Persist.setRemark(contactPlan.getRemark());
        contactPlan2Persist.setContactObjective(contactPlan.getContactObjective());

        // 完成的时候
        Date now = Date.from(Instant.now());

        // 未执行的修改
        if (ContactPlanConstant.STATUS_UN_EXECUTED.equals(contactPlan2Persist.getPlanStatus())){
           validatePlanTime(contactPlan2Persist.getPlanTime());
        }
        if(ContactPlanConstant.STATUS_COMPLETED.equals(contactPlan2Persist.getPlanStatus())){
            contactPlan2Persist.setContactTime(now);
        }
        contactPlan2Persist.setUpdateTime(now);

        contactPlanMapper.updateByExampleSelective(contactPlan2Persist,example);
        updateContactInfo(contactPlan2Persist);

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 查询线索或者客户的，联络信息；用于维护
     * @param batchContactPlanDTO
     * @return
     */
    @Override
    public List<ContactPlanAggregationDTO> getContactInfo(BatchContactPlanDTO batchContactPlanDTO){

        List<ContactPlanAggregationDTO> contactPlanAggregationDTOS = contactPlanMapper.getContactsInfo(batchContactPlanDTO);


        /*List<ContactPlanAggregationDTO> contactPlanAggregationDTOResult =
                contactPlanAggregationDTOS.stream()
                .map(contactPlanAggregationDTO -> {
                    contactPlanAggregationDTO.setCustomerType(batchContactPlanDTO.getCustomerType());
                    return contactPlanAggregationDTO;
                }).collect(Collectors.toList());*/

        return contactPlanAggregationDTOS;
    }


    /**
     * 维护 批量操作的 线索或者客户的联络信息
     * @param contactPlanAggregationDTOList
     * @return
     */
    @Override
    public OutDTO updateBatchContactInfo(List<ContactPlanAggregationDTO> contactPlanAggregationDTOList){

        contactPlanAggregationDTOList.forEach(
                contactPlanAggregationDTO -> {
                    updateContactInfo(contactPlanAggregationDTO);
                }
        );

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 更新 线索或者客户 对应的联络信息
     * @param contactPlanAggregationDTO
     */
    private void updateContactInfo(ContactPlanAggregationDTO contactPlanAggregationDTO) {
        if(isSalesLeadResource(contactPlanAggregationDTO.getCustomerType())){
            SalesLeadContact salesLeadContact = SalesLeadContact.getContactInfo4SalesLead(contactPlanAggregationDTO);

            Example example = new Example(SalesLeadContact.class);
            example.createCriteria()
                    .andEqualTo("contactResourceId",contactPlanAggregationDTO.getContactResourceId());

            // save or update
            if(salesLeadContactMapper.selectOneByExample(example) != null){
                salesLeadContactMapper.updateByExampleSelective(salesLeadContact,example);
            }else{
                salesLeadContactMapper.insert(salesLeadContact);
            }
        }

        if(isCustomerResource(contactPlanAggregationDTO.getCustomerType())){
            CustBaseInfomation custBaseInfomation = CustBaseInfomation.getCustBaseInfo4ContactPlan(contactPlanAggregationDTO);
            customerBaseInfoMapper.updateByPrimaryKeySelective(custBaseInfomation);
        }
    }

    /**
     * 查询单个线索或者客户的，联络信息；用于维护
     * @param contactPlan
     * @return
     */
    public ContactPlanAggregationDTO getContactInfo(ContactPlan contactPlan){
        ContactPlanAggregationDTO result = contactPlanMapper.getContactInfo(contactPlan);


        result = result ==  null? ContactPlanAggregationDTO.getDefaultInstance(contactPlan.getContactResourceId()) : result;

        result.setCustomerType(contactPlan.getCustomerType());
        return result;
    }

    @Autowired
    SalesLeadContactMapper salesLeadContactMapper;

    @Autowired
    CustomerBaseInfoMapper customerBaseInfoMapper;

    /**
     * 更新线索的 电访联络信息
     * @param contactPlan
     * @return
     */
    public OutDTO updateContactInfo4SalesLead(ContactPlan contactPlan){
        ContactPlanAggregationDTO contactPlanAggregationDTO = getContactInfo(contactPlan);

        SalesLeadContact salesLeadContact = SalesLeadContact.getContactInfo4SalesLead(contactPlanAggregationDTO);


        Example example = new Example(ContactPlan.class);
        example.createCriteria()
                .andEqualTo("contactResourceId",contactPlan.getContactResourceId());


        // save or update
        if(salesLeadContactMapper.selectOneByExample(example) != null){
            salesLeadContactMapper.updateByExampleSelective(salesLeadContact,example);
        }else{
            salesLeadContactMapper.insert(salesLeadContact);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }

    /**
     * 更新客户的 电访联络信息
     * @param contactPlan
     * @return
     */
    public OutDTO updateContactInfo4Customer(ContactPlan contactPlan){
        ContactPlanAggregationDTO contactPlanAggregationDTO = getContactInfo(contactPlan);
        CustBaseInfomation custBaseInfomation = CustBaseInfomation.getCustBaseInfo4ContactPlan(contactPlanAggregationDTO);
        customerBaseInfoMapper.updateByPrimaryKeySelective(custBaseInfomation);

        return OutDTOFactory.getSucceedOutDTO();
    }


    /**
     * 维护 线索的电访信息
     * @param contactPlan
     * @return
     */
    public OutDTO updateContactInfo(ContactPlan contactPlan) {
        if(isSalesLeadResource(contactPlan.getCustomerType())){
            return updateContactInfo4SalesLead(contactPlan);
        }


        if(isCustomerResource(contactPlan.getCustomerType())){
            return updateContactInfo4Customer(contactPlan);
        }

        return OutDTOFactory.getSucceedOutDTO();
    }

    public OutDTO updateContactsInfo(BatchContactPlanSaveDTO batchContactPlanSaveDTO){
        BatchContactPlanDTO batchContactPlanDTO = new BatchContactPlanDTO();
        batchContactPlanDTO.setIdSet(new HashSet<>());
        BeanUtils.copyProperties(batchContactPlanSaveDTO,batchContactPlanDTO);
        batchContactPlanSaveDTO.getContactList().forEach(
                contactDTO -> {
                    batchContactPlanDTO.getIdSet().add(contactDTO.getId());
                }
        );

        // 更新批量 的联络对象的操作信息
        return  this.updateBatchContactInfo(getContactInfo(batchContactPlanDTO));
    }

    /**
     * 批量更新联络计划的信息
     * @param contactPlan
     * @return
     */
    @Override
    public OutDTO updateByContactInfoChange(ContactPlan contactPlan) {

        Example example = new Example(ContactPlan.class);
        example.createCriteria()
                .andEqualTo("contactResourceId",contactPlan.getContactResourceId())
                .andEqualTo("customerType",contactPlan.getCustomerType())
                .andEqualTo("planStatus",ContactPlanConstant.STATUS_UN_EXECUTED);

        ContactPlan contactPlan2Update = new ContactPlan();
        contactPlan2Update.setPhone(contactPlan.getPhone());
        contactPlan2Update.setCustomerName(contactPlan.getCustomerName());

        contactPlanMapper.updateByExampleSelective(contactPlan2Update,example);
        return OutDTOFactory.getSucceedOutDTO();
    }
}

