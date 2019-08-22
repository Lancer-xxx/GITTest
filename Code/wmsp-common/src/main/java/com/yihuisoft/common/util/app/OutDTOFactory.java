package com.yihuisoft.common.util.app;

import com.yihuisoft.common.dto.IResultEnum;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;

/**
 * OutDTO获取工具类
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/2 9:14
 */
public class OutDTOFactory {

    /**是否存在key*/
    public final static String RESULT_KEY = "exsit";
    /**不存在value*/
    public static final int RESULT_NOT_EXIST = 0;
    /**存在value*/
    public static final int RESULT_EXIST = 1;

    /**成功状态*/
    public final static String STATUS_SUCCESS = "0";
    /**失败状态*/
    public final static String STATUS_FAIL = "1";


    /**
     * 根据返回码枚举构造返回值
     * @param resultEnum 错误码枚举
     * @return
     */
    public static OutDTO getOutDTO(IResultEnum resultEnum){
        OutDTO instance = new OutDTO();
        instance.setErrorCode(resultEnum.getCode());
        instance.setErrorMsg(resultEnum.getMessage());
        return instance;
    }

    /**
     * 返回成功信息
     * @return
     */
    public static OutDTO getSucceedOutDTO(){
        return getOutDTO(ResultEnum.SUCCESS).setStatus(STATUS_SUCCESS);
    }
    /**
     * 返回失败信息
     * @return
     */
    public static OutDTO getFailOutDTO(IResultEnum resultEnum){
        return getOutDTO(resultEnum).setStatus(STATUS_FAIL);
    }

    /**
     * 带存在结果的成功返回值
     * @return
     */
    public static OutDTO getSuccessOutDTOExist(){
        return getSucceedOutDTO().put(RESULT_KEY,RESULT_EXIST);
    }
    /**
     * 带不存在结果的成功返回值
     * @return
     */
    public static OutDTO getSuccessOutDTONotExist(){
        return getSucceedOutDTO().put(RESULT_KEY,RESULT_NOT_EXIST);
    }

}
