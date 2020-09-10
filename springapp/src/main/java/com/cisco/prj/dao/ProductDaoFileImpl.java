package com.cisco.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Product;

@Repository
public class ProductDaoFileImpl implements ProductDao {

	@Override
	public void addProduct(Product p) {
		System.out.println("file Store!!!");
	}

	 

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
