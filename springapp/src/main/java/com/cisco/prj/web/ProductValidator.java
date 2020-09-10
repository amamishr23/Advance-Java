package com.cisco.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cisco.prj.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name", "Product Name is required!!");
		Product p = (Product) target;
		if(p.getPrice() < 0) {
			errors.rejectValue("price", "product.price" , "Product Price should be more than zero");
		}
		if(p.getQuantity() < 0) {
			errors.rejectValue("quantity", "product.qty" , "Product Quantity should be more than zero");
		}
	}

}
