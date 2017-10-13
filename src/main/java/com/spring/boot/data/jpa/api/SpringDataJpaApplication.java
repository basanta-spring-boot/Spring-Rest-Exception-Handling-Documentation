package com.spring.boot.data.jpa.api;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Basant Referral Link to genearate RestDocumentaion in Spring boot
 *         http://jsondoc.org/how-to-spring-boot.html
 * 
 *         in normal Spring MVC Referral Link
 *         http://jsondoc.org/how-to-springmvc.html
 */
@SpringBootApplication
@EnableJSONDoc

public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
}
