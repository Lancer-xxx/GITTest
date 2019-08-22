package com.yihuisoft.common.util;

import com.yihuisoft.common.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据工具类
 *
 * @author tonywu
 * @version v1.0.0
 */
public class DataUtil {

    /**
     * 将属性由驼峰转换为大写下划线 如：memberId => MEMBER_ID
     *
     * @param obj 被转换的字节码对象
     * @return 转换后的成员变量List
     */
    public static List<String> paramLowToUpper(Class obj) {
        Field[] fields = obj.getDeclaredFields();
        List<String> fieldNames = new ArrayList<String>();
        for (int i = 0; i < fields.length; i++) {
            StringBuffer paramBuf = new StringBuffer();
            String paramName = fields[i].getName();
            String[] splitParamName = paramName.split("(?=[A-Z])");
            for (int j = 0; j < splitParamName.length; j++) {
                if (j == 0) {
                    //param = param + splitParamName[j].toUpperCase();
                    paramBuf.append(splitParamName[j].toUpperCase());
                } else {
                    //param = param + "_" + splitParamName[j].toUpperCase();
                    paramBuf.append("_").append(splitParamName[j].toUpperCase());
                }
            }
            fieldNames.add(paramBuf.toString());
        }
        return fieldNames;
    }

    /**
     * 类名由驼峰转下大写划线 （例：CacheUtils --> CACHE_UTILS）
     *
     * @param obj 字节码实例
     * @return 转换后的名字
     */
    public static String classNameLowToUpper(Class obj) {
        String classFullNameLower = obj.getName();
        String classNameLower = classFullNameLower.substring(classFullNameLower.lastIndexOf('.') + 1);
        String[] splitClassNameLower = classNameLower.split("(?=[A-Z])");
        StringBuffer tableNameBuf = new StringBuffer();
        for (int j = 0; j < splitClassNameLower.length; j++) {
            if (StringUtils.isEmpty(splitClassNameLower[j])) {
                continue;
            } else {
                if (StringUtils.isEmpty(tableNameBuf.toString())) {
                    //tableName = splitClassNameLower[j].toUpperCase();
                    tableNameBuf.append(splitClassNameLower[j].toUpperCase());
                } else {
                    tableNameBuf.append("_").append(splitClassNameLower[j].toUpperCase());
                    //tableName = tableName + "_" + splitClassNameLower[j].toUpperCase();
                }
            }
        }
//        for (int j = 1; j <= splitClassNameLower.length; j++) {
//            if (j == 1) {
//                tableName = tableName + splitClassNameLower[j-1].toUpperCase();
//            } else {
//                tableName = tableName + "_" + splitClassNameLower[j-1].toUpperCase();
//            }
//        }
        return tableNameBuf.toString();
    }


    /***
     *  条件小写变大写
     * @param param
     * @return
     */
    public static Map<String, Object> conditionLowToUpper(Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            String lowKey = entry.getKey();
            StringBuffer upperKeyBuf = new StringBuffer();
            String[] splitParamName = lowKey.split("(?=[A-Z])");
            for (int j = 0; j <= splitParamName.length; j++) {
                if (j == 0) {
                    //upperKey = upperKey + splitParamName[j].toUpperCase();
                    upperKeyBuf.append(splitParamName[j].toUpperCase());
                } else {
                    upperKeyBuf.append("_").append(splitParamName[j].toUpperCase());
                    //upperKey = upperKey + "_" + splitParamName[j].toUpperCase();
                }
            }
            map.put(upperKeyBuf.toString(), entry.getValue());
        }
        return map;
    }

    /***
     * 字符串驼峰转下划线大写 如：memberId => MEMBER_ID
     * @param prop 被转换的驼峰字符串
     * @return 转换后的大写下划线字符串
     */
    public static String conditionLowToUpper(String prop) {
        StringBuffer upperKeyBuf = new StringBuffer();
        String[] splitParamName = prop.split("(?=[A-Z])");
        for (int j = 1; j <= splitParamName.length; j++) {
            if (j == 1) {
                //upperKey = upperKey + splitParamName[j-1].toUpperCase();
                upperKeyBuf.append(splitParamName[j - 1].toUpperCase());
            } else {
                //upperKey = upperKey + "_" + splitParamName[j-1].toUpperCase();
                upperKeyBuf.append("_").append(splitParamName[j - 1].toUpperCase());
            }
        }
        return upperKeyBuf.toString();
    }

    /**
     * @Description 实体类转换为map
     * @Param obj 实例对象
     * @Return java.util.Map<java.lang.String   ,   java.lang.Object> 转换后的map对象
     * @Version 1.0
     * @Author topz
     * @since 15:13 2019/3/1
     **/
    public static Map<String, Object> Object2Map(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        exceClass(obj, map, clazz);
        return map;
    }

    private static void exceClass(Object obj, Map<String, Object> map, Class<?> clazz) throws IllegalAccessException {
        if (clazz != Object.class) {
            returnclassF(obj, map, clazz);
            Class<?> clazzs = clazz.getSuperclass();
            exceClass(obj, map, clazzs);
        }
    }

    private static void returnclassF(Object obj, Map<String, Object> map, Class<?> clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(obj);
            map.put(key, value);
        }
    }

    /**
     * 将字节数组转换为base64编码
     *
     * @param bytes 字节数组
     * @return base64后的字符
     */
    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        String string = encoder.encode(bytes).replaceAll("\r\n", "");
        return string;
    }

    /**
     * @Description 必要参数校验：校验前端传参并返回字符串类型参数（待完善..）
     * @Param [ob, tip, logger]
     * @Return java.lang.String
     * @Version 1.0
     * @Author topz
     * @since 22:07 2019/3/20
     **/
    @Deprecated
    public static String paramTrans(Object ob, String tip, Logger logger) throws ApplicationException {
        String res = "";
        if (ob == null) {
            logger.error(tip);
            throw new ApplicationException(tip);
        } else if (ob instanceof String) {
            res = ob.toString();
        } else {
            res = ob + "";
        }
        return res;
    }

    /**
     * @Description 非必要参数校验，不终止程序
     * @Param [ob, tip, logger, flag]
     * @Return java.lang.String
     * @Version 1.0
     * @Author topz
     * @since 22:12 2019/3/20
     **/
    public static String paramVerify(Object ob, String tip, Logger logger, int flag) throws ApplicationException {
        String res = "";
        if (ob == null) {
            logger.info(tip);
            if (flag == 0) {
                res = "";
            } else if (flag == 1) { //返回数字类型参数处理，防止数字转换报错，待完善..
                res = "0";
            }
        } else {
            res = ob + "";
        }
        return res;
    }

    /**
     * main函数
     *
     * @param args

    public static void main(String[] args) {
    //        Map map = new HashMap<String,String>();
    //        map.put("abc","www");
    //        map.put("VcF","ttt");
    //        System.out.println(conditionLowToUpper(map));
    System.out.println(conditionLowToUpper("dsjajUUUUdjlksajd"));
    System.out.println(paramLowToUpper(CacheUtils.class));
    System.out.println(classNameLowToUpper(CacheUtils.class));
    List<String> fieldNames = new ArrayList<String>();
    String[] fields = {"integer", "inteGood", "inteGoodKeed"};
    for (int i = 0; i < fields.length; i++) {
    String param = "";
    String paramName = fields[i];
    String[] splitParamName = paramName.split("(?=[A-Z])");
    for (int j = 0; j < splitParamName.length; j++) {
    if (j == 0) {
    param = param + splitParamName[j].toUpperCase();
    } else {
    param = param + "_" + splitParamName[j].toUpperCase();
    }
    }
    fieldNames.add(param);
    }
    for (String s : fieldNames) {
    System.out.println("+++++++++" + s);
    }

    System.out.println("memberID conditionLowToUpper:" + conditionLowToUpper("memberId"));
    System.out.println("memberID conditionLowToUpper:" + conditionLowToUpper("memberIdCode"));
    System.out.println("member conditionLowToUpper:" + conditionLowToUpper("member"));

    //        System.out.println("MemberAddressInDTO classNameLowToUpper:" + classNameLowToUpper(MemberAddressInDTO.class));
    System.out.println("Cipher classNameLowToUpper:" + classNameLowToUpper(Cipher.class));
    //        System.out.println("MemberAddressInDTO classNameLowToUpper:" + classNameLowToUpper("member"));
    }
     */
}
