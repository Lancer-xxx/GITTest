package com.yihuisoft.maintenancebiz.dto.dictionary;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* 修改字典项DTO
* @author laijd
* @date 2019-08-13 14:11
* @version V4.0.2
*/
public class DictionaryUpdateDTO implements Serializable {
    /**字典类别标识*/
    private String dictTypeCode;
    /**字典项名称*/
    private String dictName;
    /**字典值*/
    private String dictValue;
    /**排序*/
    private Long dictOrder;
    /**描述*/
    private String description;
    /**状态：1-禁用；2-启用*/
    private Long status;
    /**创建人ID*/
    @NotNull
    private Long updateUserid;
    /**字典项ID*/
    @NotNull
    private Long id;

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
        return updateUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.updateUserid = createUserid;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DictionaryUpdateDTO{" +
                "dictTypeCode='" + dictTypeCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictOrder=" + dictOrder +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", updateUserid=" + updateUserid +
                ", id=" + id +
                '}';
    }
}
