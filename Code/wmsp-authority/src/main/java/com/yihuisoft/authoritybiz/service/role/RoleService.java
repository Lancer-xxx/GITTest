package com.yihuisoft.authoritybiz.service.role;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.common.exception.ApplicationException;

/**
 * 角色启用禁用
 * @author zhagsh
 * @date 2019/8/3 14:38
 * @version V4.0.0
 **/
public interface RoleService {

    /**
      * 禁用角色
      * @author ZHANGSH
      * @param  user
      * @return boolean
      * @date 13:41 2019/8/3
      **/
    boolean disabledRole(User user) throws ApplicationException;

    /**
     * 启用角色
     * @author ZHANGSH
     * @param user
     * @return boolean
     * @date 13:41 22019/8/3
     **/
    boolean enableRole(User user) throws ApplicationException;




}
