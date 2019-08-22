package com.yihuisoft.maintenancebiz.entity.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 字典管理-字典类别实体类
 * @author laijd
 * @date 2019-08-11 18:02
 * @version V4.0.2
 */
@Table(name = "T_SYS_DICT_TYPE")
public class DictionaryType implements Serializable {
    /**字典类别ID*/
    @Id
    private Long id;
    /**字典类别名称*/
    private String dictTypeName;
    /**字典类别标识*/
    private String dictTypeCode;
    /**描述*/
    private String description;
    /**归属菜单：公用字典：0，系统中0级/1级菜单：菜单表ID */
    private Long menuId;
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
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }
    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid == null ? null : createUserid;
    }
    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SystemDictType{" +
                "id=" + id +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", description='" + description + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createUserid='" + createUserid + '\'' +
                ", createTime=" + createTime +
                ", updateUserid='" + updateUserid + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
