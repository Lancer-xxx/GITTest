package com.yihuisoft.maintenancebiz.entity.param;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.validator.Group;
import com.yihuisoft.maintenancebiz.constant.systemparam.SystemParamErrorMessage;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wangxin
 * @Title: systemparam
 * @ProjectName yihuisoft-maintenance
 * @Description: 系统参数实体对象
 * @version V4.0.0
 * @date 2019/6/17 15：32
 */
public class SystemParam {

    @NotNull(message = SystemParamErrorMessage.ID_IS_NULL, groups = Group.save.class)
    private Long id;

    /**
     * 系统参数名
     */
    @NotEmpty(message = SystemParamErrorMessage.PARAM_NAME_IS_EMPTY, groups = Group.save.class)
    private String paramName;

    /**
     * 系统参数类型
     */
    @NotEmpty(message = SystemParamErrorMessage.PARAM_TYPE_IS_EMPTY, groups = Group.save.class)
    private String paramType;

    /**
     * 参数值
     */
    @NotEmpty(message = SystemParamErrorMessage.PARAM_VALUE_IS_EMPTY, groups = Group.save.class)
    private String paramValue;

    /**
     * 参数注释
     */
    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

    /**
     * 最后的变更日期
     */
    private Date lastMod;

    /**
     * 系统参数所属的模块名
     */
    @NotEmpty(message = SystemParamErrorMessage.PARAM_MODULE_NAME_IS_EMPTY, groups = Group.save.class)
    private String pModuleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getpModuleName() {
        return pModuleName;
    }

    public void setpModuleName(String pModuleName) {
        this.pModuleName = pModuleName;
    }

    @Override
    public String toString() {
        return "SysParam{" +
                "id=" + id +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", remark='" + remark + '\'' +
                ", lastMod=" + lastMod +
                ", pModuleName='" + pModuleName + '\'' +
                '}';
    }
}
