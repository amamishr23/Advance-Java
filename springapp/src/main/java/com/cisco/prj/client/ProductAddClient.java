package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class ProductAddClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);

		Product p = new Product(0,"LG AC", 45000.00,200);
		os.insertProduct(p);
		System.out.println("added!!!");
	}

}
