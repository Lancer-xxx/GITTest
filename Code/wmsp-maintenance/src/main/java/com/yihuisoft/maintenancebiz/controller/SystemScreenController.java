package com.yihuisoft.maintenancebiz.controller;

import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum;
import com.yihuisoft.maintenancebiz.dto.SystemScreenDTO;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import com.yihuisoft.maintenancebiz.service.screen.FileServerService;
import com.yihuisoft.maintenancebiz.service.screen.SystemScreenService;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenImageAliasNameValidator;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenImageSizeValidator;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenOrganizationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.Date;

import static com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenErrorEnum.SCREEN_IMAGE_IS_EMPTY;
import static com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenValidationErrorMessage.STATUS_ACTIVE;
import static com.yihuisoft.maintenancebiz.constant.systemscreen.SystemScreenValidationErrorMessage.STATUS_INACTIVE;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/7/6
 */
@RequestMapping("wmsp/maintenance/screen")
@RestController
public class SystemScreenController {

    @Autowired
    SystemScreenService systemScreenService;

    @Autowired
    OrganizationService orgnizationService;

    @Autowired
    ScreenImageSizeValidator screenImageSizeValidator;

    @Autowired
    ScreenImageAliasNameValidator screenImageAliasNameValidator;

    @Autowired
    ScreenOrganizationValidator screenOrganizationValidator;

    /**
     * 屏保的新增
     * 1. 屏保图片尺寸不能超过  允许的最大尺寸
     * 2. 屏保的别名 不能重复
     * 3. 屏保的组织机构 需要级别校验重复
     *
     * @param imageFile
     * @param systemScreen
     * @return
     */
    @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OutDTO save(/*@Valid */@RequestParam MultipartFile imageFile, SystemScreen systemScreen) throws IOException {

        // 图片内容处理
        byte[] imageBytes = FileServerService.transferToByte(imageFile);
        systemScreen.setPicture(imageBytes);

        // 1. 校验图片别名重复性
        boolean isFileAliasNameRepeated = systemScreenService.validateFileAliasNameExist(systemScreen);

        if(isFileAliasNameRepeated) {
            return  OutDTOFactory.getSucceedOutDTO().setStatus(OutDTOFactory.STATUS_FAIL)
                    .setErrorCode(SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getCode())
                    .setErrorMsg(SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getMessage());
        }

        // 2. 生成新的文件名
        String fileName = FileServerService.generateFileName(imageFile.getOriginalFilename());
        systemScreen.setFileName(fileName);

        // 3. 将上传人的机构层级和机构代码放入屏保记录中，方便后续外屏按照本级机构优先级大于上级机构的优先顺序展示屏保
        String orgnCode = systemScreen.getOrgnCode();

        String optOrgnLevel;
        Organization org = orgnizationService.getOrganizationInfo(orgnCode);
        // 4. 校验组织机构的存在性

        optOrgnLevel = org ==null ? null : org.getOrgnLevel();
        systemScreen.setOptOrgnLevel(optOrgnLevel);

        systemScreen.setUploadUser(systemScreen.getUploadUser());
        systemScreen.setUploadTime(Date.from(Instant.now()));
        systemScreen.setStatus(STATUS_ACTIVE);

        return systemScreenService.save(systemScreen);
    }


    /**
     * 屏保图片 预览
     *
     * @param invo
     * @return
     */
    @PostMapping("preview")
    public OutDTO preview(@RequestBody InVO<SystemScreen> invo){
        SystemScreen systemScreen = systemScreenService.get(invo.getData()).getInfoData();
        if(systemScreen == null || systemScreen.getPicture() == null){
            return OutDTOFactory.getSucceedOutDTO()
                    .setStatus(OutDTOFactory.STATUS_FAIL)
                    .setErrorCode(SCREEN_IMAGE_IS_EMPTY.getCode())
                    .setErrorMsg(SCREEN_IMAGE_IS_EMPTY.getMessage());
        }

        return OutDTOFactory.getSucceedOutDTO().putInfo(FileServerService.encode(systemScreen.getPicture()));
    }

    /**
     * @Description: 修改屏保记录
     * @Param: MultipartFile,ScreenUploadBean
     * @Version: 1.0.0
     * @Author: laijindi
     * @Date: 2019/5/24
     */
    @PostMapping(value = "/update",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OutDTO uploadScreenImageForUpdate(@RequestParam("imageFile") MultipartFile imageFile,SystemScreen systemScreen) throws IOException {
        if(imageFile != null){
            // 图片内容处理
            byte[] imageBytes = FileServerService.transferToByte(imageFile);
            systemScreen.setPicture(imageBytes);

            // 图片名称处理
            String fileName = FileServerService.generateFileName(imageFile.getOriginalFilename());
            systemScreen.setFileName(fileName);

            systemScreen.setUploadTime(Date.from(Instant.now()));

            //将上传人的机构层级和机构代码放入屏保记录中，方便后续外屏按照本级机构优先级大于上级机构的优先顺序展示屏保
            String orgnCode = systemScreen.getOrgnCode();

            String optOrgnLevel;
            Organization org = orgnizationService.getOrganizationInfo(orgnCode);

            // 校验组织机构的存在性
            optOrgnLevel = org ==null ? null : org.getOrgnLevel();
            systemScreen.setOptOrgnLevel(optOrgnLevel);
        }else{
            systemScreen.setPicture(null);
        }

        return this.update(systemScreen);
    }

    /**
     * 屏保启用状态的变更
     * 启用 -》 禁用
     *
     * @param inVO
     * @return
     */
    @PostMapping(value = "/update_status")
    public OutDTO updateStatus( @RequestBody InVO<SystemScreen> inVO){
        SystemScreen systemScreen = inVO.getData();
        SystemScreen screenBean = new SystemScreen();
        screenBean.setId(systemScreen.getId());

        SystemScreen systemScreenDO  = systemScreenService.get(screenBean).getInfoData();

        String status = systemScreenDO.getStatus() == null ||systemScreenDO.getStatus().equals(STATUS_INACTIVE) ? STATUS_ACTIVE : STATUS_INACTIVE ;
        systemScreen.setStatus(status);
        return systemScreenService.updateById(systemScreen);
    }

    /**
     * 屏保信息的修改 不涉及图片本身
     *
     * @param inVO
     * @return
     * @throws BindException
     */
    @PostMapping(value = "/update_screen_info")
    public OutDTO update(@RequestBody InVO<SystemScreen> inVO){
        SystemScreen systemScreen = inVO.getData();
        systemScreen.setPicture(null);

        return this.update(systemScreen);
    }

    /**
     * 屏保数据的更新
     *  1. 校验屏保别名的 重名
     *  2. 组织机构的存在性 校验
     *
     * @param systemScreen
     * @return
     * @throws BindException
     */
    public OutDTO update(@Validated SystemScreen systemScreen){
        SystemScreen screenBean = new SystemScreen();
        screenBean.setId(systemScreen.getId());

        SystemScreen systemScreenDO  = systemScreenService.get(screenBean).getInfoData();

        // 1. 文件别名检验
        boolean isFileAliasNameRepeated = systemScreenService.validateFileAliasNameExist(systemScreen);

        if(!systemScreenDO.getFileAliasName().equals(systemScreen.getFileAliasName()) && isFileAliasNameRepeated) {
            return  OutDTOFactory.getSucceedOutDTO().setStatus(OutDTOFactory.STATUS_FAIL)
                    .setErrorCode(SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getCode())
                    .setErrorMsg(SystemScreenErrorEnum.IMAGE_FILE_ALIAS_NAME_EXIST_ERROR.getMessage());
        }

        systemScreen.setUpdateTime(Date.from(Instant.now()));
        return systemScreenService.updateById(systemScreen);
    }

    /**
     * 查询屏保的分页
     *
     * @param pagerVO
     * @return
     */
    @PostMapping(value = "list")
    public OutDTO list(@RequestBody PagerVO<SystemScreenDTO> pagerVO){
        return systemScreenService.search(pagerVO);
    }

    /**
     * 获取单个屏保的具体信息
     *
     * @param inVO
     * @return
     */
    @PostMapping(value = "get")
    public OutDTO get( @RequestBody InVO<SystemScreen> inVO){
        return systemScreenService.get(inVO.getData());
    }


    /**
     * 屏保的 删除
     * @param inVO
     * @return
     */
    @PostMapping("delete")
    public OutDTO delete(@RequestBody InVO<SystemScreen> inVO){
        return systemScreenService.deleteById(inVO.getData());
    }
}
