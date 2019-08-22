package com.yihuisoft.maintenancebiz.controller;

import com.yihuisoft.common.controller.BaseController;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.maintenancebiz.constant.systemparam.SystemParamError;
import com.yihuisoft.maintenancebiz.entity.param.SystemParam;
import com.yihuisoft.maintenancebiz.service.param.SystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yihuisoft.common.util.app.OutDTOFactory.STATUS_FAIL;

/**
 * @author dim
 * @version V4.0.0
 * @Title: SystemParamController
 * @ProjectName yihuisoft-maintenance
 * @Description:
 * @date 2019/7/5
 */
@RequestMapping("wmsp/maintenance/param")
@RestController
@Validated
public class SystemParamController extends BaseController<SystemParam> {
    @Autowired
    SystemParamService systemParamService;

    /**
     * 系统参数的新增
     *      1. 系统参数名 ，要求唯一
     *      2. 系统参数名，系统参数值，系统模块名，注释  不允许空
     * @param inVO
     * //@param validators
     * @return
     */
    @Override
    public OutDTO save(@RequestBody InVO<SystemParam> inVO) {

        if (inVO != null) {

            boolean entityHasParamName = systemParamService.validateParamNameExist(inVO.getData());
            // 系统参数名 已经存在 校验
            if (entityHasParamName) {
                return OutDTOFactory.getSucceedOutDTO()
                        .setStatus(STATUS_FAIL)
                        .setErrorCode(SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getCode())
                        .setErrorMsg(SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getMessage());

            }

            return systemParamService.save(inVO.getData());

        } else {
            return OutDTOFactory.getSucceedOutDTO().setStatus(STATUS_FAIL);
        }
    }


    /**
     * 系统参数的更新
     *      1. 系统参数名 ，要求唯一
     *      2. 系统参数名，系统参数值，系统模块名，注释  不允许空
     * @param inVO
     * @return
     */
    @Override
    @PostMapping("update")
    public OutDTO update(@RequestBody InVO<SystemParam> inVO) {
            if (inVO != null && inVO.getData().getId() != null && inVO.getData().getParamName() != null) {
                SystemParam paramIdBean = new SystemParam();
                paramIdBean.setId(inVO.getData().getId());

                SystemParam paramData = systemParamService.get(paramIdBean).getInfoData();

                // 系统参数名 已经存在 校验
                if (paramData != null &&!paramData.getParamName().equals(inVO.getData().getParamName())) {

                    boolean entityHasParamName = systemParamService.validateParamNameExist(inVO.getData());

                    if(entityHasParamName){
                        return OutDTOFactory.getSucceedOutDTO()
                                .setStatus(STATUS_FAIL)
                                .setErrorCode(SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getCode())
                                .setErrorMsg(SystemParamError.SYSTEM_PAEAM_ALREADY_EXIST.getMessage());
                    }

                }

                return super.update(inVO);

            } else {
                return OutDTOFactory.getSucceedOutDTO().setStatus(STATUS_FAIL);
            }
        }
}
