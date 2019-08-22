package com.yihuisoft.authoritybiz.constant;

/**
 * OutDTO中的data数据的key
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/7/30 19:05
 */
public class RedisConstantsKey {

    /**用户token key 开头*/
    public final static String USER_TOKEN_KEY = "token_user_id_%s";
    /**用户权限规则*/
    public final static String USER_AUTHORITY_RULE_KEY = "user_authority_rule_id_%s";
    /**用户登录信息*/
    public final static String USER_LOGIN_INFO_KEY = "user_login_info_id_%s";


}