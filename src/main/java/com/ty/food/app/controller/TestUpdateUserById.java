package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.UserDao;

public class TestUpdateUserById {

	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		userdao.updateUser(id);
		System.out.println("--User Updated--");

	}

}
