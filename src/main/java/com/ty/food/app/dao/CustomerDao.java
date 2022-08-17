package com.ty.food.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.app.dto.Customer;

public class CustomerDao {

	public void saveCustomer(Customer customer) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(customer);
		transaction.commit();

	}

	public boolean deleteCustomer(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Customer customer = manager.find(Customer.class, id);

		if (customer != null) {
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
			return true;

		}

		return false;

	}

	public void updateCustomer(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Customer customer = manager.find(Customer.class, id);
		if (customer != null) {
			transaction.begin();
			customer.setName("Shareef");
			transaction.commit();
		}

	}

	public void getAllCustomers() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select c from Customer c";

		Query query = manager.createQuery(jpql);
		List<Customer> list = query.getResultList();
		if (list != null) {
			System.out.println(list);
		}

	}

	public Customer getCustomerById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select c from Customer c where c.id=?1";

		Query query = manager.createQuery(jpql);
		query.setParameter(1, id);

		List<Customer> list = query.getResultList();

		for (Customer c : list) {
			System.out.println(c);
			return c;
		}
		return null;

	}

}
