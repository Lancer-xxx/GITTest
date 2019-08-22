package com.yihuisoft.common.util;

/**
 * 整数工具类
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 15:42
 */
public class IntegerUtils {

    /**
     * 判断是否不是整数
     * @param num
     * @return
     */
    public static boolean isNotPositive(Integer num){
        return (num == null) || (num <= 0);
    }
}
