package com.estock.cmp.registration.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer>{	
	
	List<Stock> findStockBycmpCode(String cmpcode);

}
