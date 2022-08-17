package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.UserDao;
import com.ty.food.app.dto.User;

public class TestSaveUser {

	public static void main(String[] args) {
		User user = new User();
		UserDao userdao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name, Email, Phone, Password, Role");
		String name = scan.next();
		String email = scan.next();
		long phone = scan.nextLong();
		String password = scan.next();
		String role = scan.next();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setRole(role);
		userdao.saveUser(user);
		System.out.println("--User Data Saved--");

	}

}
