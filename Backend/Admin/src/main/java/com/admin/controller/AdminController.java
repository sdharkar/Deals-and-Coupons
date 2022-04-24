package com.admin.controller;

import com.admin.model.Admin;
import com.admin.model.Coupon;
import com.admin.repository.AdminRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    RestTemplate restTemplate;
    
	@Autowired
	public AdminRepository adminRepository;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//get all users
	@GetMapping(value = "/all")
	public List<Admin> getAllUsers(){
		logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
		return adminRepository.findAll();
	}
	
	//get admin by name
    @GetMapping(value = "/name/{name}")
	public Admin getAdmin(@PathVariable("name") String name) {
    	logger.info("logger info get admin");
		logger.trace("logger get admin activated");
    	logger.error("Error happend in get admin");
		return adminRepository.findByName(name);
	}

    @PostMapping("/add") // Adding new user
    public String addUser(@RequestBody Admin admin){
    	logger.info("logger info add user");
		logger.trace("logger add user activated");
    	logger.error("Error happend in add user");
        adminRepository.save(admin);
        return "Admin Added Succesfully";
    }
	
    @DeleteMapping("/delete/{id}") // deleting user with specific id
    public String deleteAdmin(@PathVariable String id) {
    	logger.info("logger info delete admin");
		logger.trace("logger delete admin activated");
    	logger.error("Error happend in delete admin");
        adminRepository.deleteById(id);
        return "Admin With Id = "+ id +" Deleted Successfully";
    }
	
    @PutMapping("/update/{id}")// updating details of existing admin  
    public String updateAdmin(@RequestBody Admin admin, @PathVariable String id){
    	logger.info("logger info update admin");
		logger.trace("logger update admin activated");
    	logger.error("Error happend in update admin");
        adminRepository.save(admin);
        return "admin is Updated Succesfully";
		
	}

//    <-------------------------------------COUPON-SERVICE--------------------------------->
    
    //get list of coupon
    @GetMapping(value = "/list")
    public List<Coupon> getAllCoupons(){
    	logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
        return Arrays.asList(restTemplate.getForObject("http://coupon-service/coupon/list",Coupon[].class));
    }
    
    //add coupon
    @PostMapping(value = "/addCoupon")
    public  String addCoupon(@RequestBody Coupon coupon){
    	logger.info("logger info addCoupon");
		logger.trace("logger addCoupon activated");
    	logger.error("Error happend in addCoupon");
        return  restTemplate.postForObject("http://coupon-service/coupon/add",coupon,String.class);
    }
    
    //delete coupon
    @DeleteMapping(value = "/delete/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
    	logger.info("logger info deleteProduct");
		logger.trace("logger deleteProduct activated");
    	logger.error("Error happend in deleteProduct");
        restTemplate.delete("http://coupon-service/coupon/delete/{couponID}", couponID, String.class);
        return "Coupon with Id = "+couponID+" Deleted Successfully";
    }
    
    //Update coupon
    @PutMapping(value = "/updateCoupon/{couponID}")
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
    	logger.info("logger info updateCoupon");
		logger.trace("logger updateCoupon activated");
    	logger.error("Error happend in updateCoupon");
        restTemplate.put("http://coupon-service/coupon/update/{couponID}",coupon,couponID,String.class);
        return "coupon Updated Succesfully";
    }

}