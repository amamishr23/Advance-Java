package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	public void insertProduct(Product p) {
		productDao.addProduct(p);
	}
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public Product getProduct(int id) {
		return productDao.getById(id);
	}
}
