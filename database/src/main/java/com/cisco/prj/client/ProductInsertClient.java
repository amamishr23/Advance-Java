package com.cisco.prj.client;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

public class ProductInsertClient {
	public static void main(String[] args) {
		Product[] products = new Product[4];
		
		products[0] = new Product(0,"iPhone 11", 89000.00, 100);
		products[1] = new Product(0,"Panaonic TV", 79000.00, 100);
		products[2] = new Product(0,"Logitech Mouse", 500.00, 100);
		products[3] = new Product(0,"Camlin Marker Pen", 60.00, 100);
		
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		for(Product p : products) {
			try {
				productDao.addProduct(p);
				System.out.println("product added");
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		
	}

}
