package com.yihuisoft.common.util.app;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;

import java.util.List;

/**
 * Dao层返回的数据校验
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/2 9:14
 */
public class CheckUtils {

    /**
     * 检查更新的返回值
     * @param result
     * @return
     */
    public static OutDTO checkUpdate(int result) {
        OutDTO outDTO;
        if (result >= 1) {
            outDTO = OutDTOFactory.getSucceedOutDTO();
        } else {
            outDTO = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_UPDATE);
        }
        return outDTO;
    }

    /**
     * 检查删除的返回值
     * @param result
     * @return
     */
    public static OutDTO checkDelete(int result) {
        OutDTO outDTO;
        if (result == 1) {
            outDTO = OutDTOFactory.getSucceedOutDTO();
        } else {
            outDTO = OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_DELETE);
        }
        return outDTO;
    }

    /**
     * 校验是否存在
     * @param list
     * @return
     */
    public static OutDTO checkExist(List list) {
        OutDTO outDTO;
        if (list != null && !list.isEmpty()) {
            outDTO = OutDTOFactory.getSuccessOutDTOExist();
        } else {
            outDTO = OutDTOFactory.getSuccessOutDTONotExist();
        }
        return outDTO;
    }

}
