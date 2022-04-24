package com.example.Coupons.Controller;

import com.example.Coupons.Model.Coupon;
import com.example.Coupons.Service.CouponService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/coupon")
public class CouponController {
	
	  private final CouponService couponService;

	    @Autowired
	    public CouponController(CouponService couponService) {
	        this.couponService = couponService;
	    }
	    
	    Logger logger = LoggerFactory.getLogger(CouponController.class);

	//to get all coupons
    @GetMapping(value = "/list")
    public List<Coupon> getAllCoupons(){
    	logger.info("logger info get all coupons");
		logger.trace("logger get all coupons activated");
    	logger.error("Error happend in get all coupons");
        return couponService.getAllCoupons();
    }
    
    //to get coupon by provider
    @GetMapping("/findcoupon/{provider}")
	public List<Coupon> findByprovider(@PathVariable("provider") String provider)
	{
    	logger.info("logger info find by provider ");
		logger.trace("find by provider is activated");
    	logger.error("Error happend in find by provider ");
	  return couponService.findByprovider(provider);
	}
    
    //to get coupon by id
    @GetMapping("Find/{id}")
    public Optional<Coupon> findById(@PathVariable("id") String id){
    	logger.info("logger info find by id");
		logger.trace("logger findByid activated");
    	logger.error("Error happend in find by id");
    	return couponService.findById(id);
    }
    
    //get coupons by category
    @GetMapping("Findby/{category}")
    public List<Optional<Coupon>> searchCouponByCategory(@PathVariable("category") String category) {
    	logger.info("logger info searchCouponByCategory");
		logger.trace("logger searchCouponByCategory activated");
    	logger.error("Error happend in searchCouponByCategory");
    	List<Optional<Coupon>> coupon = couponService.findByCategory(category);
		return coupon;
	}
    
    //add coupon
    @PostMapping(value = "/add")
    public String addCoupon(@RequestBody Coupon coupon){
    	logger.info("logger info addCoupon");
		logger.trace("logger addCoupon activated");
    	logger.error("Error happend in addCoupon");
    	couponService.addCoupon(coupon);
        return "Coupon Added Successfully";
    }
    
    //delete coupon
    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
    	logger.info("logger info deleteProduct");
		logger.trace("logger deleteProduct activated");
    	logger.error("Error happend in deleteProduct");
    	couponService.deleteCoupon(id);
        return "Coupon Deleted Successfully";
    }
    
    //update coupon
    @PutMapping(value = "/update/{id}")
    public Coupon updateCoupon(@RequestBody Coupon coupon, @PathVariable String id){
    	logger.info("logger info updateCoupon");
		logger.trace("logger updateCoupon activated");
    	logger.error("Error happend in updateCoupon");
        return couponService.updateCoupon(coupon, id);

    }
}
