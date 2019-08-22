package com.yihuisoft.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入报文基类
 * @author tonywu
 * @version v1.0.0
 */
public class InDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -665726420933309515L;

	/**模块名*/
	private String moduleName;
	/**功能名*/
	private String functionName;
	/**方法名*/
	private String methodName;

	/**登录id号*/
	private String loginId;
	/**调用者id号*/
	private String callerId;
	/**IP地址*/
	private String ip;
	/**版本号*/
	private String version;

	//分页用
	/**页号*/
	private Integer pageNo;
	/**页尺寸*/
	private Integer pageSize;

	/**一般为Map对象*/
	private Map<String, Object> data;

	/**安全验证字符串：计划pc时HASH签名，移动端时：为token*/
	private String securityStr;

	/**token*/
	//private String token;

	/**
	 * 构造函数
	 */
	public InDTO()
	{
		data =  new HashMap<String, Object>();
	}
	/**
	 * 获取模块名
	 * @return moduleName  模块名
	 */
	public String getModuleName() {
		return moduleName;
	}
	/**
	 * 设置模块名
	 * @param  moduleName  模块名
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * 获取功能名
	 * @return functionName  功能名
	 */
	public String getFunctionName() {
		return functionName;
	}
	/**
	 * 设置功能名
	 * @param  functionName  功能名
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	/**
	 * 获取方法名
	 * @return methodName  方法名
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * 设置方法名
	 * @param  methodName  方法名
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * 获取登录id号
	 * @return loginId  登录id号
	 */
	public String getLoginId() {return loginId;}
	/**
	 * 设置登录id号
	 * @param  loginId  登录id号
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * 获取调用者id号
	 * @return callerId  调用者id号
	 */
	public String getCallerId() {return callerId;}
	/**
	 * 设置调用者id号
	 * @param  callerId  调用者id号
	 */
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	/**
	 * 获取ip地址
	 * @return ip  IP地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置ip地址
	 * @param  ip  IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取版本号
	 * @return version  版本号
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * 设置版本号
	 * @param  version  版本号
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取分页页号
	 * @return pageNo  页号(分页用)
	 */
	public Integer getPageNo() {
		return pageNo;
	}
	/**
	 * 设置分页页号
	 * @param  pageNo  页号(分页用)
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * 获取分页尺寸
	 * @return pageSize  页尺寸(分页用)
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 设置分页尺寸
	 * @param  pageSize  页尺寸(分页用)
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取数据map集合
	 * @return data  数据Map
	 */
	public Map<String, Object> getData() {
		return data;
	}
	/**
	 * 设置数据map集合
	 * @param  data  数据Map
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	/**
	 * 获取安全验证字符串
	 * @return securityStr  安全验证字符串：计划pc时HASH签名，移动端时：为token
	 */
	public String getSecurityStr() {return securityStr;}
	/**
	 * 设置安全验证字符串
	 * @param  securityStr  安全验证字符串：计划pc时HASH签名，移动端时：为token
	 */
	public void setSecurityStr(String securityStr) {
		this.securityStr = securityStr;
	}

	/**
	 * 存放数据信息
	 * @param k 数据的属性
	 * @param v 数据属性对应的值
	 */
	public void put(String k,Object v){
         this.data.put(k,v);
	}
	/**
	 * 获取数据的信息
	 * @param k 数据的属性
	 * @return 数据属性对应的值
	 */
	public Object get(String k){
		return this.data.get(k);
	}

}
