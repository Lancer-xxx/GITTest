package com.yihuisoft.common.vo;

/**
 * 定义前端传输公共字段
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/14 8:55
 */
public class CommonVO<T>{

	/**发送机构代码*/
	private String sendInsCode;
	/**接受机构代码*/
	private String receiveInsCode;
	/**发送系统编号*/
	private String sendSystemId;
	/**系统认证token*/
	private String systemToken;
	/**用户认证token*/
	private String userToken;
	/**接口版本号*/
	private String version;

	public String getSendInsCode() {
		return sendInsCode;
	}

	public void setSendInsCode(String sendInsCode) {
		this.sendInsCode = sendInsCode;
	}

	public String getReceiveInsCode() {
		return receiveInsCode;
	}

	public void setReceiveInsCode(String receiveInsCode) {
		this.receiveInsCode = receiveInsCode;
	}

	public String getSendSystemId() {
		return sendSystemId;
	}

	public void setSendSystemId(String sendSystemId) {
		this.sendSystemId = sendSystemId;
	}

	public String getSystemToken() {
		return systemToken;
	}

	public void setSystemToken(String systemToken) {
		this.systemToken = systemToken;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
