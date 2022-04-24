package com.admin.model;

import org.springframework.data.annotation.Id;


public class Coupon {

    @Id
    private String id;
    private String category;
    private String provider;
    private String code;
    private String description;
    private String price;
    

    public Coupon() {
    }


	public Coupon(String id, String category, String provider, String code, String description, String price) {
		super();
		this.id = id;
		this.category = category;
		this.provider = provider;
		this.code = code;
		this.description = description;
		this.price = price;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Coupon [id=" + id + ", category=" + category + ", provider=" + provider + ", code=" + code
				+ ", description=" + description + ", price=" + price + "]";
	}
	
}
