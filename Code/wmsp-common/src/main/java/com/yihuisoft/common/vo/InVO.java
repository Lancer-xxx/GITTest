package com.yihuisoft.common.vo;

import javax.validation.Valid;

/**
 * 定义前端传输统一传输对象
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/14 8:55
 */
public class InVO<T> extends CommonVO{

	/**业务层传输对象*/
	@Valid
	private T data;

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
