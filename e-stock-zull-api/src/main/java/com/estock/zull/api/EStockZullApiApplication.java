package com.estock.zull.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EStockZullApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStockZullApiApplication.class, args);
	}

}
