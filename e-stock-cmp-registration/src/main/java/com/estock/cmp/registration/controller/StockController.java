package com.estock.cmp.registration.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.cmp.registration.model.Stock;
import com.estock.cmp.registration.model.StockRepository;
import com.estock.cmp.registration.pojo.CmpStock;


@RestController
@RequestMapping("/api/v1/market/stock")
public class StockController {
	
	@Autowired(required=true)
	private StockRepository stockRepotory;
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<String> addStock(@RequestBody Stock stock) {
		stock.settDate(LocalDate.now().toString());
		stock.setTime(currentDateTime());
		System.out.println("Stock="+stock);
		System.out.println("Stock="+stock);
		System.out.println("Stock="+stock);
		stockRepotory.save(stock);
		return new ResponseEntity<>("Stock Added Succesfully",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/get/{cmpcode}/{fdate}/{tdate}")
	public CmpStock getStock(@PathVariable("cmpcode") String cCode, @PathVariable("fdate") String fdt, @PathVariable("tdate") String tdt) {
		CmpStock resRes = new CmpStock();
		System.out.println("CCODE:"+cCode);
		System.out.println("FDATE:"+fdt);
		System.out.println("TDATE:"+tdt);		
		List<Stock> res = stockRepotory.findStockBycmpCode(cCode);	
		System.out.println("Res="+res);
		List<Stock> fRes = res.stream().filter(x->(getDate(x.gettDate()).after(getDate(fdt)) || getDate(x.gettDate()).equals(getDate(fdt))) && (getDate(x.gettDate()).before(getDate(tdt)) || getDate(x.gettDate()).equals(getDate(tdt)))).collect(Collectors.toList());
		resRes.setStockData(fRes);
		
		DoubleSummaryStatistics stats = fRes.stream()
                .mapToDouble(n -> n.getStockPrice())
                .summaryStatistics();
		resRes.setAvgVal(BigDecimal.valueOf(stats.getAverage())
			    .setScale(2, RoundingMode.HALF_UP)
			    .doubleValue());
		resRes.setMaxVal(BigDecimal.valueOf(stats.getMax())
			    .setScale(2, RoundingMode.HALF_UP)
			    .doubleValue());
		resRes.setMinVal(BigDecimal.valueOf(stats.getMin())
			    .setScale(2, RoundingMode.HALF_UP)
			    .doubleValue());
		return resRes;
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
	
	public static String currentDateTime() {
	    Calendar c = Calendar.getInstance();
	    SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss aa");
	    String datetime = dateformat.format(c.getTime());
	    return datetime;
	}

}
