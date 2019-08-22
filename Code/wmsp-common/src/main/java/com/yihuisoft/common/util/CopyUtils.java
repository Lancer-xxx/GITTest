package com.yihuisoft.common.util;

import org.springframework.cglib.beans.BeanCopier;

/**
 * 复制工具类
 * @author huangxj
 * @version V4.0.0
 * @date 2019/6/28 12:48
 */
public class CopyUtils {

    /**
     * 完成bean之间的拷贝
     * @param source 源对象
     * @param dest 目标对象
     */
    public static void copy(Object source, Object dest){
        if (source != null) {
            BeanCopier copier = BeanCopier.create(source.getClass(), dest.getClass(), false);
            copier.copy(source, dest, null);
        }
    }
}
