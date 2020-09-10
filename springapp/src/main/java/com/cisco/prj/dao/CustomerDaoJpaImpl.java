package com.cisco.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Customer;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addCustomer(Customer c) {
		em.persist(c);
	}

	@Override
	public List<Customer> getByFirstName(String name) {
//		String jpql = "from Customer where firstName = '" + name + "'";
		String jpql = "from Customer where firstName = :n";
		TypedQuery<Customer> query = em.createQuery(jpql,Customer.class);
		query.setParameter("n", name);
		return query.getResultList();
	}

}
