package com.yihuisoft.maintenancebiz.entity.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典管理-字典项：列表展示信息VO
 * 字典项表+归属菜单名称
 * @author laijd
 * @date 2019-08-13 11:07
 * @version V4.0.2
 */
public class DictionaryListDO implements Serializable {

    /**字典类别ID*/
    private Long id;
    /**字典类别编码*/
    private String dictTypeCode;
    /**字典项名称*/
    private String dictName;
    /**字典值*/
    private String dictValue;
    /**排序：0-999999*/
    private Long dictOrder;
    /**状态：1-禁用；2-启用*/
    private Long status;
    /**创建人ID*/
    private Long createUserid;
    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**更新人ID*/
    private Long updateUserid;
    /**更新时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    /**描述*/
    private String description;
    /**字典类别名称*/
    private String dictTypeName;

    @Override
    public String toString() {
        return "DictionaryListDO{" +
                "id=" + id +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictOrder=" + dictOrder +
                ", status=" + status +
                ", createUserid=" + createUserid +
                ", createTime=" + createTime +
                ", updateUserid=" + updateUserid +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", dictTypeName='" + dictTypeName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getDictOrder() {
        return dictOrder;
    }

    public void setDictOrder(Long dictOrder) {
        this.dictOrder = dictOrder;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }
}