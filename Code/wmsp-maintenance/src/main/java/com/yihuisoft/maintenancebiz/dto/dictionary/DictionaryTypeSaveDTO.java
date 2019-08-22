package com.yihuisoft.maintenancebiz.dto.dictionary;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* 保存字典类别DTO
* @author laijd
* @date 2019-08-12 17:11
* @version V4.0.2
*/
public class DictionaryTypeSaveDTO implements Serializable {

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
    /**创建人ID*/
    @NotNull
    private Long createUserid;

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
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    @Override
    public String toString() {
        return "DictionaryTypeSaveDTO{" +
                "dictTypeName='" + dictTypeName + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", description='" + description + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createUserid='" + createUserid + '\'' +
                '}';
    }
}
