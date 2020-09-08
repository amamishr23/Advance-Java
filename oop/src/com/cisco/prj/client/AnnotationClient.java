package com.cisco.prj.client;

import com.cisco.prj.entity.Employee;
import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.util.SQLUtil;

public class AnnotationClient {

	public static void main(String[] args) {
		String SQL = SQLUtil.createSQL(Product.class);
		System.out.println(SQL);
		
		SQL = SQLUtil.createSQL(Employee.class);
		System.out.println(SQL);
		
		
		Product p = new Mobile(12,"iPhone 11", 87000.00, "4G");
		
		SQL = SQLUtil.insertSQL(p);
		System.out.println(SQL);
	}

}
