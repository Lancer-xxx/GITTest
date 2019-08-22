package com.yihuisoft.maintenancebiz.dto.dictionary;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* 修改字典类别DTO
* @author laijd
* @date 2019-08-12 17:11
* @version V4.0.2
*/
public class DictionaryTypeUpdateDTO implements Serializable {

    /**字典类别名称*/
    @NotNull
    private String dictTypeName;
    /**字典类别标识*/
    @NotNull
    private String dictTypeCode;
    /**描述*/
    private String description;
    /**归属菜单：公用字典：0，系统中0级/1级菜单：菜单表ID */
    @NotNull
    private Long menuId;
    /**更新ID*/
    @NotNull
    private Long updateUserid;
    /**字典类别ID*/
    @NotNull
    private Long id;

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
        return "DictionaryTypeUpdateDTO{" +
                "dictTypeName='" + dictTypeName + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", description='" + description + '\'' +
                ", menuId=" + menuId +
                ", updateUserid=" + updateUserid +
                ", id=" + id +
                '}';
    }
}
