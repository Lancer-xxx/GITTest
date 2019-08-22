package com.yihuisoft.maintenancebiz.vo;

/**
 * 省市区返回VO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/27 19:51
 */
public class ProvinceDictVO {
    /**省份编码*/
    private String provinceId;
    /**省份名称*/
    private String provinceName;

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
}