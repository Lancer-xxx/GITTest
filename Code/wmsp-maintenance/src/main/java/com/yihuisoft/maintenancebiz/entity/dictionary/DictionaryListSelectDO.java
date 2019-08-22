package com.yihuisoft.maintenancebiz.entity.dictionary;
import java.io.Serializable;

/**
 * 字典管理-字典项：前端下拉框调用字典数据返回列表DO
 * @author laijd
 * @date 2019-08-13 11:07
 * @version V4.0.2
 */
public class DictionaryListSelectDO implements Serializable {

    /**字典类别标识*/
    private String dictTypeCode;
    /**字典项名称*/
    private String dictName;
    /**字典值*/
    private String dictValue;
    /**排序：0-999999*/
    private Long dictOrder;
    /**状态：1-禁用；2-启用*/
    private Long status;

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

    @Override
    public String toString() {
        return "DictionaryListSelectDO{" +
                "dictTypeCode='" + dictTypeCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictOrder=" + dictOrder +
                ", status=" + status +
                '}';
    }
}
