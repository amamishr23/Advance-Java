package com.cisco.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Product;

@Repository
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addProduct(Product p) {
		em.persist(p);
	}

	@Override
	public List<Product> getProducts() {
		String JPQL = "from Product";
		TypedQuery<Product> query = em.createQuery(JPQL, Product.class);
		return query.getResultList();
	}

	@Override
	public Product getById(int id) {
		return em.find(Product.class, id);
	}

}
