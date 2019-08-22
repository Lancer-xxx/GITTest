package com.yihuisoft.common.vo;

import static com.yihuisoft.common.util.IntegerUtils.isNotPositive;

/**
 * 封装分页查询信息
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 15:32
 */
public class PageMessage {

    /**查询分页的第几页*/
    Integer pageNo;
    /**分页查询一页展示几条*/
    Integer pageSize;

    /**
     * 校验分页查询信息
     * 分页查询，默认返回第一页，一页返回10条
     * @param pageMessage 分页信息
     * @return 校验合格的分页查询信息
     */
    public static PageMessage check(PageMessage pageMessage){

        if(pageMessage == null){
            return new PageMessage(1,10);
        }
        if(isNotPositive(pageMessage.pageNo)){
            pageMessage.pageNo = 1;
        }
        if(isNotPositive(pageMessage.pageSize)){
            pageMessage.pageSize = 10;
        }
        return pageMessage;
    }

    public PageMessage() {
    }

    public PageMessage(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
