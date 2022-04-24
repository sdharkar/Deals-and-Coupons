package com.customer.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.customer.model.AuthenticationRequest;
import com.customer.model.AuthenticationResponse;
import com.customer.repository.CustomerRepository;
import com.customer.service.MyUserDetailsService;
import com.customer.util.JwtUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.customer.model.Customer;
import com.customer.service.CustomerServiceImpl;
import com.customer.utilities.GlobalResources;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	private Logger logger = GlobalResources.getLogger(CustomerController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerServiceImpl customerService;

    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		try {
			String methodName = "(addCustomer)";
			logger.info(methodName + "Called");
			System.out.println(customer);
			customerService.addCustomer(customer);
			return ResponseEntity.ok(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	 @GetMapping("/get-customer/{username}")
	    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable("username") String username) {
	        try {
	        	String methodName = "getCustomerByUsername()";
	    		logger.info(methodName + "Called");
	            Customer customer = customerService.findByUsername(username);
	            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }


	@GetMapping("/get-all-customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/authenticate") // Authenticate a Customer (Existing)
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Username or Password!",e);
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}


	@GetMapping("/current-user")
	public Object getCurrentUser(Authentication authentication){
		return authentication.getPrincipal();
	}

}
