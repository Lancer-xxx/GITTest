package com.yihuisoft.maintenancebiz.dto.dictionary;

import java.io.Serializable;

/**
* 字典项列表信息查询DTO
* @author laijd
* @date 2019-08-13 14:11
* @version V4.0.2
*/
public class DictionaryListDTO implements Serializable {
    /**字典项名称*/
    private String dictName;
    /**字典值*/
    private String dictValue;
    /**状态：1-禁用；2-启用*/
    private Long status;
    /**字典类别标识*/
    private String dictTypeCode;

    @Override
    public String toString() {
        return "DictionaryListDTO{" +
                "dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", status=" + status +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                '}';
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
