package com.customer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	    public List<Customer> findAll();
	    
	    public Customer findByUsername(String username);
	    

		
}
