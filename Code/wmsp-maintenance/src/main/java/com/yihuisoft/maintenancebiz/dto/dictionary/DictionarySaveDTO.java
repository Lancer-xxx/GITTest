package com.yihuisoft.maintenancebiz.dto.dictionary;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* 保存字典项DTO
* @author laijd
* @date 2019-08-13 14:11
* @version V4.0.2
*/
public class DictionarySaveDTO implements Serializable {
    /**字典类别标识*/
    @NotNull
    private String dictTypeCode;
    /**字典项名称*/
    @NotNull
    private String dictName;
    /**字典值*/
    @NotNull
    private String dictValue;
    /**排序*/
    @NotNull
    private Long dictOrder;
    /**描述*/
    private String description;
    /**状态：1-禁用；2-启用*/
    @NotNull
    private Long status;
    /**创建人ID*/
    @NotNull
    private Long createUserid;

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

    public Long getDictOrder() {
        return dictOrder;
    }

    public void setDictOrder(Long dictOrder) {
        this.dictOrder = dictOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    @Override
    public String toString() {
        return "DictionarySaveDTO{" +
                "dictTypeCode='" + dictTypeCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictOrder=" + dictOrder +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createUserid=" + createUserid +
                '}';
    }
}
