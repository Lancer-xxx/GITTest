package com.yihuisoft.authoritybiz.controller.system;

import com.yihuisoft.authoritybiz.dto.system.SystemDTO;
import com.yihuisoft.authoritybiz.service.system.SystemService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统信息管理控制层
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/4 10:09
 */
@RestController
@RequestMapping("/wmsp/authority/system/")
public class SystemController {

    @Autowired
    SystemService systemService;

    /**
     * 更新系统信息
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/update")
    public OutDTO updateSystem(@RequestBody InVO<SystemDTO> inVO)  {
        return systemService.updateSystemSelective(inVO.getData());
    }

    /**
     * 删除系统信息
     * @param inVO
     * @return
     * @throws ApplicationException
     */
    @PostMapping(value = "/delete")
    public OutDTO deleteSystemByPrimaryKey(@RequestBody InVO<SystemDTO> inVO) throws ApplicationException {
        return systemService.deleteSystemByPrimaryKey(inVO.getData().getId());
    }

    /**
     * 分页查询系统信息列表
     * @param pagerVO
     * @return OutDTO
     */
    @PostMapping(value = "/list")
    public OutDTO listSystems(@RequestBody PagerVO<SystemDTO> pagerVO)  {
        return systemService.listSystem(pagerVO.getData(),pagerVO.getPageMessage());
    }

    /**
     * 查询所有系统信息列表
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/list_all")
    public OutDTO listAllSystems(@RequestBody InVO<SystemDTO> inVO)  {
        return systemService.listAllSystem();
    }

}
