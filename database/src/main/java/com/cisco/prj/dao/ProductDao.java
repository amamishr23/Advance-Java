package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Product;

public interface ProductDao {
	void addProduct(Product p) throws DaoException;
	
	List<Product> getProducts() throws DaoException;
}
