package com.ty.food.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.app.dto.FoodMenu;

public class FoodMenuDao {

	public void saveFoodMenu(List<FoodMenu> foodMenu) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		for (FoodMenu foodmenus : foodMenu) {
			transaction.begin();
			manager.persist(foodmenus);
			transaction.commit();
		}
	}

	public boolean deleteFoodMenu(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodMenu foodmenu = manager.find(FoodMenu.class, id);

		if (foodmenu != null) {
			transaction.begin();
			manager.remove(foodmenu);
			transaction.commit();
			return true;

		}
		return false;
	}

	public void updateFoodMenu(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodMenu foodmenu = manager.find(FoodMenu.class, id);
		if (foodmenu != null) {
			transaction.begin();
			foodmenu.setName("Egg Rice");
			transaction.commit();
		}
	}

	public FoodMenu getFoodMenuById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String q = "select f from FoodMenu f where f.id=?1	";

		Query query = manager.createQuery(q);
		query.setParameter(1, id);

		List<FoodMenu> list = query.getResultList();

		for (FoodMenu f : list) {
			System.out.println(f);
			return f;
		}
		return null;

	}

	public List<FoodMenu> getAllFoodMenu() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select f from FoodMenu f";

		Query query = manager.createQuery(jpql);

		List<FoodMenu> list = query.getResultList();

		if (list != null) {
			System.out.println(list);
			return list;
		}
		return null;

	}

}