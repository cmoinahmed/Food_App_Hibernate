package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.FoodMenuDao;

public class TestGetFoodMenuById {

	public static void main(String[] args) {
		FoodMenuDao foodmenudao = new FoodMenuDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		foodmenudao.getFoodMenuById(id);
		System.out.println("--FoodMenu Of This Id--");

	}

}
