package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.UserDao;

public class TestDeleteUserById {

	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		userdao.deleteUser(id);
		System.out.println("--User Deleted--");

	}

}
