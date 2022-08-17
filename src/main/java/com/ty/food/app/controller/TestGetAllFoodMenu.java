package com.ty.food.app.controller;

import com.ty.food.app.dao.FoodMenuDao;

public class TestGetAllFoodMenu {

	public static void main(String[] args) {
		FoodMenuDao foodmenudao = new FoodMenuDao();
		foodmenudao.getAllFoodMenu();
		System.out.println("-->  FOOD_MENU  <--");

	}

}
