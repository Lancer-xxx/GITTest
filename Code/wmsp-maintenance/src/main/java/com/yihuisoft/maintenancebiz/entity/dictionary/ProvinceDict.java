package com.yihuisoft.maintenancebiz.entity.dictionary;

import javax.persistence.Table;

/**
 * 省市区字典数据
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/26 22:55
 */
@Table(name = "T_SYS_DICT_PROVINCE")
public class ProvinceDict {
    /**省份编码*/
    private String provinceId;
    /**省份名称*/
    private String provinceName;
    /**父Id*/
    private String parentId;
    /**数据状态*/
    private String status;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}