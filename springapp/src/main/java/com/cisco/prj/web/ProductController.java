package com.cisco.prj.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@Controller
public class ProductController {
	@Autowired
	private OrderService service;

	@Autowired
	private ProductValidator validator;

	@RequestMapping("getProducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", service.getProducts());
		mav.setViewName("list.jsp");
		return mav;
	}

	@RequestMapping("productForm.do")
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new Product());
		mav.setViewName("productForm.jsp");
		return mav;
	}

	@RequestMapping("addProduct.do")
	public String addProduct(@ModelAttribute("product") Product p, BindingResult errors, Model m) {
		System.out.println(p.getManufacturedDate());
		validator.validate(p, errors);
		if (errors.hasErrors()) {
			return "productForm.jsp";
		} else {
			service.insertProduct(p);
			m.addAttribute("msg", "Product " + p.getName() + " added!!!");
			return "index.jsp";
		}
	}
	
	@InitBinder
	public void webDataBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateConvertor());
	}
}
