

package com.yihuisoft.authoritybiz.service.token;

/**
 * token接口
 * @author zhangsh
 * @date 2019/7/29 16:35
 * @version V4.0.1
 **/
public interface TokenService {

	String getByToken(String token);

	/**
	 * 生成token
	 * @param
	 * @return        返回token信息
	 */
	String createToken(String tokenKey) throws  Exception;

	/**
	 * 设置token过期
	 * @param k key
	 * @param v value
	 */
	void setToken(String  k,String v);

}
