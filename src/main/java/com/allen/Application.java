package com.allen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务支持
@MapperScan("com.allen.dao")//扫描mybatis的Mapper类所在目录
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//要排除DataSourceAutoConfiguration，否则多数据源无法配置
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
