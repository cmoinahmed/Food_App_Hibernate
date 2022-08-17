package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.FoodOrderDao;

public class TestCancelFoodOrderById {

	public static void main(String[] args) {

		FoodOrderDao foodorderdao = new FoodOrderDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		boolean m = foodorderdao.cancelFoodOrder(id);
		if (m) {
			System.out.println("ELEMENT DELETED");
		} else {
			System.out.println("ELEMENT IS NOT PRESENT");
		}
	}
}
