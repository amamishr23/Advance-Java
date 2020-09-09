package com.cisco.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired(required = false)
	@Qualifier("productDaoJpaImpl")
	private ProductDao productDao;
	
	public void insertProduct(Product p) {
		productDao.addProduct(p);
	}
}
