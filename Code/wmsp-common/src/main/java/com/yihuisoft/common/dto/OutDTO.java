package com.yihuisoft.common.dto;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回传输对象
 * @author huangxj
 * @version V4.0.0
 * @date 2019/7/30 19:16
 */
public class OutDTO<T> implements Serializable{

	/**返回状态 0 成功 1 失败*/
	private String status;
	/**错误码*/
	private String errorCode;
	/**错误消息*/
	private String errorMsg;
	/**记录总数 分页用*/
	private Integer sumCount;
    /**一般为Map对象*/
	private Map<String, Object> data;

	/**返回信息key值*/
	public final static String RESULT_LIST = "list";
	public final static String RESULT_INFO = "info";


	private List<T> listData;
	private T infoData;
	/**
	 * 构造函数
	 */
	public OutDTO() {
		data =  new HashMap<>();
	}

	public OutDTO(String errorCode, String errorMsg) {
		super();
		data =  new HashMap<>();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	/**
	 *
	 * @return 错误码
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置错误码、错误信息
	 * @param errorCode 错误码
	 * @param errorMsg 错误信息
	 */
	public OutDTO setErrorCode(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg= errorMsg;
		return this;
	}

	/**
	 * 设置错误码
	 * @param errorCode 错误码
	 */
	public OutDTO setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	/**
	 * 获取错误信息
	 * @return 错误信息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 设置错误信息
	 * @param errorMsg 错误信息
	 */
	public OutDTO setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	/**
	 * 获取总条数
	 * @return 总条数
	 */
	public Integer getSumCount() {
		return sumCount;
	}

	/**
	 * 设置总条数
	 * @param sumCount 总条数
	 */
	public OutDTO setSumCount(Long sumCount) {
		this.sumCount = Integer.parseInt(sumCount.toString());
		return this;
	}

	/**
	 * 获取数据map
	 * @return 数据map
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * 设置数据map
	 * @param data 数据map
	 */
	public OutDTO setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OutDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * 往数据map里存键值对
	 * @param k 数据的键
	 * @param v 数据键对应的值
	 */
	public OutDTO put(String k,Object v){
		this.data.put(k,v);
		return this;
	}

	/**
	 * 从数据map取键对应的值
	 * @param k 键
	 * @return k键对应的值
	 */
	public Object get(String k){
		return this.data.get(k);
	}

	/**
	 * 返回信息中添加list
	 * @param list
	 * @return
	 */
	public OutDTO putList(List<T> list){
		this.listData = list;
		this.put(OutDTO.RESULT_LIST,list);
		return this;
	}
	/**
	 * 返回信息中添加实体
	 * @param info
	 * @return
	 */
	public OutDTO putInfo(T info){
		this.infoData = info;
		this.put(OutDTO.RESULT_INFO,info);
		return this;
	}

	@Transient
	public List<T> getListData() {
		return listData;
	}

	@Transient
	public T getInfoData() {
		return infoData;
	}
}
