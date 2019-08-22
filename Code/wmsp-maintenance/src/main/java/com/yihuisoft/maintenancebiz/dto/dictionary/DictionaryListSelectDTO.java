package com.yihuisoft.maintenancebiz.dto.dictionary;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* 字典项列表信息查询DTO
* @author laijd
* @date 2019-08-13 14:11
* @version V4.0.2
*/
public class DictionaryListSelectDTO implements Serializable {
    /**字典类别名称*/
    @NotNull
    private String dictTypeCode;

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    @Override
    public String toString() {
        return "DictionaryListSelectDTO{" +
                "dictTypeCode='" + dictTypeCode + '\'' +
                '}';
    }
}
