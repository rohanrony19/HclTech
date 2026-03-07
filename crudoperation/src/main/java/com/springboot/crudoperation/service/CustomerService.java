package com.springboot.crudoperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudoperation.exception.CustomException;
import com.springboot.crudoperation.model.Address;
import com.springboot.crudoperation.model.Company;
import com.springboot.crudoperation.model.Customer;
import com.springboot.crudoperation.repository.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo cr;
		
	@Autowired
	public CustomerService(CustomerRepo cus) {
		this.cr = cus;
	}
	
	public void save(Customer cus) {
		cr.save(cus);
	}
	
	public List<Customer> getAll() {
		return cr.findAll();
	}
	
	public Customer findById(int id) throws CustomException {
		return cr.findById(id).orElseThrow(()->new CustomException("Id not found"));
	}
	
	public void deleteByName(String name) {
		cr.deleteByfirstName(name);
	}
	
	public Customer updateCustomer(Integer id, Customer update) {
		 
	    Customer existing = cr.findById(id)
	            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
 
	    
	    existing.setFirstName(update.getFirstName());
	    existing.setLastName(update.getLastName());
	    existing.setEmail(update.getEmail());
	    existing.setPhone(update.getPhone());
	    existing.setImage_url(update.getImage_url());
	    existing.setUsername(update.getUsername());
	    existing.setPassword(update.getPassword());
	    existing.setBirthDate(update.getBirthDate());
	    existing.setGender(update.getGender());
 
	    // Update embedded Address
	    if (existing.getAddress() == null) {
	        existing.setAddress(new Address());
	    }
	    existing.getAddress().setStreet(update.getAddress().getStreet());
	    existing.getAddress().setCity(update.getAddress().getCity());
	    existing.getAddress().setState(update.getAddress().getState());
	    existing.getAddress().setPostalCode(update.getAddress().getPostalCode());
 
	    // Update embedded Company
	    if (existing.getCompany() == null) {
	        existing.setCompany(new Company());
	    }
	    existing.getCompany().setName(update.getCompany().getName());
	    existing.getCompany().setDomain(update.getCompany().getDomain());
 
	    return cr.save(existing);
	}
	
}
