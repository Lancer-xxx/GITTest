package com.yihuisoft.authoritybiz.service.system;

import com.yihuisoft.authoritybiz.dto.system.SystemDTO;
import com.yihuisoft.authoritybiz.entity.system.SystemModel;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.vo.PageMessage;

/**
 * 系统信息服务层接口
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/3 19:07
 */
public interface SystemService {

    /**
     * 系统信息插入
     * @param systemDTO
     * @return
     */
    OutDTO saveSysInfoSelective(SystemDTO systemDTO);

    /**
     * 根据系统ID删除系统信息
     * @param sysId
     * @return
     * @throws ApplicationException
     */
    OutDTO deleteSystemByPrimaryKey(Long sysId) throws ApplicationException;

    /**
     * 更新系统信息
     * @param systemDTO
     * @return
     */
    OutDTO updateSystemSelective(SystemDTO systemDTO);

    /**
     * 查询系统信息
     * @param systemDTO
     * @return
     */
    SystemModel getSysInfo(SystemDTO systemDTO);

    /**
     * 查询系统信息列表
     * @return
     * @param data
     * @param pageMessage
     */
    OutDTO listSystem(SystemDTO data, PageMessage pageMessage);


    /**
     * 查询所有系统信息
     * @return
     */
    OutDTO listAllSystem();


}
