package com.gamaset.betroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.gamaset.betroom.infra.filter.SimpleCORSFilter;


@SpringBootApplication
public class BetroomApplication {

	@Autowired
	private SimpleCORSFilter simpleCORSFilter;

	/**
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(simpleCORSFilter);
		registration.addUrlPatterns("/*");
		registration.setName("simpleCORSFilter");

		return registration;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BetroomApplication.class, args);
	}
}
