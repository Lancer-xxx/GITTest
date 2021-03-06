package com.yihuisoft.maintenancebiz.entity.screen;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihuisoft.common.validator.Group;
import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenValidationErrorMessage;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/6/25
 */
public class SystemScreen {
    /**ID*/
    @NotNull(message = SystemScreenValidationErrorMessage.ID_IS_NULL_ERROR,groups = {Group.update.class})
    private Long id;
    /**文件名*/
    private String fileName;
    /**新文件名*/
    private String fileAliasName;
    /**上传时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uploadTime;
    /**上传人*/
    private String uploadUser;
    /**屏保状态*/
    private String status;
    /**上传的图片*/
    private byte[] picture;
    /** 组织编码：屏保记录的归属机构代码*/
    @NotNull(message = SystemScreenValidationErrorMessage.ORG_CODE_EMPTY_ERROR,groups = {Group.save.class})
    private String orgnCode;
    /**屏保记录的归属机构名称*/
    private String orgnName;

    /**屏保功能优化新增字段
     *新增屏保的人所属机构编码*/
    private String optOrgnCode;
    /**新增屏保的人所属机构层级*/
    private String optOrgnLevel;
    /**新增屏保的人的用户代码*/
    private String optUserCode;
    /**修改人用户代码*/
    private String updateUser;
    /**修改时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getOptOrgnCode() {
        return optOrgnCode;
    }

    public void setOptOrgnCode(String optOrgnCode) {
        this.optOrgnCode = optOrgnCode;
    }

    public String getOptOrgnLevel() {
        return optOrgnLevel;
    }

    public void setOptOrgnLevel(String optOrgnLevel) {
        this.optOrgnLevel = optOrgnLevel;
    }

    public String getOptUserCode() {
        return optUserCode;
    }

    public void setOptUserCode(String optUserCode) {
        this.optUserCode = optUserCode;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileAliasName() {
        return fileAliasName;
    }

    public void setFileAliasName(String fileAliasName) {
        this.fileAliasName = fileAliasName == null ? null : fileAliasName.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser == null ? null : uploadUser.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileAliasName='" + fileAliasName + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadUser='" + uploadUser + '\'' +
                ", status='" + status + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", orgnCode='" + orgnCode + '\'' +
                ", orgnName='" + orgnName + '\'' +
                ", optOrgnCode='" + optOrgnCode + '\'' +
                ", optOrgnLevel='" + optOrgnLevel + '\'' +
                ", optUserCode='" + optUserCode + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
