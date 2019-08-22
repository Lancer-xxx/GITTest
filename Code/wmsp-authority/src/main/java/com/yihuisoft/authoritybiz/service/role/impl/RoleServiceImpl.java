package com.yihuisoft.authoritybiz.service.role.impl;

import com.yihuisoft.authoritybiz.constant.RedisConstantsKey;
import com.yihuisoft.authoritybiz.entity.menu.Menu;
import com.yihuisoft.authoritybiz.entity.menu.RoleMenuDO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.entity.role.Role;
import com.yihuisoft.authoritybiz.entity.token.LoginUser;
import com.yihuisoft.authoritybiz.entity.user.User;
import com.yihuisoft.authoritybiz.mapper.menu.MenuMapper;
import com.yihuisoft.authoritybiz.mapper.role.RoleRelatedMapper;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.authoritybiz.service.login.UserLoginService;
import com.yihuisoft.authoritybiz.service.menu.MenuService;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.authoritybiz.service.role.RoleService;
import com.yihuisoft.authoritybiz.service.token.TokenService;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色启用禁用
 *
 * @author zhagsh
 * @version V4.0.0
 * @date 2019/8/3 14:38
 **/
@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginService.class);
    @Autowired
    private RoleRelatedMapper roleRelatedMapper;
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private DistributeCacheService distributeCacheService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuService menuService;

    /**
     * 禁用角色
     *
     * @param user
     * @return boolean
     * @author ZHANGSH
     * @date 13:41 2019/8/3
     **/

    @Override
    public boolean disabledRole(User user) throws ApplicationException {
        boolean enableStatus = false;
        LoginUser loginUser = new LoginUser();
        logger.info("当前用户账号userCode=" + user.getUserCode() + ", orgnCode=" + user.getOrgnCode() + ",用户角色ID=" + user.getRoleId() + ",用户角色编码=" + user.getRoleCode());
        try {
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()));
            loginUser=distributeCacheService.getUserAuthority(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()));
            if(!ObjectUtils.isEmpty(loginUser)){
                loginUser.setList(null);
                loginUser.setMenuList(null);
            }
            distributeCacheService.setLoginUserInfo(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()), loginUser);
            enableStatus = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(ResultEnum.RROR_ROLE_DISENABLE_FAIL);
        }

        return enableStatus;
    }


    /**
     * 启用角色
     *
     * @param user
     * @return boolean
     * @author ZHANGSH
     * @date 13:41 2019/8/3
     **/
    @Override
    public boolean enableRole(User user) throws ApplicationException {
        boolean enableStatus = false;
        LoginUser loginUser = new LoginUser();
        logger.info("当前用户账号userCode=" + user.getUserCode() + ", orgnCode=" + user.getOrgnCode() + ",用户角色ID=" + user.getRoleId() + ",用户角色编码=" + user.getRoleCode());
        try {
            Organization organizationInfo = organizationService.getOrganizationInfo(user.getOrgnCode());
            Role roleInfo = roleRelatedMapper.findRoleById(user.getRoleId());
            loginUser.setOrganization(organizationInfo);
            loginUser.setRole(roleInfo);
            loginUser.setUser(user);
            loginUser.setUserId(user.getId().toString());
            if ("1008".equals(user.getRoleCode())) {
                loginUser.setIsManage("1");
            }
            // 导航数据
            List<Menu> menuList = new ArrayList<Menu>();
            if (!ObjectUtils.isEmpty(roleInfo)) {
                menuList = menuMapper.getSysByRoleId(roleInfo.getId());
            }

            List<Menu> list = menuService.getChildsManyGroup(menuList, 0);
            loginUser.setList(list);
            List<RoleMenuDO> roleMenuRespDTOList = menuMapper.getListByRoleId(roleInfo.getId());
            loginUser.setMenuList(roleMenuRespDTOList);
            String redisToken = tokenService.getByToken(String.format(RedisConstantsKey.USER_TOKEN_KEY, user.getId()));
            loginUser.setToken(redisToken);
            distributeCacheService.setLoginUserInfo(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()), loginUser);
            //2-把这个用户对应的权限也放进缓存中，并同时在缓存中做好拦截配置的准备工作
            distributeCacheService.setUserAuthorityInterceptorUrl(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()), roleMenuRespDTOList);
            enableStatus = true;
        } catch (Exception e) {
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_TOKEN_KEY, user.getId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_AUTHORITY_RULE_KEY, user.getId()));
            distributeCacheService.delete(String.format(RedisConstantsKey.USER_LOGIN_INFO_KEY, user.getId()));
            logger.error(e.getMessage(), e);
            throw new ApplicationException(ResultEnum.RROR_ROLE_ENABLE_FAIL);
        }

        return enableStatus;
    }
}
