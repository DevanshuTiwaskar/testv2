package com.piggybank.piggybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PiggybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiggybankApplication.class, args);
		System.out.println("tushar");
	}

}
/*
 * http://localhost:8080/h2-console
 * 
 * xammp
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true


h2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=
spring.datasource.schema=classpath:/piggybank/src/main/resources/data.sql
spring.h2.console.enabled=true


mariadb
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mariadb://localhost:3306/testdb
spring.datasource.driverClassName=org.mariadb.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=
spring.datasource.schema=classpath:/piggybank/src/main/resources/data.sql
spring.h2.console.enabled=true
*/