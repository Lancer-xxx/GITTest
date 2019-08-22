package com.yihuisoft.common.constant;

import com.yihuisoft.common.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限枚举
 * @author topz
 * @date 2019/8/8 14:43
 * @version V4.0.0
 **/
public enum DataPermissionEnum {

    INSTANCE("INSTANCE","INSTANCE","INSTANCE"),

    /** 本人机构相关：本人 */
    TYPE_FIRST_ONESELF(CommonConstants.DATA_TYPE_ORGN_USER,"typeFirst_oneself","1"),

    /** 本人机构相关：本机构 */
    TYPE_FIRST_CURRENT_ORGN(CommonConstants.DATA_TYPE_ORGN_USER,"typeFirst_currentOrgn","2"),

    /** 本人机构相关：本机构及下级机构 */
    TYPE_FIRST_ALL_SUBORDINATES_OF_ORGN(CommonConstants.DATA_TYPE_ORGN_USER,"typeFirst_allSubordinatesOfOrgn","3"),

    /** 本人机构相关：全部 */
    TYPE_FIRST_ALL(CommonConstants.DATA_TYPE_ORGN_USER,"typeFirst_all","4");

    String type;
    String subTypeKey;
    String subTypeValue;

    DataPermissionEnum(String type,String subTypeKey,String subTypeValue){
        this.type=type;
        this.subTypeKey=subTypeKey;
        this.subTypeValue=subTypeValue;
    }


    public Map<String,String> getDataAuthMap(String dataAuthType){
        if(StringUtil.isEmpty(dataAuthType)){
            return null;
        }
        Map<String,String> map = new HashMap<>();
        for(DataPermissionEnum childEnum:DataPermissionEnum.values()){
            if(dataAuthType.equals(childEnum.getType())){
                map.put(childEnum.getSubTypeKey(),childEnum.getSubTypeValue());
            }
        }
        return map;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubTypeKey() {
        return subTypeKey;
    }

    public void setSubTypeKey(String subTypeKey) {
        this.subTypeKey = subTypeKey;
    }

    public String getSubTypeValue() {
        return subTypeValue;
    }

    public void setSubTypeValue(String subTypeValue) {
        this.subTypeValue = subTypeValue;
    }
}
