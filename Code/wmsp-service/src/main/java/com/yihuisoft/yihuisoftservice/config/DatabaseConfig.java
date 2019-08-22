package com.yihuisoft.yihuisoftservice.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 数据库配置
 * @author huangxj
 * @version V4.0.0
 * @date 2019/8/1 16:57
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle","oracle");
        properties.setProperty("MySQL","mysql");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }
}