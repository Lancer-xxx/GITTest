package com.yihuisoft.authoritybiz.dto.user;

import org.hibernate.validator.constraints.NotBlank;

/**
  * todo
  * @author topz
  * @date 2019/7/26 16:21
  * @version V4.0.0
  **/
public class SysDicTypeDTO {

    @NotBlank(message = "字典code不能为空！")
    private String dictTypeCode;

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }
}
