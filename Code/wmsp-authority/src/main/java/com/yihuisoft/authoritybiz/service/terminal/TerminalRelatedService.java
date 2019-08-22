package com.yihuisoft.authoritybiz.service.terminal;

import com.yihuisoft.authoritybiz.dto.terminal.TerminalFindDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalPageDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalSaveDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalUpdateDTO;
import com.yihuisoft.authoritybiz.entity.terminal.Terminal;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PageMessage;

/**
 * 终端维护业务接口层
 * @projectName yihuisoft-authority
 * @author topz
 * @date 2019/7/2 14:38
 * @version V4.0.0
 **/
public interface TerminalRelatedService {

    /**
      * 获取设备分页列表
      * @author topz
      * @param inputOb 传入设备分页实体
      * @param pageMessage 分页参数信息
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:34 2019/7/12
      **/
    OutDTO listTerminals(TerminalPageDTO inputOb, PageMessage pageMessage);

    /**
      * 新增设备
      * @author topz
      * @param terminalSaveDTO 设备插入实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:35 2019/7/12
      **/
    OutDTO saveTerminal(TerminalSaveDTO terminalSaveDTO)  ;


    /**
      * 更新设备信息
      * @author topz
      * @param terminalUpdateDTO 设备更新传输实体
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:35 2019/7/12
      **/
    OutDTO updateTerminal(TerminalUpdateDTO terminalUpdateDTO)  ;


    /**
      * 通过设备标识查询设备信息
      * @author topz
      * @param terminalFindDTO 传入设备标识参数
      * @return com.yihuisoft.common.dto.OutDTO<com.yihuisoft.authoritybiz.entity.terminal.Terminal>
      * @date 18:44 2019/7/16
      **/
    OutDTO<Terminal> getTerminalById(TerminalFindDTO terminalFindDTO)  ;
}
