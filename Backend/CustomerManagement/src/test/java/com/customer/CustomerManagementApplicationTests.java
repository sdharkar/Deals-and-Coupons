package com.customer;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	@MockBean
	private CustomerRepository customerRepository;


//	@Test
//	public void addCustomer() {
//
//		Customer customer = new Customer(100,"Mason Jones","ms1234",new ArrayList<>(),"XUV","js@gmail.com"
//				,"Customer");
//		when(customerRepository.save(customer)).thenReturn(customer);
//		assertEquals(customer,customerService.addCustomer(customer));
//	}
//
//
//	@Test
//	public void getCustomerById(){
//
//		Customer customer = new Customer(100,"Mason Jones","ms1234",new ArrayList<>(),"XUV","js@gmail.com"
//				,"Customer");
//		when(customerService.findById(1)).thenReturn(customer);
//
//	}



}
