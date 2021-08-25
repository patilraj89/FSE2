package com.estock.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.estock.repository.StockRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = StockRepository.class)
public class EStockStockRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStockStockRegistrationApplication.class, args);
	}

}
