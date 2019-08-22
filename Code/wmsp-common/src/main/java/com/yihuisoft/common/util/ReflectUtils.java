package com.yihuisoft.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author tonywu
 * @version v1.0.0
 */
public class ReflectUtils {

    /**
     * 获取成员变量的修饰符
     *
     * @param clazz 类对象
     * @param field 字段名称
     * @return 各访问修饰符对应的整数
     * @throws Exception 如果没有查到指定的字段则抛出Exception
     */
    public static <T> int getFieldModifier(Class<T> clazz, String field) throws Exception {
        // getDeclaredFields可以获取所有修饰符的成员变量，包括private,protected等getFields则不可以
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                return fields[i].getModifiers();
            }
        }
        throw new Exception(clazz + " has no field \"" + field + "\"");
    }

    /**
     * [对象]根据成员变量名称获取其值
     *
     * @param clazzInstance 对象实例
     * @param field 字段名称
     * @return 返回该对象指定变量的值
     * @throws IllegalAccessException 无权限访问该变量
     */
    public static <T> Object getFieldValue(Object clazzInstance, Object field) throws IllegalAccessException {

        Field[] fields = clazzInstance.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                // 对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
                fields[i].setAccessible(true);
                return fields[i].get(clazzInstance);
            }
        }
        return null;
    }

    /**
     * [类]根据成员变量名称获取其值（默认值）
     *
     * @param clazz Class 实例
     * @param field 字段
     * @return 该字段对应的值
     * @throws IllegalAccessException 没有权限访问该字段
     * @throws InstantiationException 类实例化出错
     */
    public static <T> Object getFieldValue(Class<T> clazz, String field) throws IllegalAccessException, InstantiationException {

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                // 对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
                fields[i].setAccessible(true);
                return fields[i].get(clazz.newInstance());
            }
        }

        return null;
    }

    /**
     * 获取所有的成员变量(通过GET，SET方法获取)
     *
     * @param clazz Class 对象
     * @return 变量数组
     */
    public static <T> String[] getFields(Class<T> clazz) {

        Field[] fields = clazz.getDeclaredFields();

        String[] fieldsArray = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fieldsArray[i] = fields[i].getName();
        }

        return fieldsArray;
    }

    /**
     * 获取所有的成员变量,包括父类
     *
     * @param clazz Class对象
     * @param superClass 是否包括父类
     * @return 字段数组
     * @throws Exception
     */
    public static <T> Field[] getFields(Class<T> clazz, boolean superClass) throws Exception {

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = null;
        if (superClass) {
            Class superClazz = clazz.getSuperclass();
            if (superClazz != null) {
                superFields = superClazz.getDeclaredFields();
            }
        }

        Field[] allFields = null;

        if (superFields == null || superFields.length == 0) {
            allFields = fields;
        } else {
            allFields = new Field[fields.length + superFields.length];
            System.arraycopy(fields, 0, allFields, 0, fields.length);
            System.arraycopy(superFields, 0, allFields, superFields.length, superFields.length);
        }

        return allFields;
    }

    /**
     * 获取所有的成员变量,包括父类
     *
     * @param clazz  Class 实例
     * @return 所有成员变量（包括父类）数组
     * @throws Exception
     */
    public static <T> Field[] getClassFieldsAndSuperClassFields(Class<T> clazz) throws Exception {

        Field[] fields = clazz.getDeclaredFields();

        if (clazz.getSuperclass() == null) {
            throw new Exception(clazz.getName() + "没有父类");
        }

        Field[] superFields = clazz.getSuperclass().getDeclaredFields();
        Field[] allFields = new Field[fields.length + superFields.length];
        System.arraycopy(fields, 0, allFields, 0, fields.length);
        System.arraycopy(superFields, 0, allFields, superFields.length, superFields.length);
        return allFields;
    }

    /**
     * 指定类，调用指定的无参方法
     *
     * @param clazz  Class实例
     * @param method 方法名
     * @return 调用结果
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> Object invoke(Class<T> clazz, String method) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object instance = clazz.newInstance();
        Method m = clazz.getMethod(method, new Class[]{});
        return m.invoke(instance, new Object[]{});
    }

    /**
     * 通过对象，访问其方法
     *
     * @param clazzInstance 类实例
     * @param method 方法名
     * @return 调用响应结果
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> Object invoke(Object clazzInstance, String method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method m = clazzInstance.getClass().getMethod(method, new Class[]{});
        return m.invoke(clazzInstance, new Object[]{});
    }

    /**
     * 指定类，调用指定的方法
     *
     * @param clazz Class实例
     * @param method 方法名
     * @param paramClasses 方法参数数组
     * @param params 参数值
     * @return Object 调用响应结果
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <T> Object invoke(Class<T> clazz, String method, Class<T>[] paramClasses, Object[] params) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object instance = clazz.newInstance();
        Method m = clazz.getMethod(method, paramClasses);
        return m.invoke(instance, params);
    }

    /**
     * 通过类的实例，调用指定的方法
     *
     * @param clazzInstance 类实例
     * @param method 方法名
     * @param paramClasses 参数数组
     * @param params 参数对象
     * @return 调用返回值
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <T> Object invoke(Object clazzInstance, String method, Class<T>[] paramClasses, Object[] params) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method m = clazzInstance.getClass().getMethod(method, paramClasses);
        return m.invoke(clazzInstance, params);
    }
}
