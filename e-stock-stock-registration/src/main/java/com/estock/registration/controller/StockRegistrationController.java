package com.estock.registration.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.document.Stock;
import com.estock.repository.StockRepository;

@RestController
@RequestMapping("/api/v1/market/stock")
public class StockRegistrationController {
	
	@Autowired(required=true)
	private StockRepository stockRepotory;
	
	
	@PostMapping("/add")
	public String addStock(@RequestBody Stock stock) {
		stock.setDate(LocalDate.now().toString());
		System.out.println("Stock="+stock);
		System.out.println("Stock="+stock);
		stockRepotory.save(stock);
		return "Stock added successfully";
	}
	
	@GetMapping("/get/{cmpcode}/{fdate}/{tdate}")
	public List<Stock> getStock(@PathVariable("cmpcode") String cCode, @PathVariable("fdate") String fdt, @PathVariable("tdate") String tdt) {
		System.out.println("CCODE:"+cCode);
		System.out.println("FDATE:"+fdt);
		System.out.println("TDATE:"+tdt);		
		List<Stock> res = stockRepotory.findStockBycmpCode(cCode);	
		System.out.println("Res="+res);
		List<Stock> fRes = res.stream().filter(x->(getDate(x.getDate()).after(getDate(fdt)) || getDate(x.getDate()).equals(getDate(fdt))) && (getDate(x.getDate()).before(getDate(tdt)) || getDate(x.getDate()).equals(getDate(tdt)))).collect(Collectors.toList());
		return fRes;
	}	
		
	private static Date getDate(String date) {		
		Date date1=null;	    
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return date1;		
	}

}
