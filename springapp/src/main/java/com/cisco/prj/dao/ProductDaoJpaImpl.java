package com.cisco.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Product;

@Repository
public class ProductDaoJpaImpl implements ProductDao {

	@Override
	public void addProduct(Product p) {
		System.out.println("product added using JPA!!!");
	}

	@Override
	public List<Product> getPriducts() {
		return null;
	}

}
