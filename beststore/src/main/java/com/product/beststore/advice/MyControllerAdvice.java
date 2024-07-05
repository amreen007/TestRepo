package com.product.beststore.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointer(NullPointerException nullpointer,Model model) {
		model.addAttribute("NullPointerError", "We cannot find the record for given Id, Please chheck and try again");
		
		return "products/GlobalException";
	}
	

}
