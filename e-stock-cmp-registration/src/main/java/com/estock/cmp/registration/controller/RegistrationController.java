package com.estock.cmp.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.cmp.registration.model.Company;
import com.estock.cmp.registration.service.CompanyService;

@RestController()
@RequestMapping("/api/v1/market/company")
public class RegistrationController {
	
	@Autowired
    private CompanyService service;

	@CrossOrigin
	@PostMapping("/register")
	public List<Company> saveCompany(@RequestBody Company company){	
		System.out.println("Data="+company);
		service.save(company);
		return service.listAll();
		
	}
	
	@CrossOrigin
	@GetMapping("/info/{companycode}")
	public Company getCmpInfo(@PathVariable("companycode") int companycode){		
		return service.get(companycode);
	}
	
	@CrossOrigin
	@GetMapping("/getall")
	public List<Company> getAllCmpData(){
		return service.listAll();	
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{companycode}")
	public List<Company> deleteCompany(@PathVariable("companycode") int companycode){
		service.delete(companycode);
		return service.listAll();
	}
	
	
	

}
