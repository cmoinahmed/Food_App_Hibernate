package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.UserDao;
import com.ty.food.app.dto.User;

public class TestValidateUser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the email");
		String email = scan.next();
		System.out.println("enter the password");
		String password = scan.next();

		UserDao userdao = new UserDao();
		User user = userdao.validateUser(email, password);
		if (user != null) {
			System.out.println("vaidation successfull");
		} else {
			System.out.println("check email and passsword");
		}

	}
}
