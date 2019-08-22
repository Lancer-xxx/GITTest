package com.yihuisoft.maintenancebiz.dto.dictionary;
import java.io.Serializable;

/**
* 查找字典类别DTO
* @author laijd
* @date 2019-08-12 17:11
* @version V4.0.2
*/
public class DictionaryTypeListDTO implements Serializable {

    /**字典类别名称*/
    private String dictTypeName;
    /**字典类别标识*/
    private String dictTypeCode;
    /**归属菜单：公用字典：0，系统中0级/1级菜单：菜单表ID */
    private Long menuId;

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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "DictionaryTypeSaveDTO{" +
                "dictTypeName='" + dictTypeName + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
