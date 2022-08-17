package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.CustomerDao;

public class TestUpdateCustomerById {

	public static void main(String[] args) {
		CustomerDao customerdao = new CustomerDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = scan.nextInt();
		customerdao.updateCustomer(id);
		System.out.println("--Data Updated--");

	}

}
