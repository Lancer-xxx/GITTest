package com.yihuisoft.maintenancebiz.service.param.impl;

import com.yihuisoft.common.service.impl.CommonServiceImpl;
import com.yihuisoft.maintenancebiz.entity.param.SystemParam;
import com.yihuisoft.maintenancebiz.mapper.param.SystemParamMapper;
import com.yihuisoft.maintenancebiz.service.param.SystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxin
 * @Title: SystemParamService
 * @ProjectName yihuisoft-maintenance
 * @Description: 系统参数服务接口
 * @version V4.0.0
 * @date 2019/6/17 15：32
 */
@Service
public class SystemParamServiceImpl extends CommonServiceImpl<SystemParam> implements SystemParamService {
    @Autowired
    SystemParamMapper systemParamMapper;

    /**
     * 校验系统参数名称存在性
     * @param systemParam
     * @return
     */
    @Override
    public boolean validateParamNameExist(SystemParam systemParam) {
        boolean entityHasParamName = false;

        SystemParam systemParamBean = new SystemParam();
        systemParamBean.setParamName(systemParam.getParamName());
        // 从数据库 是否有系统参数名的记录
        List<SystemParam> systemParamList = this.listAll(systemParamBean).getListData();
        if(systemParamList != null && !systemParamList.isEmpty()){
            entityHasParamName = true;
        }

        return entityHasParamName;
    }
}
