package com.estock.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.estock.document.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, Integer>{
			
	@Query("{$and: [{tDate: {$lte: ?0}},{tDate: {$gte:?1}},{cmpCode:?2}]}")
	List<Stock> findStockBycmpCodeandDate(String toDate, String fromDate, String cmpCode);
	
	@Query("{ 'cmpCode' : ?0 }")
	List<Stock> findStockBycmpCode(String cmpcode);
	
	

}
