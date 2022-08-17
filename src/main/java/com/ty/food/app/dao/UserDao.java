package com.ty.food.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;

import com.ty.food.app.dto.User;

public class UserDao {

	public void saveUser(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(user);
		transaction.commit();

	}

	public boolean deleteUser(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		User user = manager.find(User.class, id);

		if (user != null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return true;
		}

		return false;

	}

	public void updateUser(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		User user = manager.find(User.class, id);

		if (user != null) {
			transaction.begin();
			user.setName("Umar Chand");
			transaction.commit();
		}

	}

	public User validateUser(String email, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select  u  from User u where u.email=?1 and u.password=?2 ";

		Query query = manager.createQuery(jpql);

		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> users = query.getResultList();

		if (users != null) {
			User user = users.get(0);
			return user;

		}

		return null;

	}

	public void getAllUsers() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String q = "select u from User u";

		Query query = manager.createQuery(q);
		List<User> list = query.getResultList();
		if (list != null) {

			System.out.println(list);
		}

	}

	public User getUserById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select u from User u where u.id=?1	";

		Query query = manager.createQuery(jpql);
		query.setParameter(1, id);

		List<User> list = query.getResultList();

		for (User user : list) {
			System.out.println(user);
			return user;
		}
		return null;

	}

}
