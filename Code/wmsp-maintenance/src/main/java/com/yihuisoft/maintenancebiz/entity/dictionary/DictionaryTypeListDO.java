package com.yihuisoft.maintenancebiz.entity.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典管理-字典类别列表查询展示DO
 * @author laijd
 * @date 2019-08-14 14:07
 * @version V4.0.2
 */
public class DictionaryTypeListDO implements Serializable {
    /**字典类别ID*/
    private Long id;
    /**字典类别名称*/
    private String dictTypeName;
    /**字典类别标识*/
    private String dictTypeCode;
    /**创建人ID*/
    private Long createUserid;

    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**更新人*/
    private Long updateUserid;

    /**更新时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    /**描述*/
    private String description;
    /**字典项个数*/
    private String dicts;
    /**归属菜单：公用字典：1，系统中0级/1级菜单：菜单表ID */
    private Long menuId;
    /**归属菜单名称*/
    private String menuName;

    @Override
    public String toString() {
        return "DictionaryTypeListDO{" +
                "id=" + id +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", createUserid=" + createUserid +
                ", createTime=" + createTime +
                ", updateUserid=" + updateUserid +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", dicts='" + dicts + '\'' +
                ", menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
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

    public String getDicts() {
        return dicts;
    }

    public void setDicts(String dicts) {
        this.dicts = dicts;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}