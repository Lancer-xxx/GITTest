/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.yihuisoft.authoritybiz.service.token.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yihuisoft.authoritybiz.service.discache.DistributeCacheService;
import com.yihuisoft.authoritybiz.service.token.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * token实现类
 *
 * @author zhangsh
 * @version V4.0.0
 * @date 2019/8/1
 */

@Service("tokenService")
public class TokenServiceImpl  implements TokenService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DistributeCacheService distributeCacheService;

	public static String SECRET = "yihuisoft.com";
	/**
	 * 12小时后过期
	 */
	private final static long EXPIRE = 1800;
	/**
	 * 获取token
	 *
	 * @param token
	 * @return
	 */
	@Override
	public String getByToken(String token) {
		String rt=distributeCacheService.getUserToken(token);
		return rt;
	}
	/**
	 * 创建token
	 *
	 * @param tokenKey
	 * @return
	 */
	@Override
	public String createToken(String tokenKey)  throws  Exception{
		//签发时间

		Date istDate = new Date();
		//设置过期时间
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, 1);
		Date expiresDate = nowTime.getTime();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");

		String token = JWT.create()
				.withHeader(map)
				.withClaim("tokenKey", tokenKey)
				.withClaim("tokenKey", tokenKey)
				.withExpiresAt(expiresDate)
				.withIssuedAt(istDate)
				.sign(Algorithm.HMAC256(SECRET));
		try{
			distributeCacheService.setUserToken(tokenKey,token,EXPIRE);
		}catch (Exception e){
			logger.error(getClass().getName()+e.getMessage(), e);
		}



		return token;
	}

	/**
	 * 设置oken
	 *
	 * @param k
	 * @param k
	 * @return
	 */
	@Override
	public void setToken(String  k,String v){

		try{
			distributeCacheService.setUserToken(k,v,EXPIRE);
		}catch (Exception e){
			logger.error(getClass().getName()+e.getMessage(), e);
		}

	}


}
