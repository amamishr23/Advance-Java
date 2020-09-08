package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cisco.prj.entity.Product;

public class StreamExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		
		products.stream()
			.filter(p -> p.getCategory().equals("mobile"))
			.forEach(p -> System.out.println(p));
	
		System.out.println("*********");
		
		List<String> names = products.stream()
						.map(p -> p.getName())
						.collect(Collectors.toList());
						
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("*********");
		
		
		double amount = products.stream()
							.filter(p -> p.getCategory().equals("mobile"))
							.map(p -> p.getPrice())
							.reduce(0.0, (v1,v2) -> v1 + v2);
		
		System.out.println(amount);
		
		System.out.println("*********");
		
		DoubleSummaryStatistics stats = 
					products.stream()
					.collect(Collectors.summarizingDouble(p -> p.getPrice()));
		
		System.out.println("Max : " + stats.getMax());
		System.out.println("Min : " + stats.getMin());
		System.out.println("Sum : " + stats.getSum());
		
		System.out.println("************");
 
		Map<String, List<Product>> map = products.stream()
 			.collect(Collectors.groupingBy(p -> p.getCategory()));
		
		map.forEach((k,v) -> {
			System.out.println("Category : " +  k);
			v.forEach(System.out::println);
		}); 
		
//		Map<String,List<Product>> mymap = new HashMap<>();
//		
//		for(Product p : products) {
//			if(mymap.containsKey(p.getCategory())) {
//				List<Product> list = mymap.get(p.getCategory());
//				list.add(p);
//				mymap.put(p.getCategory(), list);
//			} else {
//				List<Product> list = new ArrayList<>();
//				list.add(p);
//				mymap.put(p.getCategory(), list);
//			}
//		}
//		
//		System.out.println(mymap);
	}

}
