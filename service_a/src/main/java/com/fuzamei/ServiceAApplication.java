package com.fuzamei;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
@RestController
@RequestMapping("/servicea")
public class ServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	@Value("${test.param}")
	private String param;

	@RequestMapping("/test")
	public String test(){
		return "this is a microservice-a test {"+param+"}";
	}

	@RequestMapping("/logTest")
	public String logTest(){
		log.trace("this if TRACE log");
		log.debug("this if DEBUG log");
		log.info("this if INFO log");
		log.warn("this if WARN log");
		log.error("this if ERROR log");
		return "success";
	}

}

