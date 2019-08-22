package com.yihuisoft.authoritybiz.controller.terminal;

import com.yihuisoft.authoritybiz.dto.terminal.TerminalFindDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalPageDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalSaveDTO;
import com.yihuisoft.authoritybiz.dto.terminal.TerminalUpdateDTO;
import com.yihuisoft.authoritybiz.service.terminal.TerminalRelatedService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 终端维护控制层
 * @className TerminalRelatedController
 * @projectName yihuisoft-authority
 * @author topz
 * @date 2019/6/28 13:24
 * @version V4.0.0
 **/
@RestController
@RequestMapping("/wmsp/authority/terminal")
public class TerminalRelatedController {

    @Autowired
    private TerminalRelatedService termnalServiceImpl;

    /**
      * 获取设备信息列表
      * @author topz
      * @param inVO 分页传入参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:44 2019/7/12
      **/
    @PostMapping(value = "/list")
    public OutDTO listTerminals(@Validated @RequestBody PagerVO<TerminalPageDTO> inVO) throws ApplicationException {

        OutDTO res =termnalServiceImpl.listTerminals(inVO.getData(),inVO.getPageMessage());
        return  res;
    }

    /**
      * 新增设备信息
      * @author topz
      * @param inVO 分页传入参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:45 2019/7/12
      **/
    @PostMapping(value = "/save")
    public OutDTO saveTerminal(@Validated @RequestBody InVO<TerminalSaveDTO> inVO) throws ApplicationException {
        return  termnalServiceImpl.saveTerminal(inVO.getData());
    }

    /**
      * 更新设备信息
      * @author topz
      * @param inVO 分页传入参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 10:45 2019/7/12
      **/
    @PostMapping(value = "/update")
    public OutDTO updateTerminal(@Validated @RequestBody InVO<TerminalUpdateDTO> inVO) throws ApplicationException {
        return  termnalServiceImpl.updateTerminal(inVO.getData());
    }

    /**
      * 根据设备标识查询设备信息
      * @author topz
      * @param inVO 传入参数
      * @return com.yihuisoft.common.dto.OutDTO
      * @date 16:43 2019/7/16
      **/
    @PostMapping(value = "/get_by_id")
    public OutDTO getTerminalById(@Validated @RequestBody InVO<TerminalFindDTO> inVO) throws ApplicationException {
        return  termnalServiceImpl.getTerminalById(inVO.getData());
    }
}
