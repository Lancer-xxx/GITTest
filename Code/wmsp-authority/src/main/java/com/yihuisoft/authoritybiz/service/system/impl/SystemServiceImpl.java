package com.yihuisoft.authoritybiz.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.authoritybiz.dto.system.SystemDTO;
import com.yihuisoft.authoritybiz.entity.system.SystemModel;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.system.SystemMapper;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.authoritybiz.service.system.SystemService;
import com.yihuisoft.common.annotation.ServiceLog;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 系统信息服务层
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/3 19:39
 */
@Service
public class SystemServiceImpl implements SystemService {

    private static final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private SystemMapper systemMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuService menuservice;

    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "新增系统数据接口",businessType = "1")
    @Override
    public OutDTO saveSysInfoSelective(SystemDTO systemDTO) {
        if (checkSysName(systemDTO.getSysName())) {
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_SYS_NAME);
        }
        // DTO转为操作数据库的实体
        SystemModel systemModel = new SystemModel();
        CopyUtils.copy(systemDTO, systemModel);
        systemMapper.insertSelective(systemModel);
        return OutDTOFactory.getSucceedOutDTO();
    }

    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "删除系统信息数据接口",businessType = "1")
    @Override
    public OutDTO deleteSystemByPrimaryKey(Long sysId) throws ApplicationException {

        if (menuservice.checkSystemToDelete(sysId)) {
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_SUB_MENU);
        }

        // 删除根菜单
        int isdelete = menuservice.deleteRootMenu(sysId);
        if(isdelete != 1){
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_DELETE_ROOT_MUNU);
        }

        int result = systemMapper.deleteByPrimaryKey(sysId);
        return CheckUtils.checkDelete(result);
    }

    @Transactional(rollbackFor=Exception.class)
    @ServiceLog(decription = "修改菜单",businessType = "1")
    @Override
    public OutDTO updateSystemSelective(SystemDTO systemDTO) {
        if (checkSysName(systemDTO.getSysName())) {
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_SYS_NAME);
        }
        if (systemDTO.getStatus()!=null && Integer.parseInt(systemDTO.getStatus()) == 0){
            if (menuservice.checkSystemToDelete(systemDTO.getId())) {
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_AUTHORITY_EXIST_SUB_MENU);
            }
        }
        // DTO转为操作数据库的实体
        SystemModel systemModel = new SystemModel();
        CopyUtils.copy(systemDTO, systemModel);
        int result = systemMapper.updateByPrimaryKeySelective(systemModel);
        return CheckUtils.checkUpdate(result);
    }

    @Override
    public SystemModel getSysInfo(SystemDTO systemDTO) {
        // DTO转为操作数据库的实体
        SystemModel systemModel = new SystemModel();
        CopyUtils.copy(systemDTO, systemModel);
        return systemMapper.selectByPrimaryKey(systemModel);
    }

    /**
     * 检查是否已经存在相同的系统名称
     * @param sysName 系统名称
     * @return true 存在 false 不存在
     */
    public boolean checkSysName(String sysName) {
        boolean isExist = false;
        List<SystemModel> sysInf = systemMapper.selectByName(sysName);
        if(!ObjectUtils.isEmpty(sysInf)){
            isExist = true;
        }
        return isExist;
    }

    @Override
    public OutDTO listSystem(SystemDTO systemDTO, PageMessage pageMessage) {
        // DTO转为操作数据库的实体
        SystemModel systemModel = new SystemModel();
        CopyUtils.copy(systemDTO, systemModel);
        // 检查分页信息
        pageMessage = PageMessage.check(pageMessage);
        PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());
        List<SystemModel> list = systemMapper.listSystems(systemModel);
        PageInfo<SystemModel> page = new PageInfo<>(list);
        // 返回list数据和总数
        return OutDTOFactory.getSucceedOutDTO().putList(list).setSumCount(page.getTotal());
    }

    @Override
    public OutDTO listAllSystem() {
        List<SystemModel> list = systemMapper.listAllSystems();
        // 返回list数据和总数
        return OutDTOFactory.getSucceedOutDTO().putList(list);
    }

}
