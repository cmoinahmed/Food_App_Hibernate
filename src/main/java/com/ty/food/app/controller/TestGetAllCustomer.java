package com.ty.food.app.controller;

import com.ty.food.app.dao.CustomerDao;

public class TestGetAllCustomer {

	public static void main(String[] args) {
		CustomerDao customerdao = new CustomerDao();
		customerdao.getAllCustomers();
		System.out.println("--All Customer--");

	}

}
