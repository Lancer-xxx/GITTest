package com.yihuisoft.maintenancebiz.entity.screen;

/**
 * @Description:新增/修改屏保实体类
 * @Version: 1.0.0
 * @Author: laijindi
 * @Date: 2019/5/22
 */
public class ScreenUploadBean {

    /**图片文件的名称*/
    private String fileAliasName;
    /**上传人姓名*/
    private String uploadUser;
    /**屏保状态*/
    private String status;
    /**屏保机构代码*/
    private String orgnCode;
    /**屏保机构名称*/
    private String orgnName;
    /**上传人机构代码*/
    private String optOrgnCode;
    /**上传人用户编码*/
    private String optUserCode;
    /**修改时传入选中记录ID。新增时置空*/
    private String id;


    public String getOptUserCode() {
        return optUserCode;
    }
    public void setOptUserCode(String optUserCode) {
        this.optUserCode = optUserCode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ScreenUploadBean{" +
                ", fileAliasName='" + fileAliasName + '\'' +
                ", uploadUser='" + uploadUser + '\'' +
                ", status='" + status + '\'' +
                ", orgnCode='" + orgnCode + '\'' +
                ", orgnName='" + orgnName + '\'' +
                ", optOrgnCode='" + optOrgnCode + '\'' +
                '}';
    }

    public String getFileAliasName() {
        return fileAliasName;
    }

    public void setFileAliasName(String fileAliasName) {
        this.fileAliasName = fileAliasName;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode;
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName;
    }

    public String getOptOrgnCode() {
        return optOrgnCode;
    }

    public void setOptOrgnCode(String optOrgnCode) {
        this.optOrgnCode = optOrgnCode;
    }
}
