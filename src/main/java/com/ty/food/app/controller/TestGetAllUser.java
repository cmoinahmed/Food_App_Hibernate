package com.ty.food.app.controller;

import com.ty.food.app.dao.UserDao;

public class TestGetAllUser {

	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		userdao.getAllUsers();
		System.out.println("All the User");

	}

}
