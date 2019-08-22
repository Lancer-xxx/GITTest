package com.yihuisoft.maintenancebiz.service.screen;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.service.CommonService;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.dto.SystemScreenDTO;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/6/25
 */
public interface SystemScreenService extends CommonService<SystemScreen> {

    /**
     * 系统屏保的查询 查询
     * @param pagerVO
     * @return
     */
    public OutDTO<SystemScreenDTO> search(PagerVO<SystemScreenDTO> pagerVO);

    /**
     * 校验并且更新
     * @param systemScreen
     * @return
     */
    public OutDTO<SystemScreen> validateAndUpdate(SystemScreen systemScreen);

    /**
     * 校验图片别名存在
     * @param systemScreen
     * @return
     */
    boolean validateFileAliasNameExist(SystemScreen systemScreen);
}
