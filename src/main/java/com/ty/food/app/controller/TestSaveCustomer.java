package com.ty.food.app.controller;

import java.util.Scanner;

import com.ty.food.app.dao.CustomerDao;
import com.ty.food.app.dto.Customer;

public class TestSaveCustomer {

	public static void main(String[] args) {
		Customer customer = new Customer();
		CustomerDao customerdao = new CustomerDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name, Email, Phone Of Customer");
		String name = scan.next();
		String email = scan.next();
		long phone = scan.nextLong();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		customerdao.saveCustomer(customer);
		System.out.println("--Data Saved--");

	}

}
