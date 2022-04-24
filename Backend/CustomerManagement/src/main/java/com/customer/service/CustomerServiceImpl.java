package com.customer.service;

import com.customer.exceptions.userNameAlreadyExists;
import com.customer.model.RatingReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findByUsername(String username) {
		Customer customer = customerRepository
                .findAll()
                .stream()
                .filter(a -> a.getUsername().equalsIgnoreCase(username))
                .findAny().orElse(null);
		if (customer == null) {
			throw new CustomerNotFoundException("Sorry, Customer with the provided Username not found" +
					",Please provide the correct Username");
		}
		else {
			return customerRepository.findByUsername(username);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {

		customer.setProfile("default.png");
		customer.setRole("Customer");
		Customer customer1 = this.customerRepository.findByUsername(customer.getUsername());
		if (customer1 != null) {
			System.out.println("Customer is already there !!");
			throw new userNameAlreadyExists("Username already present!!!");

		}
		else {
		System.out.println(customer);
		return customerRepository.save(customer);
		}
	}

	@Override
	public RatingReview giveRatingAndReview(RatingReview ratingReview) {
		return null;
	}


}
