package com.cisco.prj.client;

import java.util.List;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

public class ProductListClient {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				System.out.println(p.getName() + ", " + p.getPrice());
			}
		} catch (DaoException e) {
			e.printStackTrace(); // for Java developers
			System.out.println(e.getMessage()); // for Production stage
		}
		
	}

}
