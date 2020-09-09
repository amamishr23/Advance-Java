package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class SpringClient {

	public static void main(String[] args) {
		// metadata is in XML
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		// metadata is annoation based
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
//		OrderService os = (OrderService) ctx.getBean("orderService");
		OrderService os = ctx.getBean("orderService", OrderService.class);
		
		Product p = new Product();
		os.insertProduct(p);
		
		System.out.println("*************");
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name: names) {
			System.out.println(name);
		}
	}

}
