package com.product.beststore.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class Productdto {
	
	@NotEmpty(message="Name should not be empty")
	private String name;
	@NotEmpty(message="brand should not be empty")
	private String brand;
	@NotEmpty(message="category should not be empty")
	private String category;
	@Min(0)
	private double price;
	
	@Size(min=10,message="description should be atleast 10 characters")
	@Size(max=2000,message="description should not exceed  2000 characters")
	private String description;
	
	private MultipartFile imageFile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getimageFile() {
		return imageFile;
	}

	public void setimageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	
}
