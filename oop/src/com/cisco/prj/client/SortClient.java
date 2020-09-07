package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;
import com.cisco.prj.util.ArrayUtil;

public class SortClient {

	public static void main(String[] args) {
		String[] names = {"George", "Lee", "Angelina", "Brad" , "Clooney" };
		
		ArrayUtil.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");

		
		ArrayUtil.sort(products); 
		
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
