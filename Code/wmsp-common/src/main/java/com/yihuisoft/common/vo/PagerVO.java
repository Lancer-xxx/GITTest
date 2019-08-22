package com.yihuisoft.common.vo;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author dim
 * @Title: PagerVO
 * @ProjectName yihuisoft-common
 * @Description: 用于处理前端的页面分页传值
 * @version V4.0.0
 * @date 2019/6/20
 */
public class PagerVO<T> extends  CommonVO implements Serializable {

    /**业务层传输对象*/
    @Valid
    T data;
    /**分页信息*/
    private PageMessage pageMessage;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageMessage getPageMessage() {
        return pageMessage;
    }

    public void setPageMessage(PageMessage pageMessage) {
        this.pageMessage = pageMessage;
    }
}
