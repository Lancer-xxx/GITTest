package com.yihuisoft.authoritybiz.service.terminal.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalFindDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalPageDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalSaveDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalUpdateDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.terminal.Terminal;
import com.yihuisoft.authoritybiz.mapper.organization.OrganizationMapper;
import com.yihuisoft.authoritybiz.mapper.terminal.TerminalRelatedMapper;
import com.yihuisoft.authoritybiz.service.terminal.TerminalRelatedService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 终端维护业务实现层
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
@Service
public class TerminalRelatedServiceImpl implements TerminalRelatedService{

    private static final Logger logger = LoggerFactory.getLogger(TerminalRelatedServiceImpl.class);

    @Autowired
    private TerminalRelatedMapper terminalMapper;

    @Autowired
    private OrganizationMapper orgnMapper;


    /**
      * 获取终端设备信息分页列表
      * @author topz
      * @param inputOb 传入条件查询参数
      * @param pageMessage 分页参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 17:13 2019/7/18
      **/
    @Override
    public OutDTO listTerminals(TerminalPageDTO inputOb, PageMessage pageMessage) {
        OutDTO res;

        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

        // 复制对象属性到Terminal传入mapper
        Terminal terminal = new Terminal();
        CopyUtils.copy(terminal,inputOb);

        List<Terminal> terminalList;
        try{
            terminalList = terminalMapper.listTerminals(terminal);
            if(ObjectUtils.isEmpty(terminalList)){
                logger.info("暂无终端设备分页信息！");
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("暂无终端设备分页信息！");
            }else{
                logger.info("获取终端设备信息"+terminalList.size()+"条！");
            }

        }catch (Exception e){
            logger.error("获取终端设备信息异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("获取终端设备信息异常！");
        }

        // 用PageInfo对结果进行包装
        PageInfo<Terminal> page = new PageInfo(terminalList);

        // 封装返回信息
        res = OutDTOFactory.getSucceedOutDTO()
                .putList(terminalList)
                .setSumCount(page.getTotal());
        return res;
    }

    /**
      * 新建设备信息:1.检验设备标识（与设备终端号相同：农信逻辑）唯一性 2.机构编码是否存在 3.机构下ip唯一 4.增加主密钥，工作秘钥申请的接口调用逻辑
      * @author topz
      * @param terminalSaveDTO 插入传入实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:43 2019/7/12
      **/
    @Override
    public OutDTO saveTerminal(TerminalSaveDTO terminalSaveDTO)  {
        OutDTO res;

        // 复制对象属性到Terminal传入mapper
        Terminal terminal = new Terminal();
        CopyUtils.copy(terminalSaveDTO, terminal);

        // 1.查看设备标识是否已存在
        List<Terminal> list;
        try{
            list = terminalMapper.getTerminalById(terminal.getLogDeviceId());
            if(!ObjectUtils.isEmpty(list)){
                res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_REPETITION_TERMINAL);
                logger.info("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息失败,设备已存在！");
                return res;
            }
        }catch (Exception e){
            logger.error("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息-->查询设备是否存在时发生异常");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息查询设备是否存在时发生异常");
        }

        // 2.机构编码是否存在
        int codeExsitCount = 0;
        try{
            Organization organization = new Organization();
            organization.setOrgnCode(terminal.getOrgnCode());
            codeExsitCount = orgnMapper.checkOrganization(organization);
            if(codeExsitCount==0){
                res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_ORGNCODE_REPETITION_TERMINAL);
                logger.info("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息时机构编码不存在！");
                return res;
            }
        }catch (Exception e){
            logger.error("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构编码时发生异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构编码时发生异常！");
        }

        // 3.验证机构下ip唯一
        List<Terminal> itemsListByip;
        try{
            itemsListByip= terminalMapper.findOrgnCodeByIp(terminal);
            if(!ObjectUtils.isEmpty(itemsListByip)){
                res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_IP_REPETITION_TERMINAL);
                logger.info("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息时机构下已存在相同的ip地址！");
                return res;
            }
        }catch (Exception e){
            logger.error("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证IP在机构下是否唯一时发生异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("创建设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证IP在机构下是否唯一时发生异常！");
        }

        // 申请秘钥逻辑 to do....

        // 新增设备
        int rows =0;
        try {
            rows = terminalMapper.saveTerminal(terminal);
            if(rows==0){
                res=OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
                logger.info("新增设备标识为<"+terminal.getLogDeviceId()+">的设备信息失败！");
            }else {
                res = OutDTOFactory.getSucceedOutDTO();
                logger.info("新增设备标识为<"+terminal.getLogDeviceId()+">的设备信息成功！");
            }
        }catch (Exception e){
            logger.error("新增设备信息服务异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("新增设备信息服务异常！");
        }
        return res;
    }

    /**
      * 更新设备信息:1.机构编码是否存在 2.机构下ip唯一
      * @author topz
      * @param terminalUpdateDTO 更新传入设备实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:42 2019/7/12
      **/
    @Override
    public OutDTO updateTerminal(TerminalUpdateDTO terminalUpdateDTO)   {
        OutDTO res;

        // 复制对象属性到Terminal传入mapper
        Terminal terminal = new Terminal();
        CopyUtils.copy(terminalUpdateDTO, terminal);

        // 1.机构编码是否存在
        int codeExsitCount = 0;
        try{
            Organization organization = new Organization();
            organization.setOrgnCode(terminal.getOrgnCode());
            codeExsitCount = orgnMapper.checkOrganization(organization);
            if(codeExsitCount==0){
                res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_ORGNCODE_REPETITION_TERMINAL);
                logger.info("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息时机构编码不存在！");
                return res;
            }
        }catch (Exception e){
            logger.error("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构编码是否存在时发生异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构编码是否存在时发生异常！");
        }


        // 2.验证机构下ip唯一:更新操作排除自身
        List<Terminal> itemsListByip;
        try{
            itemsListByip= terminalMapper.findOrgnCodeByIp(terminal);
            if(!ObjectUtils.isEmpty(itemsListByip)){
                //排除自身
                if(itemsListByip.size()==1&&terminal.getLogDeviceId().equals(itemsListByip.get(0).getLogDeviceId())){
                    logger.info("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息时:当前修改ip为唯一！");
                }else{
                    res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_IP_REPETITION_TERMINAL);
                    logger.info("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息时机构下已存在相同的ip地址！");
                    return res;
                }
            }
        }catch (Exception e){
            logger.error("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构下ip唯一时发生异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息验证机构下ip唯一时发生异常！");
        }


        int rows = 0;
        try {
            rows = terminalMapper.updateTerminal(terminal);
            if(rows==0){
                res=OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_UPDATE);
                logger.info("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息失败！");
            }else {
                res = OutDTOFactory.getSucceedOutDTO();
                logger.info("更新设备标识为<"+terminal.getLogDeviceId()+">的设备信息成功！");
            }
        }catch (Exception e){
            logger.error("更新设备信息服务异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("更新设备信息服务异常！");
        }
        return res;
    }

    /**
      * 根据设备id获取设备信息
      * @author topz
      * @param terminalFindDTO 传入设备id
      * @return com.yihuisoft.common.dto.OutDTO<com.yihuisoft.authoritybiz.entity.terminal.Terminal>
      * @date 17:32 2019/7/18
      **/
    @Override
    public OutDTO<Terminal> getTerminalById(TerminalFindDTO terminalFindDTO) {
        OutDTO res;
        List<Terminal> terminalList;
        try{
            terminalList = terminalMapper.getTerminalById(terminalFindDTO.getLogDeviceId());
            if(!ObjectUtils.isEmpty(terminalList)){
                res =  OutDTOFactory.getSucceedOutDTO().putInfo(terminalList.get(0));
            }else{
                res = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("未查询到设备标识(logDeviceId)为：<"+terminalFindDTO.getLogDeviceId()+">的设备信息");
            }
        }catch (Exception e){
            logger.error("查询到设备标识(logDeviceId)为：<"+terminalFindDTO.getLogDeviceId()+">的设备信息时发生异常！");
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_COMMON).setErrorMsg("查询到设备标识(logDeviceId)为：<"+terminalFindDTO.getLogDeviceId()+">的设备信息时发生异常！");
        }

        return res;
    }


}
