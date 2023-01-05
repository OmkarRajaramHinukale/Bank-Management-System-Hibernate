package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerGetByIdController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.getCustomerById(1);
	}
}
