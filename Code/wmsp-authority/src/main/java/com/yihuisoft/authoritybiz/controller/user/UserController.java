package com.yihuisoft.authoritybiz.controller.user;

import com.yihuisoft.authoritybiz.dto.user.*;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.mapper.user.UserMapper;
import com.yihuisoft.authoritybiz.service.user.UserService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.DataUtil;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.excel.BeanToExcel;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 人员管理控制层
 * @author laijd
 * @date 2019/06/21
 * @version V4.0.0
 * */
@RestController
@RequestMapping("/wmsp/authority/user")
public class UserController {

    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    String getUserListExcelName(){
        StringBuilder stringBuilder = new StringBuilder("人员列表");
        stringBuilder.append(dateFormat.format(new Date()));
        stringBuilder.append(".xls");
        return stringBuilder.toString();
    }

    /**
     * 人员信息导出
     * @param inVO
     * @return
     * @throws ApplicationException
     */
    @PostMapping(value = "/export")
    public void exportUsers(@Validated @RequestBody InVO<UserListDTO> inVO, HttpServletResponse response) throws Exception {
        Map<String,Object> userMap = new HashMap<>();
        try {
            userMap = DataUtil.Object2Map(inVO.getData());
        } catch (IllegalAccessException e) {
            logger.error("列表查询时，用户分页实体（UserListDTO）转换为map异常！");
        }
        List<User> list = userMapper.getUserList(userMap);

        List<User> users = new ArrayList<>();
        for (User u : list) {
            String idNo = u.getIdNo();
            String phone = u.getPhone();
            if (idNo == null || "".equals(idNo)) {
                u.setIdNo("-");
            } else if (idNo.length() > 8) {
                u.setIdNo(idNo.substring(0, 5) + "******" + idNo.substring(idNo.length() - 3, idNo.length()));
            }
            if (phone == null || "".equals(phone)) {
                u.setPhone("-");
            } else if (phone.length() > 6) {
                u.setPhone(phone.substring(0, 3) + "******" + phone.substring(phone.length() - 3, phone.length()));
            }
            Map<String, Object> userState = userService.getUserState("userState");
            u.setStatus(userState.get(u.getStatus()).toString());
            users.add(u);
        }

        // 格式化Excel
        Workbook wb = BeanToExcel.getWorkBook(users, null);

        response.setCharacterEncoding("UTF-8");
        // 设置contentType为excel格式
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(getUserListExcelName(), "utf-8"));
        response.flushBuffer();
        wb.write(response.getOutputStream());
    }

    /**
     * 查询用户信息列表
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/list")
    public OutDTO listUsers(@Validated @RequestBody PagerVO<UserListDTO> inVO)  {
        return userService.listUsers(inVO.getData(), inVO.getPageMessage());
    }

    /**
     * 重置密码
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/reset")
    public OutDTO resetPassWord(@Validated @RequestBody InVO<UserResetDTO> inVO) {
        return userService.resetUserPassword(inVO.getData());
    }

    /**
     * 新增用户信息
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/save")
    public OutDTO saveUser(@Validated @RequestBody InVO<UserInsertDTO> inVO)  {
        return userService.saveUser(inVO.getData());
    }

    /**
     * 更新用户信息
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/update")
    public OutDTO updateUser(@Validated @RequestBody InVO<UserUpdateDTO> inVO)  {
        return userService.updateUser(inVO.getData());
    }

    /**
     * 检查用户是否存在
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/check")
    public OutDTO checkUserExist(@RequestBody InVO<UserCheckDTO> inVO)  {
        return userService.checkUserExist(inVO.getData());
    }
    /**
     * 查找用户机构代码
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get_user_organization")
    public OutDTO getUserOrganization(@Validated @RequestBody InVO<UserGetInfoDTO> inVO)  {
        return userService.getUserOrganization(inVO.getData());
    }
    /**
     * 查找用户数据权限
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get_user_role_info")
    public OutDTO getUserInfoRoleInfoByParam(@Validated @RequestBody InVO<UserGetInfoDTO> inVO)  {
        return userService.getUserInfoRoleInfoByParam(inVO.getData());
    }

    /**
     * 查询用户状态字典值
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get_state_dict")
    public OutDTO getUserState(@Validated @RequestBody InVO<SysDicTypeDTO> inVO)  {
        Map<String, Object> userState = userService.getUserState(inVO.getData().getDictTypeCode());
        return OutDTOFactory.getSucceedOutDTO().putInfo(userState);
    }

    /**
     * 根据机构查询当前机构下的用户信息()
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get_user_by_orgn")
    public OutDTO getUserByOrgn(@Validated @RequestBody InVO<UserListDTO> inVO)  {
        return userService.getUserByOrgn(inVO.getData());
    }

}
