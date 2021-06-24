package com.estock.cmp.registration.service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.cmp.registration.model.Company;
import com.estock.cmp.registration.model.CompanyRepository;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
    private CompanyRepository repo;
     
    public List<Company> listAll() {
        return repo.findAll();
    }
     
    public void save(Company company) {
        repo.save(company);
    }
     
    public Company get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
