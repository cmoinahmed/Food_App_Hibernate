package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.FoodMenuDao;

public class TestDeleteFoodMenuById {

	public static void main(String[] args) {
		FoodMenuDao foodmenudao = new FoodMenuDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		foodmenudao.deleteFoodMenu(id);
		System.out.println("--FoodMenu deleted--");

	}

}
