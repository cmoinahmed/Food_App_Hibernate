package com.ty.food.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.food.app.dao.FoodMenuDao;
import com.ty.food.app.dto.FoodMenu;

public class TestSaveFoodMenu {

	public static void main(String[] args) {
		FoodMenu foodmenu = new FoodMenu();
		FoodMenuDao foodmenudao = new FoodMenuDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name, Description, Cost");
		String name = scan.next();
		String description = scan.next();
		int cost = scan.nextInt();
		List<FoodMenu> list = new ArrayList<FoodMenu>();
		foodmenu.setName(name);
		foodmenu.setDescription(description);
		foodmenu.setCost(cost);
		list.add(foodmenu);
		foodmenudao.saveFoodMenu(list);
		System.out.println("--Food_Menu Saved--");

	}

}
