package com.cisco.prj.client;

import java.lang.reflect.Method;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
		displayExpensive(products);
		dispayDetails(products);
		System.out.println("********************************");
		displayOCPway(products);
	}
	
	// OCP way using Java Reflection API
	private static void displayOCPway(Product[] products) {
		for(Product p : products) {
			Method[] methods = p.getClass().getMethods(); // methods of Tv/Mobile + Product + Object
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(p);
						System.out.println(ret);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("********************************");
		}
	}

	//  Not OCP
	private static void dispayDetails(Product[] products) {
		for (Product p : products) {
			System.out.println(p.getName() + "," + p.getPrice());
			if (p instanceof Tv) {
				Tv t = (Tv) p;
				System.out.println(t.getScreenType());
			} else if (p.getClass() == Mobile.class) {
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
		}
	}
	
	// OCP ==> Open for extension, closed for a change
	private static void displayExpensive(Product[] products) {
		for (Product p : products) {
			if (p.isExpensive()) { // polymorphic, Dynamic binding
				System.out.println(p.getName() + " is expensive !!!");
			} else {
				System.out.println(p.getName() + " is not expensive !!!");
			}
		}
	}

}
