package com.yihuisoft.common.util.app;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
  * 处理数据权限的相关工具
  * @author topz
  * @date 2019/8/17 16:36
  * @version V4.0.0
  **/
public class DataAuthUtil {

    /**
      * description
      * @author topz
      * @param list 传入in参数的集合
      * @param parameter 传入in条件的前缀信息如 C.id in(12,13,17) or C.id in(15,18)中的 "C.id"
      * @return java.lang.String
      * @date 14:37 2019/8/19
      **/
    public static String getInParameter(List list, String parameter) {
        if (!list.isEmpty()) {
            List<String> setList = new ArrayList<>(0);
            Set set = new HashSet();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i <= list.size(); i++) {
                set.add("'" + list.get(i - 1) + "'");
                //900为阈值
                if (i % 900 == 0) {
                    setList.add(StringUtils.join(set.iterator(), ","));
                    set.clear();
                }
            }
            if (!set.isEmpty()) {
                setList.add(StringUtils.join(set.iterator(), ","));
            }
            stringBuffer.append(setList.get(0));
            for (int j = 1; j < setList.size(); j++) {
                stringBuffer.append(") OR " + parameter + " IN (");
                stringBuffer.append(setList.get(j));
            }
            //添加前后缀
            stringBuffer.insert(0,parameter+" IN (").append(")");
            return stringBuffer.toString();
        } else {
            return "''";
        }
    }
}
