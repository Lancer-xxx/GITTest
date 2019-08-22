package com.yihuisoft.maintenancebiz.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 省市区DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/27 19:46
 */
public class ProvinceDictDTO {
    /**父Id*/
    @NotBlank(message="上级编码不能为空")
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}