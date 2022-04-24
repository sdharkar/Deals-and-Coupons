package com.customer.service;

import com.customer.model.Customer;
import com.customer.model.RatingReview;

import java.util.List;

public interface CustomerService {

	public Customer findByUsername(String username);

	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer);

	public RatingReview giveRatingAndReview(RatingReview ratingReview);


}
