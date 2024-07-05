package com.product.beststore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.beststore.model.Productdto;
import com.product.beststore.model.Products;
import com.product.beststore.repository.ProductRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository proRepo;
	
	@GetMapping({"","/"})
	public String showProductList(Model model) {
		System.out.println("hello");
		System.out.println("PUSH");
		List<Products> products = proRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		
		
		//String s=null;
	//	System.out.println(s.charAt(0));
		//System.out.println(products.get(0));
		model.addAttribute("products",products);
		return "products/index";
				
	}
	
	@GetMapping("/create")
	public String createProduct(Model model) {
		Productdto productdto = new Productdto();
		model.addAttribute("productdto",productdto);
		return "products/CreateProduct";
		
	}
	
	@PostMapping("/create")
	public String addproducts(@Valid @ModelAttribute Productdto productdto ,BindingResult result ) {
		if(productdto.getimageFile().isEmpty()) {
			result.addError(new FieldError("pruductdto","imageFile","Image is empty"));
		}
		if(result.hasErrors()) {
			return "products/CreateProduct";
		}
		return "products/index";
	}
	
	
}
