package com.yihuisoft.authoritybiz.dto.system;

/**
 * 认证模块系统管理DTO
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/3 19:01
 */
public class SystemDTO {
    /**系统ID*/
    private Long id;
    /**系统名称*/
    private String sysName;
    /**系统主机名*/
    private String sysHost;
    /**系统端口*/
    private String sysPort;
    /**状态*/
    private String status;
    /**更新人ID*/
    private Long updateUserid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysHost() {
        return sysHost;
    }

    public void setSysHost(String sysHost) {
        this.sysHost = sysHost;
    }

    public String getSysPort() {
        return sysPort;
    }

    public void setSysPort(String sysPort) {
        this.sysPort = sysPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    @Override
    public String toString() {
        return "SysModelDTO{" +
                "id=" + id +
                ", sysName='" + sysName + '\'' +
                ", sysHost='" + sysHost + '\'' +
                ", sysPort='" + sysPort + '\'' +
                ", status='" + status + '\'' +
                ", updateUserid=" + updateUserid +
                '}';
    }
}
