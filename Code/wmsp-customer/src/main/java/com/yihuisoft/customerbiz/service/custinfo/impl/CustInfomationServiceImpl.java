//package com.yihuisoft.customerbiz.service.custinfo.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//
//import com.yihuisoft.authoritybiz.dto.permission.RoleDataPersionSelectDTO;
//import com.yihuisoft.authoritybiz.entity.permission.DataPersion;
//import com.yihuisoft.authoritybiz.service.permission.DataPersionService;
//import com.yihuisoft.common.constant.CommonConstants;
//import com.yihuisoft.common.constant.DataPermissionEnum;
//import com.yihuisoft.common.dto.OutDTO;
//import com.yihuisoft.common.exception.ApplicationException;
//import com.yihuisoft.common.util.DataUtil;
//import com.yihuisoft.common.util.app.OutDTOFactory;
//import com.yihuisoft.common.vo.PageMessage;
//import com.yihuisoft.customerbiz.constant.custinfo.CustInfomationConsts;
//import com.yihuisoft.customerbiz.dto.custinfo.CustInfomationListDTO;
//import com.yihuisoft.customerbiz.entity.custinfo.CustInfomation;
//import com.yihuisoft.customerbiz.mapper.custinfo.CustInfomationMapper;
//import com.yihuisoft.customerbiz.service.custinfo.CustInfomationService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 客户信息服务层
// * @author topz
// * @date 2019/8/8 14:38
// * @version V4.0.0
// **/
//@Service
//public class CustInfomationServiceImpl implements CustInfomationService {
//
//    private static final Logger logger = LoggerFactory.getLogger(CustInfomationServiceImpl.class);
//
//    @Autowired
//    private CustInfomationMapper custInfoMapper;
//
//    @Autowired
//    private DataPersionService permissionService;
//
//    /**
//     * 查询客户列表（1.权限查询 2.条件查询 3.排序功能）
//     * @author topz
//     * @param paramdto 分页条件传参
//     * @param pageMessage 分页信息
//     * @return com.yihuisoft.common.dto.OutDTO<com.yihuisoft.customerbiz.entity.custinfo.CustInfomation>
//     * @date 16:55 2019/8/8
//     **/
//    @Override
//    public OutDTO<CustInfomation> list(CustInfomationListDTO paramdto, PageMessage pageMessage) throws ApplicationException{
//
//        // 检查分页信息
//        pageMessage = PageMessage.check(pageMessage);
//        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
//
//        Map<String, Object> paramsMap;
//        try {
//            paramsMap  = DataUtil.Object2Map(paramdto);
//        } catch (IllegalAccessException e) {
//            logger.error("查询客户列表信息传参转换为map失效！");
//            throw new ApplicationException("查询客户列表信息传参转换为map失效！",e);
//        }
//
//        //权限处理流程
//        //通过权限枚举获取权限数据map,作为传入dao层参数使用
//        Map<String, String> dataAuthMap = DataPermissionEnum.INSTANCE.getDataAuthMap(CommonConstants.DATA_TYPE_ORGN_USER);
//
//        //设置当前数据权限：1.获取角色的权限信息
//        String dataAuth = "0";
//        RoleDataPersionSelectDTO rolePermission  = new RoleDataPersionSelectDTO();
//        rolePermission.setRoleId(paramdto.getRoleId());
//        rolePermission.setType(CommonConstants.DATA_TYPE_ORGN_USER);
//
//        //调用统一认证权限接口：通过当前用户传入角色id、权限大类获取其权限类型
//        DataPersion dataPermisson = permissionService.getDataPersion(rolePermission).getInfoData();
//        if(!ObjectUtils.isEmpty(dataPermisson)){
//            dataAuth = dataPermisson.getSubType();
//        }
//
//        //将获取的当前权限放入map传入dao层
//        paramsMap.put("dataAuth",dataAuth);
//
//        //排序处理流程
//        String listOrder = CustInfomationConsts.CUST_LIST_NONE_ORDER;
//        if(paramdto.getLastCallTimeOrder()==null&&paramdto.getLatestCallTimeOrder()==null&&CustInfomationConsts.ORDER_ASE.equals(paramdto.getAgeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_AGE_ASC;
//        }else if(paramdto.getLastCallTimeOrder()==null&&paramdto.getLatestCallTimeOrder()==null&&CustInfomationConsts.ORDER_DESC.equals(paramdto.getAgeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_AGE_DESC;
//        }else if(paramdto.getLatestCallTimeOrder()==null&&paramdto.getAgeOrder()==null&&CustInfomationConsts.ORDER_ASE.equals(paramdto.getLastCallTimeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_LAST_CALL_TIME_ASC;
//        }else if(paramdto.getLatestCallTimeOrder()==null&&paramdto.getAgeOrder()==null&&CustInfomationConsts.ORDER_DESC.equals(paramdto.getLastCallTimeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_LAST_CALL_TIME_DESC;
//        }else if(paramdto.getLastCallTimeOrder()==null&&paramdto.getAgeOrder()==null&&CustInfomationConsts.ORDER_ASE.equals(paramdto.getLatestCallTimeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_LATEST_CALL_TIME_ASC;
//        }else if(paramdto.getLastCallTimeOrder()==null&&paramdto.getAgeOrder()==null&&CustInfomationConsts.ORDER_DESC.equals(paramdto.getLatestCallTimeOrder())){
//            listOrder=CustInfomationConsts.CUST_LIST_LATEST_CALL_TIME_DESC;
//        }
//
//        paramsMap.put("listOrder",listOrder);
//
//        //查询列表操作
//        List<CustInfomation> custInfoList;
//        try{
//            custInfoList = custInfoMapper.list(paramsMap,dataAuthMap);
//
//        }catch (Exception e){
//            logger.error("查询客户列表信息异常！");
//            throw new ApplicationException("查询客户列表信息异常！",e);
//        }
//
//        PageInfo<CustInfomation> page = new PageInfo<>(custInfoList);
//
//        return OutDTOFactory.getSucceedOutDTO().putList(custInfoList).setSumCount(page.getTotal());
//    }
//}
