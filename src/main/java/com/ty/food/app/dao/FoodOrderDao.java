package com.ty.food.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.app.dto.FoodOrder;

public class FoodOrderDao {

	public void saveFoodOrder(FoodOrder foodOrder) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(foodOrder);
		transaction.commit();
	}

	public boolean cancelFoodOrder(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodOrder foodorder = manager.find(FoodOrder.class, id);

		if (foodorder != null) {
			transaction.begin();
			manager.remove(foodorder);
			transaction.commit();
			return true;
		}

		return false;
	}

	public boolean updateFoodOrder(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodOrder foodorder = manager.find(FoodOrder.class, id);
		if (foodorder != null) {
			transaction.begin();
			foodorder.setStatus(true);
			transaction.commit();
			return true;
		}
		return false;

	}

}
