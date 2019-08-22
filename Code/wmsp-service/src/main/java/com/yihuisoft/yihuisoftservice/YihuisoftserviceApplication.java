package com.yihuisoft.yihuisoftservice;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务应用类
 */
@MapperScan({"com.yihuisoft.*.mapper.*"})
@ComponentScan("com.yihuisoft")
@SpringBootApplication
public class YihuisoftserviceApplication {
	/**
	 * 主main函数
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(YihuisoftserviceApplication.class, args);
	}
}
