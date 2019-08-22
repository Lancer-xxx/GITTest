package com.yihuisoft.maintenancebiz.constant;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName yihui-maintenance
 * @Description:
 * @date 2019/7/15
 */
public final class OutConstant {

    public static final String STATUS = "status";

    public static final String RESPONSE_SUCCESS = "success";
    public static final String RESPONSE_FAIL = "failed";

    public static final String RESPONSE_FAILED_FIELD_MSSG = "false";

    public static final class PaginationConstant{
        public static final String PAGE_TOTAL_COUNT = "total";

        private PaginationConstant(){

        }
    }

    public static final int SQL_RESULT_SUCCESS = 1 ;

    public static final int SQL_RESULT_FAIL = 2 ;

    private OutConstant(){

    }
}
