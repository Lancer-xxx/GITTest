package com.yihuisoft.common.util;

import com.yihuisoft.common.constant.CommonConstants;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 * 配置文件读取工具类
 *
 * @author zhangsh
 * @version V4.0.2
 * @date 2019/8/13 16:35
 **/
public class PropertiesUtils {
    protected Logger logger = LoggerFactory.getLogger(CommonConstants.SYS_LOG_APP_ERROR);

    private static PropertiesUtils instance;

    private static String configPath = "config/context.properties";

    private PropertiesUtils() {


    }

    public static PropertiesUtils getInstance() {
        if (instance == null) {
            synchronized (PropertiesUtils.class) {
                if (instance == null) {
                    instance = new PropertiesUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化配置文件
     *
     * @return
     */
    public Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties = PropertiesLoaderUtils.loadAllProperties(configPath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("读取配置文件错误" + configPath + e.getMessage(), e);

        }
        return properties;
    }

    /**
     * 根据key值获取配置文件内容
     *
     * @param key
     * @return String
     */
    public static String getProperty(String key) {
        String s = PropertiesUtils.getInstance().initProperties().getProperty(key);
        if (StringUtils.isEmpty(s)) {
            s = "";
        }

        return s;
    }

    /**
     * 根据key值获取配置文件数组内容
     *
     * @param key
     * @return String
     */
    public static String[] getProperties(String key) {
        String[] arrray = new String[]{};
        String s = PropertiesUtils.getInstance().initProperties().getProperty(key);
        if (!StringUtils.isEmpty(s)) {
            arrray = s.split(",");
            if (ArrayUtils.isEmpty(arrray)) {
                arrray = new String[]{};
            }
        }


        return arrray;
    }
}