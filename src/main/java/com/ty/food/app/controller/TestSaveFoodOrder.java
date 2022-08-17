package com.ty.food.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ty.food.app.dao.CustomerDao;
import com.ty.food.app.dao.FoodMenuDao;
import com.ty.food.app.dao.FoodOrderDao;
import com.ty.food.app.dto.FoodMenu;
import com.ty.food.app.dto.FoodOrder;
import com.ty.food.app.dto.OrderItem;

public class TestSaveFoodOrder {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		FoodOrder foodOrder = new FoodOrder();

		System.out.println("Enter Customer Id");
		int id = scan.nextInt();

		foodOrder.setCustomer(new CustomerDao().getCustomerById(id));

		boolean loop = true;

		List<OrderItem> items = new ArrayList<OrderItem>();
		int foodOrderCost = 0;

		TestGetAllFoodMenu.main(args);

		while (loop) {

			System.out.println("Press 1: Select Food Items");
			System.out.println("Press 2: EXIT");
			int choice = scan.nextInt();

			if (choice == 1) {

				System.out.println("ENTER THE FOOD ID");
				int foodId = scan.nextInt();
				System.out.println("ENTER THE FOOD QUANTITY");
				int quantity = scan.nextInt();

				FoodMenu foodMenu = new FoodMenuDao().getFoodMenuById(foodId);
				OrderItem item = new OrderItem();
				item.setName(foodMenu.getName());
				double cost = foodMenu.getCost();
				foodOrderCost += cost * quantity;
				item.setCost(cost * quantity);
				item.setQty(quantity);
				item.setFoodOrder(foodOrder);
				items.add(item);

			} else {

				loop = false;
			}

		}

		foodOrder.setItems(items);
		foodOrder.setStatus(true);
		foodOrder.setCost(foodOrderCost);

		FoodOrderDao dao = new FoodOrderDao();
		dao.saveFoodOrder(foodOrder);

		System.out.println("data is saved");
	}
}
